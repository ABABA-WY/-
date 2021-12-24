package 哈希;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
public class P3370 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Set<String> ans=new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String s=sc.next();
            ans.add(s);
        }
        System.out.println(ans.size());

    }
}
