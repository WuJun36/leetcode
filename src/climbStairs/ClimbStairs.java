package climbStairs;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(solution2(35));

    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int ret = 1;
        int count = 1;
        while (n - 2 * count >= 0) {
            ret += factorial(n - count) / (factorial(count) * factorial(n - 2 * count));
            count++;
        }
        return ret;
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }

    /**
     * 动态规划：f(x)=f(x-1)+f(x-2);
     *
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }

}
