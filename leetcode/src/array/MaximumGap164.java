package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by miula on 2019/4/25.
 * 计算一个数组排序后的最大间隙
 * @author miula
 * @date 2019/04/25
 */
public class MaximumGap164 {
    //线性复杂度，桶排序实现
    public static int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        //计算桶的间隔和个数
        int gap = (max - min) / (nums.length - 1) + 1;
        int count = (max - min)/gap + 1;
        //如果在一个桶内，最大值和最小值的差就是结果
        if (count == 1){
            return max - min;
        }
        //初始化桶的最大值和最小值
        int[] minV = new int[count];
        int[] maxV = new int[count];

        Arrays.fill(minV, max);
        Arrays.fill(maxV, min);
        Set<Integer> idxSet = new HashSet<>();

        for (int num : nums) {
            int index = (num - min) / gap;
            minV[index] = Math.min(minV[index], num);
            maxV[index] = Math.max(maxV[index], num);
            idxSet.add(index);
        }

        int res = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!idxSet.contains(i)) {
                continue;
            }
            res = Math.max(res, minV[i] - maxV[pre]);
            pre = i;
        }
        return res;
    }

    //常规实现，先排序，排序之后遍历求最大值
    public static int maximumGap2(int[] nums){
        if (nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                continue;
            }
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums = {3, 6, 9, 1};
        int max = maximumGap2(nums);
    }
}
