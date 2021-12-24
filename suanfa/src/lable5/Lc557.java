package lable5;

public class Lc557 {
    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        StringBuffer b=new StringBuffer(s.length());
        int i = 0;
        while(i<s.length()){
            int start=i;
            while (i<s.length()&&s.charAt(i) != ' '){
                i++;
            }
            for (int p=start;p<i;p++){
                b.append(s.charAt(start+i-p-1));
            }
            while (i<s.length()&&s.charAt(i) == ' '){
                b.append(" ");
                i++;
            }
        }
        System.out.println(b.toString());
    }
}
