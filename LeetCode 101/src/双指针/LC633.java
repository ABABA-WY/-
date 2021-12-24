package 双指针;

public class LC633 {
    public static void main(String[] args) {
        int c=5;
        double a=Math.sqrt(c);
        int left=1;
        int right=(int)a;
        while (left <right) {
            if(c==(left*left+right*right)) return;
            else if(c>((left*left+right*right)))  left++;
            else right--;
        }
        return;
    }
}
