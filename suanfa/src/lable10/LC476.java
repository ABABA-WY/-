package lable10;

import java.util.Scanner;

public class LC476 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        int a=-1;
        while((a&num)>0){
            a=a<<1;
        }
        System.out.println(~a^num);
    }
}
