package lable10;

public class LC038 {
    public static void main(String[] args) {
        int[] temperatures={73,74,75,71,69,72,76,73};
        int[] ans=new int[temperatures.length];
        for (int i = 0; i < temperatures.length-1; i++) {
            boolean b=false;
            int t=1;
            for(int j=i+1;j<temperatures.length; j++){
                if(temperatures[i]<temperatures[j]){
                    b = true;
                    ans[i]=t;
                    break;
                }
                t++;
            }
            if (!b) {
                ans[i] = 0;
            }
        }
        for(int t:ans)
            System.out.println(t);
    }
}
