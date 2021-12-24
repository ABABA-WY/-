package Daly;

import java.util.HashSet;
import java.util.Set;

public class LC869 {
    private Set<String> ans=new HashSet<String>();
    public boolean reorderedPowerOf2(int n) {
        init();
        return ans.contains(countDigit(n));
    }
    public void init(){
        for (int i = 1; i < 1e9; i<<=1) {
            ans.add(countDigit(i));
        }
    }
    public String countDigit(int n){
        char[] c = new char[10];
        while (n > 0) {
            c[n%10]++;
            n/=10;
        }
        return new String(c);
    }
}
