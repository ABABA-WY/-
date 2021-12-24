import java.math.BigInteger;
import java.util.Scanner;

public class P1009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BigInteger sum=new BigInteger("0");
        for(int i=1;i<=n; i++){
            sum=sum.add(f(i));
        }
        System.out.println(sum);

    }
    public static BigInteger f(int x){
        if(x==1)
            return new BigInteger("1");
        return new BigInteger(x+"").multiply(f(x-1));
    }
}
