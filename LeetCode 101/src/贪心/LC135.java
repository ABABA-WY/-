package 贪心;

import java.util.Arrays;

public class LC135 {
    public static void main(String[] args) {
        int[] ratings={1,3,2,2,1};
        int[] ans=new int[ratings.length];
        Arrays.fill(ans, 1);
        for(int i = 0; i < ratings.length-1; i++){
            if(ratings[i] < ratings[i+1]){
                ans[i+1]=ans[i]+1;
            }
        }
        for(int i=ratings.length - 1; i > 0; i--){
            if (ratings[i]< ratings[i-1]) {
                ans[i-1]=Math.max(ans[i-1],ans[i]+1);
            }
        }
        int count=Arrays.stream(ans).sum();
        System.out.println(count);
    }
}
