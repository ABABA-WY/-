package lable8;

import java.util.Arrays;
import java.util.Scanner;

public class Lcoffer073 {
    public static void main(String[] args) {
        int N;
        System.out.print("N:");
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        int [] piles=new int[N];
        for (int i = 0; i < N; i++) {
            piles[i] = sc.nextInt();
        }
        System.out.print("H:");
        int h= sc.nextInt();
        int k=minEatingSpeed(piles, h);
        System.out.println(k);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        Arrays.sort(piles);
        int N=piles.length;
        if(h==N){
            k=piles[N-1];
        }
        return k;
    }

}

