package 数据结构;

import java.util.ArrayDeque;
import java.util.*;

public class LC503 {
    public static void main(String[] args) {
        int[] nums={1,2,1};
        for(int x:new LC503().nextGreaterElements(nums))
            System.out.println(x);
    }
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int [] ret=new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<n*2-1;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i%n]){
                ret[stack.pop()]=nums[i % n];
            }
            stack.push(i%n);
        }
        return ret;
    }
}
