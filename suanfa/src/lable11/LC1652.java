package lable11;

public class LC1652 {
    public static void main(String[] args) {
        int[] code={5,7,1,4};
        int k=-1;
        int[] res=new LC1652().decrypt(code, k);
        for(int x:res)
            System.out.println(x);
    }
    public int[] decrypt(int[] code, int k) {
        int[] ans=new int[code.length];
        int n=code.length;
        for(int i = 0; i < n; i++){
            ans[i]=0;
            if(k>0){
                for(int j=i+1; j <=i+k;j++)
                    ans[i]+=code[(j+n)%n];
            }
            else if (k <0){
                for(int j=i-1;j>=i+k;j--)
                    ans[i] += code[(j+n) % n];
            }
        }
        return ans;
    }
}
