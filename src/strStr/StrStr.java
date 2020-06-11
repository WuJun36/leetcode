package strStr;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(solution2("hello", "ll"));
    }

    /**
     * 子串逐一比较——线性时间复杂度
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.length() == 1) return i;
                if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
            }

        }
        return -1;
    }

    /**
     * 双指针——线性时间复杂度
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int solution2(String haystack, String needle) {
        int ph = 0, pn = 0, curr_len = 0;
        int lh = haystack.length(), ln = needle.length();
        if (needle == null || ln == 0) return 0;
        if (lh < ln) return -1;
        while (ph < lh - ln + 1) {
            while (haystack.charAt(ph) == needle.charAt(pn)) {
                ph++;
                pn++;
                curr_len++;
                if (curr_len == ln) {
                    return ph - ln;
                }
            }
            ph = ph - curr_len + 1;
            pn = 0;
            curr_len = 0;

        }
        return -1;
    }
}
