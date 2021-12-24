package Daly;

public class LC434 {
    public static void main(String[] args) {
        String s="";
        System.out.println(new LC434().countSegments(s));
    }
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if((i==0||s.charAt(i-1) ==' ')&&s.charAt(i)!=' '){
                count++;
            }

        }
        return count;
    }
}
