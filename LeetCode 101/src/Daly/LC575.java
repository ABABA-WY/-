package Daly;

import java.util.*;

public class LC575 {
    public int distributeCandies(int[] candyType) {
       Set<Integer> ans=new HashSet<Integer>();
       for (int i = 0; i < candyType.length; i++) {
           ans.add(candyType[i]);
       }
       return Math.min(ans.size(), candyType.length/2);
    }
}
