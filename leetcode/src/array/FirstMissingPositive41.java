package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by miula on 2019/4/10.
 *
 * @author miula
 * @date 2019/04/10
 */
public class FirstMissingPositive41 {

    public static int firstMissingPositive(int[] nums){
        int n = nums.length;
        int i = 0;
        int tmp;
        while (i < n){
            if (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }else {
                i ++;
            }
        }
        for (i = 0; i < n; ++i){
            if (nums[i] != (i + 1)){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args){
        int[] nums = {-1, 1, 2, 3, 5};
        int a = firstMissingPositive(nums);
        System.out.println(a);
    }

}
