package Daly;

import java.util.HashMap;
import java.util.Map;

public class LC166 {
    public static void main(String[] args) {
        int numerator = 2, denominator = 3;
        System.out.println(new LC166().fractionToDecimal(numerator,denominator));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb=new StringBuffer();
        long a=numerator;
        long b=denominator;
        if(a%b==0)
            return String.valueOf(a/b);
        if (a*b<0) sb.append('-');
        a=Math.abs(a);
        b = Math.abs(b);
        sb.append(String.valueOf(a/b)+'.');
        a%=b;
        Map<Long,Integer> ans = new HashMap<Long, Integer>();
        while (a!=0){
            ans.put(a,sb.length());
            a*=10;
            sb.append(String.valueOf(a/b));
            a%=b;
            if(ans.containsKey(a)){
                int x=ans.get(a);
                return String.format("%s(%s)",sb.substring(0,x),sb.substring(x));
            }
        }
        return sb.toString();
    }
}
