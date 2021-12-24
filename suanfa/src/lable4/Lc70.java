package lable4;

public class Lc70 {
    public static void main(String[] args) {
        Lc70 test=new Lc70();
        int result = test.climbStairs3(5);
        System.out.println(result);
    }
    public int climbStairs(int n) {
        int p=0,q=0,r=1;
        for (int i = 0; i < n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
    public int climbStairs2(int n){
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int) (fibn/sqrt5);
    }
    public int climbStairs3(int n) {
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        if (n < 3)
            return n;
        for (int i = 2; i < n; i++) {
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];
    }
}
