package 数据结构;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class LC313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> t = new TreeSet<Long>();
        //初始化
        t.add(1L);
        while(n-->0){
            //取出最小的数
            long k=t.pollFirst();
            //第n次出队，就是第n个数
            if(n==0) return (int) k;
            for(int x:primes){
                if(!t.contains(k*x)){
                    t.add(k * x);
                }
            }
        }
        return -1;
    }
}
