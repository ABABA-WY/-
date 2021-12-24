package 位运算;

import java.util.Scanner;

public class LC461 {
    public static void main(String[] args) {
        int x,y;
        Scanner scanner=new Scanner(System.in);
        x= scanner.nextInt();
        y = scanner.nextInt();
        System.out.println(new LC461().hammingDistance(x, y));
    }
    public int hammingDistance(int x, int y) {
        int def=x^y;
        int count=0;
        while(def!=0){
            count+=def&1;
            def=def>>1;
        }
        return count;
    }
}
