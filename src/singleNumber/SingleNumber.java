package singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 */

public class SingleNumber {
    public static void main(String[] args) {

        System.out.println(solution2(new int[]{4,2,1,1,2}));
    }

    /**
     * 嵌套循环，不是线性时间复杂度
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        for (int i = 0; i < len; i++) {
            int j;
            for (j = 0; j < len; j++) {
                if (nums[j] == nums[i] && i != j) break;
            }
            if (j == len) return nums[i];

        }
        return 0;
    }

    /**
     * 用HashSet求解
     * @param nums
     */
    public static int solution2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            if(!set.contains(num)) set.add(num);
            else set.remove(num);
        }
        return (int)set.toArray()[0];
    }

    /**
     * 排序后再遍历
     * @param nums
     * @return
     */
    public static int solution3(int[] nums){
        return 0;
    }
}
