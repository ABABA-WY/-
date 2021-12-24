package Daly;

import java.util.ArrayList;
import java.util.*;

public class LC1218 {
    public static void main(String[] args) {
        int[] arr={1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(new LC1218().longestSubsequence(arr,difference));
    }
    public int longestSubsequence(int[] arr, int difference) {
        int cnt=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i :arr) {
            map.put(i, map.getOrDefault(i-difference,0)+1);
            cnt=Math.max(cnt, map.get(i));
        }
        return cnt;
    }
}
