package lable9;

import java.util.*;

public class LC1394 {
    public static void main(String[] args) {
        int[] arr={7,7,7,7,7,7,7};
        int count=-1;
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ans.put(arr[i],ans.getOrDefault(arr[i],0)+1);
        }
        for(int key: ans.keySet()){
            int time=ans.get(key);
            if(key==time){
                count=Math.max(count,key);
            }
        }

        System.out.println(count);
    }
}
