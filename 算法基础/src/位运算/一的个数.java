package 位运算;

import java.util.Scanner;

public class 一的个数 {
    public static void main(String[] args) {
        int x=new Scanner(System.in).nextInt();
        int res=0;
        while(x>0){
            x-=lowbit(x);//每次减去第一个一
            res++;
        }
        System.out.println(res);
    }
    //返回第一次出现一的位置
    public static int lowbit(int x){
        return x&-x;
    }
}
