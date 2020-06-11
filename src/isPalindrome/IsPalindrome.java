package isPalindrome;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {
    public static boolean solution(int x) {
        if (x < 0) return false;
        if (x >= 0 && x < 10) return true;
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);

    }
}
