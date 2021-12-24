package 数据结构;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC739 {
    public static void main(String[] args) {
        int[] temperatures={73,74,75,71,69,72,76,73};
        int[] res=new LC739().dailyTemperatures(temperatures);
        for(int x:res){
            System.out.println(x);
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> ans=new ArrayDeque<>();
        int[] res=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!ans.isEmpty()){
                int top= ans.peek();
                if(temperatures[i]<=temperatures[top]){
                    break;
                }
                ans.pop();
                res[top]=i-top;
            }
            ans.push(i);
        }
        return res;
    }
}
