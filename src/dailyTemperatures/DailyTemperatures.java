package dailyTemperatures;

/**
 * 根据每日气温列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用0来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ret = dailyTemperatures(T);
        for (int l : ret) {
            System.out.println(l);
        }

    }

    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 1) return new int[1];
        int[] ret = new int[len];
        int front = 0;
        for (int i = 0; i < len; i++) {
            front = i + 1;
            while (front < len) {
                if (T[front] > T[i]) {
                    ret[i] = front - i;
                    break;
                }
                front++;
            }
            if (front == len) ret[i] = 0;
        }
        return ret;
    }
}
