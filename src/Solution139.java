package leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 单词拆分
 */
public class Solution139 {

    public static void main(String[] args) {
        Solution139 s = new Solution139();
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if ((j == 0 || dp[j-1]) && wordDictSet.contains(s.substring(j, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
