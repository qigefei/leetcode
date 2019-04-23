package array;

/**
 * Created by miula on 2019/3/29.
 *
 * @author miula
 * @date 2019/03/29
 */
public class RemoveElement27 {

    private static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int j = 0;
        for (int i=0; i < len; i++){
            if (nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String args[]){
        int[] nums = {3,1,2,3,4,5,6};
        int val = 3;
        int num = removeElement(nums, val);
        System.out.println(num);
        System.out.println(nums);
    }

}
