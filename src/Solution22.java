package leecode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution22 {

    public static void main(String[] args) {
        Solution22 s = new Solution22();
        List<String> r;

        r = s.generateParenthesis(1);
        assert r.size()==1&&r.get(0).equals("()");


        r = s.generateParenthesis(3);
        HashSet<String> set = new HashSet<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
        assert r.size()==5&& set.containsAll(r);

    }

    public List<String> generateParenthesis(int n) {
        char[] chars = new char[n +n];
        for (int i = 0; i < n; i++) chars[i]='(';
        for (int i = n; i < chars.length; i++) chars[i]=')';

        return Collections.emptyList();

    }
}
