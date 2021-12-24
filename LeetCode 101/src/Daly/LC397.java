package Daly;

public class LC397 {
    public int integerReplacement(int n) {
        if(n==Integer.MAX_VALUE)
            return 32;
        int ans=0;
        while(n!=1){
            if((n&1)!=0){
                if(n==3){
                    return ans+2;
                }
                if((n&2)!=0){
                    n++;
                }
                else
                    n--;
                ans++;
            }
            else{
                n>>=1;
                ans++;
            }
        }
        return ans;
    }
}
