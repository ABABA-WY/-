import java.math.BigInteger;
import java.util.Scanner;

public class P1303 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a=input.nextLine();
        String b = input.nextLine();
        BigInteger aa=new BigInteger(a);
        BigInteger bb=new BigInteger(b);
        aa=aa.multiply(bb);
        System.out.println(aa);

    }
}
