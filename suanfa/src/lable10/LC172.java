package lable10;

import java.util.Scanner;

public class LC172 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        int count=0;
        while(n>0){
            count+=n/5;
            n/=5;
        }
        System.out.println(count);
    }
}
