package lable11;

import java.util.List;
import java.util.Scanner;
import java.util.*;

public class JZ57 {
    public static void main(String[] args) {
        int target=new Scanner(System.in).nextInt();
        int[][] res=new JZ57().findContinuousSequence1(target);
        for(int i=0;i< res.length;i++){
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    //暴力解法
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans=new ArrayList<>();
        int a=target-1>>1;
        int x=1;
        while (x <= a) {
            for(int y=x+1;;y++) {
                if ((x + y) * (y - x + 1) / 2 == target) {
                    int[] r = new int[y - x + 1];
                    for (int i = x; i <= y; i++) {
                        r[i - x] = i;
                    }
                    ans.add(r);
                }
                else if((x + y) * (y - x + 1) / 2 > target){
                    break;
                }

            }
            x++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
    //双指针解法
    public int[][] findContinuousSequence1(int target){
        List<int[]> ans = new ArrayList<int[]>();
        for(int l=1,r=2;l<r;){
            int sum=(l+r)*(r-l+1)/2;
            if(sum==target){
                int[] a = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    a[i - l] = i;
                }
                ans.add(a);
                l++;
            }
            else if(sum>target){
                l++;
            }
            else {
                r++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
