package 贪心;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 合并果子 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(n);
        for(int i = 0; i < n; i++){
            int a = input.nextInt();
            q.add(a);
        }
        int res=0;
        while(q.size() > 1){
            int a=q.poll();
            int b=q.poll();
            res+=a+b;
            q.add(a+b);
        }
        System.out.println(q.poll());
    }
}
