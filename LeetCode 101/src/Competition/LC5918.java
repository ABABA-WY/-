package Competition;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LC5918 {
    public static void main(String[] args) {
        String word=new Scanner(System.in).nextLine();
        System.out.println(new LC5918().countVowelSubstrings(word));
    }
    public int countVowelSubstrings(String word) {
        Set<String> ans=new HashSet<String>();
        Set<String> r=new HashSet<String>(){{
                add("a");
                add("e");
                add("i");
                add("o");
                add("u");
            }
        };
        int cnt=0;
        int n = word.length();
        for(int i = 0; i < n-4; i++){
            ans=new HashSet<String>();
            for(int j=i;j<n;j++){
                ans.add(String.valueOf(word.charAt(j)));
                if(ans.equals(r))
                    cnt++;
            }
        }
        return cnt;
    }
}
