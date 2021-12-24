package 双指针;

public class LC680 {
    public static void main(String[] args) {
        String s="abca";
        int left=0;
        int right=s.length()-1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)){
                return;
            }
            left++;
            right--;
        }
    }
    public boolean isPalindrome(String s,int left,int right){
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
