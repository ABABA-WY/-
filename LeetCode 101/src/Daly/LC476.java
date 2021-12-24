package Daly;

public class LC476 {
    public int findComplement(int num) {
        int a=-1;
        while((a&num)>0){
            a=a<<1;
        }
        return ~a^num;
    }
}
