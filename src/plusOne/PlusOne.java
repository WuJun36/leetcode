package plusOne;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9};
//        plusOne(digits);
        for (int num : plusOne(digits)) {
            System.out.println(num);
        }

    }

    public static int[] plusOne(int[] digits) {
        if (digits == null) return null;
        int carry = 0;
        int[] ret = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) ret[i + 1] += 1;
            ret[i + 1] += digits[i] + carry;
            carry = ret[i + 1] / 10;
            if (ret[i + 1] / 10 > 0) ret[i + 1] %= 10;
        }
        if (carry == 1){
            ret[0] = 1;
            return ret;
        }
        else return Arrays.copyOfRange(ret,1,ret.length);
    }
}
