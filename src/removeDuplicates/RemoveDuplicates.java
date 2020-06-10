package removeDuplicates;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3};
        System.out.println(solution(nums));
        for (int a : nums){
            System.out.println(a);
        }
    }

    public static int solution(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int len = 1;
        int aa = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != aa) {
                aa = nums[i];
                nums[len] = aa;
                len++;
            }
        }

        return len;
    }
}
