package Daly;

import java.util.Scanner;

public class LC38 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        System.out.println(new LC38().countAndSay(n));
    }
    public String countAndSay(int n) {

        String str="1";

        for(int i=2;i<=n; i++){
            StringBuffer sb = new StringBuffer();
            int start=0;
            int j=0;
            while(j<str.length()) {
                char c = str.charAt(start);
                while(j < str.length()&&str.charAt(j) == c){
                    j++;
                }
                sb.append(Integer.toString(j-start)).append(c);
                start=j;
            }
            str=sb.toString();
        }
        return  str;
    }
}
