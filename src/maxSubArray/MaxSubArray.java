package maxSubArray;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1};
        System.out.println(maxSubArray(nums));

    }

    // 嵌套循环，时间复杂度为O(n^2)
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int max = nums[0];
        int temp;
        for (int i = 0; i < len; i++) {
            temp = nums[i];
            max = temp > max ? temp : max;
            for (int j = i + 1; j < len; j++) {
                temp += nums[j];
                max = temp > max ? temp : max;
            }

        }
        return max;
    }

    //官方解法：动态规划，时间复杂度O(n)，空间复杂度为O(1)
    public static int solution2(int[] nums){
        return nums[0];
    }
}
