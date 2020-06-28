package minSubArrayLen;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1};
        System.out.println(minSubArrayLen(s, nums));

    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int len = nums.length, rk = -1, sums = 0;
        int ans = len;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                sums -= nums[i - 1];
            }
            while (rk + 1 < len && sums < s) {
                sums += nums[rk + 1];
                rk++;
            }
            if (sums >= s) ans = Math.min(ans, rk - i + 1);
            if (rk - i + 1 >= len && sums < s) ans = 0;
        }

        return ans;
    }
}
