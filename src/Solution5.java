package leecode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 5. 最长回文子串
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome("上海自来水来自海上"));
    }

    /**
     * 使用双指针穷举
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
                    } else {
                        left++;
                        right--;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength + 1);
    }
}

