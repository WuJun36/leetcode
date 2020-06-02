package addBinary;

/*给你两个二进制字符串，返回它们的和（用二进制表示）
输入非空 字符串且只包含数字1和0
 */

public class addBinary {

    public static void main(String[] args) {
//        System.out.println(addBinarySolution("1010","1011"));
//        System.out.println(Integer.parseInt("11",2));
        System.out.println(solution3("1010", "1011"));
    }

    // TODO 用条件判断来计算
    public static String addBinarySolution(String a, String b) {
        if (a == null || a.isEmpty() || "0".equals(a)) {
            return b;
        }
        if (b == null || b.isEmpty() || "0".equals(b)) {
            return a;
        }

        String ret = "";
        int index = 1;
        int add = 0;
        while (index <= Math.max(a.length(), b.length())) {
            char aChar = '0';
            char bChar = '0';
            if (index <= a.length()) {
                aChar = a.charAt(a.length() - index);
            }
            if (index <= b.length()) {
                bChar = b.charAt(b.length() - index);
            }
            if (aChar == bChar && aChar == '0') {
                ret = add + ret;
                add = 0;
            } else if (aChar == bChar && aChar == '1') {
                ret = add + ret;
                add = 1;
            } else if (add == 1) {
                ret = 0 + ret;
                add = 1;
            } else {
                ret = 1 + ret;
                add = 0;
            }
            index++;
        }
        if (add == 1) {
            ret = add + ret;
        }


        return ret;
    }

    // TODO 内置函数的简单方法，但不适合很长的字符串
    public static String solution2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    // TODO 逐位计算法
    public static String solution3(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return solution2(b, a);
        int len = Math.max(n, m);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for (int i = len - 1; i > -1; i--) {
            if (a.charAt(i) == '1') carry++;
            if (j > -1 && b.charAt(j--) == '1') carry++;
            if (carry % 2 == 1) sb.append("1");
            else sb.append("0");

            carry /= 2;
        }
        if(carry == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
