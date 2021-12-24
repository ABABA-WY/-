package 二分查找;

import java.util.Scanner;

public class LC69 {
    public static void main(String[] args) {
        int x;
        Scanner sc = new Scanner(System.in);
        x= sc.nextInt();
        int i=1,j=x,mid,sqrt;
        while (i <= j) {
            mid=i+(j-1)/2;
            sqrt=x/mid;
            if(sqrt==mid){
                return;
            }
            else if(sqrt>mid){
                i=mid+1;
            }
            else j=mid - 1;
        }
    }
}
