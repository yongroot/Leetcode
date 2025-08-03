package leecode;

import java.util.*;

/**
 * 5. 最长回文子串
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome3("abcda"));
        System.out.println(s.longestPalindrome3("babad"));
        System.out.println(s.longestPalindrome3("aaaaa"));
        System.out.println(s.longestPalindrome3("ababababa"));
        System.out.println(s.longestPalindrome3("jjhg上海自来水来自海上oo"));
    }

    /**
     * 使用双指针(收敛)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 2) {
            return chars[0] == chars[1] ? s : String.valueOf(chars[0]);
        }

        // 增加索引提速
        Map<Character, List<Integer>> indexCache = new HashMap<>();
        for (int i = 0; i < length; i++) {
            indexCache.computeIfAbsent(chars[i], c->new ArrayList<>()).add(i);
        }

        int maxLength = 0;
        int start = 0;
        for (int i = 0; i + maxLength < length; i++) {
            List<Integer> indexArr = indexCache.get(chars[i]);
//            if (indexArr != null) {
//                indexCache.put(chars[i], null);
//            } else {
//                continue;
//            }
            for (int j = indexArr.size() - 1; j >= 0; j--) {
                int left = i;
                int right = indexArr.get(j);
                if (left + maxLength > right) {
                    break;
                }

                while (left <= right && right >= 0 && chars[left] == chars[right]) {

                    // success
                    if (left == right || left + 1 == right) {
                        int w = indexArr.get(j) - i;
                        if (w >= maxLength) {
                            maxLength = w;
                            start = i;
                        }
                        break;
                    } else {
                        left++;
                        right--;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength + 1);
    }

    /**
     * 使用双指针(扩散)
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int[] max = new int[2];
        for (int i = 0; i < chars.length; i++) {
            maxLength(chars, i, i, max);
            maxLength(chars, i, i + 1, max);
        }
        return s.substring(max[0], max[1]+1);
    }

    void maxLength(char[]arr, int i, int right, int[]max) {
        int left = i, /*right = i+1,*/ l = i, r = i;
        while (left >=0 && right < arr.length && arr[left] == arr[right]) {
            l = left--;
            r = right++;
        }
        if ((r - l) > (max[1] - max[0])) {
            max[0] = l;
            max[1] = r;
        }
    }

    /**
     * 动态规划
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() <=1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 2) {
            return chars[0] == chars[1] ? s : String.valueOf(chars[0]);
        }

        // dp[i][j] = dp[i+1][j-1] && chars[i]==chars[j]
        boolean[][] dp = new boolean[length][length];

        // init
        for (int i = 0; i < length; i++) dp[i][i] = true;
        for (int i = 1; i < length; i++) dp[i-1][i] = chars[i-1] == chars[i];


        // 依赖左下角结果
        // 从下往上，从右往左遍历
        for (int i = length-3; i >= 0; i--) {
            for (int j = i+2; j < length; j++) {
                dp[i][j] = dp[i+1][j-1] && chars[i]==chars[j];
            }
        }

        // 从右上角开始朝左下角遍历
        for (int j = length-1, m = j; j > 0; j--, m=j) {
            for (int i = 0; m < length && i < length; i++, m++) {
                if (dp[i][m]) {
                    return s.substring(i, m + 1);
                }
            }
        }
        return String.valueOf(chars[0]);
    }
}

