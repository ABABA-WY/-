package lable6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lc118 {
    public static void main(String[] args) {
        int n;
        Scanner cin=new Scanner(System.in);
        n=cin.nextInt();
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> row=new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j==0||j==i)
                    row.add(1);
                else {
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
    }
}
