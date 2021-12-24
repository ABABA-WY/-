package Competition;

import java.util.Arrays;

public class LC2028 {
    public static void main(String[] args) {
        int[] rolls={3,5,3};
        int mean=5;
        int n=3;
        for(int num:new LC2028().missingRolls(rolls,mean,n)){
            System.out.println(num);
        }
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res=new int[n];
        int m= rolls.length;
        int ans= Arrays.stream(rolls).sum();
        int sum=mean*(m+n);
        int sub=sum-ans;
        int div=sub / n;
        int mod=sub%n;
        if((div==6&&mod != 0)||div<=0||div>6)  return new int[0];
        Arrays.fill(res,div);
        for(int i=0;i<n; i++){
            if(res[i]<6&&mod>0){
                res[i]++;
                mod--;
            }
            else if(mod<=0)
                break;
            if(mod>0&&i>=n-1){
                i=-1;
            }
        }
        return res;
    }
}
