package lable11;

public class LC605 {
    public static void main(String[] args) {
        int[] flowerbed={0,0,1,0,1};
        int n=1;
        for (int i=0;i< flowerbed.length&&n>0;){
            if(flowerbed[i]==1){
                i+=2;
            }
            else if(i==flowerbed.length-1||flowerbed[i+1]==0){
                n--;
                i+=2;
            }
            else
                i+=3;
        }
        System.out.println(n);
        if(n>0) System.out.println("false");
        else System.out.println("true");
    }
}
