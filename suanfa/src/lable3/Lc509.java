package lable3;

public class Lc509 {
    public static void main(String[] args) {
        Lc509 t=new Lc509();
        int result=t.fibn(25);
        System.out.println(result);
    }
    public int fib(int n) {
        int result=0;
        if(n<=0)
            result=0;
        else if(n == 1)
            result=1;
        else{
            result=fib(n-1)+fib(n-2);
        }
        return result;
    }
    public int fibn(int n){
        int[] result=new int[n+1];
        result[0]=0;
        if(n>=1)
            result[1]=1;
        if(n>=2)
            result[2]=1;
        for(int i=3;i<=n; i++){
            result[i] = result[i-1]+result[i-2]+result[i-3];
        }

        return result[n];
    }
}
