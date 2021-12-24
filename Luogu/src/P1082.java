import java.util.Scanner;

public class P1082 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt(),b = scanner.nextInt();
        int x=b/a;
        for (int i = x; ; i++) {
            if(a*i%b==1){
                x=i;
                break;
            }
        }
        System.out.println(x);
    }

}
