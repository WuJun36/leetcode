package isValid;

import addtwonumber.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */

public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("(([]){})"));
    }

    public static boolean isValid(String s) {
        if(s.length()==1) return false;
        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');

        int len = s.length();
        StringBuilder leftPart = new StringBuilder();
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (left.contains(s.charAt(i))) {
                switch (s.charAt(i)) {
                    case '(':
                        leftPart.append(')');
                        break;
                    case '[':
                        leftPart.append(']');
                        break;
                    case '{':
                        leftPart.append('}');
                        break;
                }
                count++;
            } else {
                if (count == 0 || count > len - i || !leftPart.reverse().toString().equals(s.substring(i, i + count)))
                    return false;
                i += count-1;
                count = 0;
                leftPart = new StringBuilder();

            }
        }
        return count==0;
    }

}
