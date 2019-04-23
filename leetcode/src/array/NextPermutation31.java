package array;

import java.util.Arrays;

/**
 * Created by miula on 2019/3/31.
 *
 * @author miula
 * @date 2019/03/31
 */
public class NextPermutation31 {

    //全排序问题，从倒数第k（k=0）个开始遍历，与倒数第一个之间遍历进行比较，a[k] < a[i]进行交换，再对剩下的进行正序排序

    public static void nextPermutation(int[] nums) {
        int size = nums.length;
        if (size <= 1){
            return;
        }
        int tag = 0;
        for (int i = size - 2; i >= 0; i--){
            for (int j = size - 1; j > i; j--){
                if (nums[i] < nums[j]){
                    int tmp;
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    Arrays.sort(nums, i+1, size);
                    tag = 1;
                    i = -1;
                    break;
                }
            }

        }
        if (tag == 0){
            Arrays.sort(nums);
        }
    }


    public static void main(String[] args){
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(nums);
    }

}
