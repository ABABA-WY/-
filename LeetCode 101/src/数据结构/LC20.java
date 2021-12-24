package 数据结构;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20 {
    public static void main(String[] args) {
        String s = "}";
        System.out.println(new LC20().isValid(s));
    }

    public boolean isValid(String s) {
        Deque<Character> ans = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                ans.push(c);
            } else {
                if (ans.isEmpty()) {
                    return false;
                }
                char b = ans.peek();
                if ((b == '(' && c == ')') || (b == '[' && c == ']') || (b == '{' && c == '}')) {
                    ans.pop();
                } else {
                    return false;
                }
            }
        }
        return ans.isEmpty();
    }
}
