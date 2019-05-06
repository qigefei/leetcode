package array;

import java.util.Arrays;

/**
 * Created by miula on 2019/4/30.
 *
 * @author miula
 * @date 2019/04/30
 */
public class RotateArray189 {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2){
            return;
        }
        k = k % length;
        int[] tempNums = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++){
            if (i + k < length){
                nums[i + k] = tempNums[i];
            }else {
                nums[i + k - length] = tempNums[i];
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        if (length < 2){
            return;
        }
        k = k % length;
        reverse(nums, 0, length - 1 - k);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0 , length - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;

        }
    }

    public static void main(String[] args){
        int[] nums = {1,2};
        rotate2(nums, 3);
        System.out.println(nums);
    }

}
