package productExceptSelf;

/**
 * 你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ret = solution(nums);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }

    }

    public static int[] solution(int[] nums) {
        int[] ret = new int[nums.length];
        int aheadCurr = 1;
        int backCurr = 1;
        int[] aheadArray = new int[nums.length];
        int[] backArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            aheadCurr *= nums[i];
            backCurr *= nums[nums.length - 1 - i];
            aheadArray[i] = aheadCurr;
            backArray[nums.length - 1 - i] = backCurr;
        }
        ret[0] = backArray[1];
        ret[nums.length - 1] = aheadArray[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ret[i] = aheadArray[i - 1] * backArray[i + 1];
        }

        return ret;
    }
}
