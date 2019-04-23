package array;

/**
 * Created by miula on 2019/3/28.
 *
 * @author miula
 * @date 2019/03/28
 */
public class RemoveDuplicatesfromSortedArray26 {
    private static int removeDuplicates(int[] nums) {
        int cur = 0;
        int pre = 0;
        int len = nums.length;
        for (int i =0; i < len; i++){
            if (i + 1 <len && nums[i] == nums[i+1]){
                cur++;
            }else {
                nums[pre] = nums[i];
                pre++;
                cur++;
            }
        }
        return pre;
    }

    public static void main(String args[]){
        int[] nums =  {1, 1, 2, 2, 3, 4, 5, 6};
        int num = removeDuplicates(nums);
        System.out.println(num);
        System.out.println(nums);
    }
}
