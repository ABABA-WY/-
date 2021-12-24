package 前缀和;

public class JZ66 {
    public static void main(String[] args) {
        int[] a={};
        int[] b=new JZ66().constructArr(a);
        for(int x:b){
            System.out.println(x);
        }
    }
    public int[] constructArr(int[] a) {
        if(a.length == 0)
            return new int[0];
        int n=a.length;
        int[] m1=new int[n];
        int[] m2=new int[n];
        int[] ans=new int[n];
        m1[0] = a[0];
        m2[n-1]=a[n-1];
        for (int i = 1; i < a.length; i++) {
            m1[i] = a[i]*m1[i-1];
            m2[n-i-1]=m2[n-i]*a[n-i-1];
        }
        ans[0]=m2[1];
        ans[n-1]=m1[n-2];
        for(int i=1;i<n-1; i++){
            ans[i]=m1[i-1]*m2[i+1];
        }
        return ans;
    }
}
