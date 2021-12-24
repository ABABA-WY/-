package Daly;

import java.util.LinkedList;
import java.util.List;

public class LC412 {
    public static void main(String[] args) {
        List<String> ans=new LC412().fizzBuzz(15);
        for(String s : ans){
            System.out.print(s+" ");
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }

        }
        return ans;
    }
}
