package lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int max = 0;
        for (int i = 0; i < s.length() - max; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))) {
                    list.add(s.charAt(j));
                } else {
                    max = max > list.size() ? max : list.size();
                    break;
                }
            }
            if (list.size() == s.length() - i){
                max = list.size();
                break;
            }
        }
        return max;
    }
}
