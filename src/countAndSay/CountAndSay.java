package countAndSay;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        return lastSay(countAndSay(n-1));
    }

    public static String lastSay(String last) {
        if (last == "1") return "11";
        int len = last.length();
        char c0 = last.charAt(0);
        int count = 1;
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < len; i++) {
            if (c0 == last.charAt(i)) {
                count++;
            } else {
                ret.append(count).append(c0);
                c0 = last.charAt(i);
                count = 1;
            }

        }

        ret.append(count).append(c0);
        return ret.toString();
    }
}
