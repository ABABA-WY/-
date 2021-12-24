package 分治算法;

import java.util.*;

public class LC241 {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> left = new LinkedList<Integer>();
        List<Integer> right = new LinkedList<Integer>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            if (isOp(expression.charAt(i))) {
                left = diffWaysToCompute(expression.substring(0, i));
                right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (expression.charAt(i)) {
                            case '+':
                                ans.add(l + r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '*':
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(ans.size() == 0) ans.add(Integer.valueOf(expression));
        return ans;
    }

    private boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
