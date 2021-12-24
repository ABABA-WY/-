package 数学;

import java.util.Scanner;

public class LC168 {
    public static void main(String[] args) {
        int columnNumber=new Scanner(System.in).nextInt();
        System.out.println(new LC168().convertToTitle(columnNumber));
    }
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber!=0){
            columnNumber--;
            int b=columnNumber%26;
            columnNumber=columnNumber/26;
            char c= (char) ('A'+b);
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }
}
