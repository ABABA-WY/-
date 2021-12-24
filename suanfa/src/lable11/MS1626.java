package lable11;

import java.util.Deque;
import java.util.LinkedList;

public class MS1626 {
    public static void main(String[] args) {
        String s = " 3/2";
        System.out.println(new MS1626().calculate(s));
    }

    public int calculate(String s) {
        s=s.replaceAll(" ","");
        Deque<Integer> stack = new LinkedList<>();
        char p = '+';
        int t = 0;
        int i = 0;
        while (s.charAt(i) != ' ' && i < s.length()) {
            while (i < s.length()&&Character.isDigit(s.charAt(i))) {
                t = t * 10 + s.charAt(i) - '0';
                i++;
            }
            switch (p) {
                case '+':
                    stack.push(t);
                    break;
                case '-':
                    stack.push(-t);
                    break;
                case '*':
                    stack.push(stack.pop() * t);
                    break;
                case '/':
                    stack.push(stack.pop() / t);
                    break;
            }
            if(i>=s.length()) break;
            p = s.charAt(i);
            t = 0;
            i++;
        }
        int sum=0;
        while (!stack.isEmpty()) {
            sum+=stack.pop();
        }
        return sum;
    }
}
