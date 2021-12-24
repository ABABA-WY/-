package lable11;

import java.util.Arrays;

public class LC455 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 2, 3, 4};
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0,cookie=0;
        while(child< g.length&&cookie< s.length){
            if(g[child]<=s[cookie])
                child++;
            cookie++;
        }
        System.out.println(child);
    }
}
