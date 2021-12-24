package lable5;

import java.util.Arrays;

public class Lc121 {
    public static void main(String[] args) {
        int[] prices={1,2,4};
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] <min){
                min = prices[i];
            }
            else if(prices[i]-min>max){
                max = prices[i]-min;
            }
        }
        System.out.println(max);
    }
}
