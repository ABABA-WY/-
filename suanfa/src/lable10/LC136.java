package lable10;

public class LC136 {
    public static void main(String[] args) {
        int [] nums={4,1,2,1,2};
        int s=0;
        for(int num:nums){
            s^=num;
        }
        System.out.println(s);
    }
}
