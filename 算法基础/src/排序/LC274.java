package 排序;

import java.util.Arrays;

public class LC274 {
    static int[] citations={3,0,6,1,5};
    public static void main(String[] args) {
        System.out.println(new LC274().hIndex(citations));
    }
    public  int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h=0;
        int i=n-1;
        while(i>=0&&citations[i]>h){
            h++;
            i--;
        }
        return h;

    }
    public static void quick_sort(int[]q,int l,int r){
        if(l>=r)
            return;
        int x=q[l+r>>1];
        int i=l-1,j=r+1;
        while (i<j) {
            do{
                i++;
            }while(q[i]<x);
            do{
                j--;
            }while(q[j]>x);
            if(i<j){
                int temp=q[i];
                q[i]=q[j];
                q[j] = temp;
            }
        }
        quick_sort(q,l,i-1);
        quick_sort(q,i,r);
    }
}
