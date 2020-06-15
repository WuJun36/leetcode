package longestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"","b"};

        System.out.println(solution2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        if (strs[0].length() == 0) return "";
        int count = 0;
        StringBuilder commonStr = new StringBuilder();
        boolean isShort = false;
        while (!isShort) {
            commonStr.append(strs[0].charAt(count));
            count++;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == 0) return "";
                if (strs[i].length() < count) {
                    isShort = true;
                    break;
                }
                if (!strs[i].startsWith(commonStr.toString())) {
                    return commonStr.deleteCharAt(--count).toString();
                }
            }
            if (count >= strs[0].length()) break;
        }

        return commonStr.toString();
    }

    public static String solution2(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int len = strs[0].length();
        for (String str : strs) {
            len = str.length() < len ? str.length() : len;
        }
        int count = 0;
        StringBuilder commonStr = new StringBuilder();
        while (count < len) {
            commonStr.append(strs[0].charAt(count));
            for (String str : strs) {
                if (!str.startsWith(commonStr.toString())) {
                    return commonStr.deleteCharAt(count).toString();
                }
            }
            count++;

        }

        return commonStr.toString();
    }
}
