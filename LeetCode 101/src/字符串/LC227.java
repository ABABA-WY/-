package 字符串;

import java.util.Deque;
import java.util.LinkedList;

public class LC227 {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(new LC227().calculate(s));
    }
    public int calculate(String s) {
        Deque<Integer> q = new LinkedList<>();
        int num = 0;
        int n = s.length();
        char preSign = '+';
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        q.push(num);
                        break;
                    case '-':
                        q.push(-num);
                        break;
                    case '*':
                        q.push(q.pop() * num);
                        break;
                    case '/':
                        q.push(q.pop() / num);
                        break;
                }
                preSign=s.charAt(i);
                num=0;
            }
        }
        int ans=0;
        while (!q.isEmpty()){
            ans+=q.pop();
        }
        return ans;
    }
}
