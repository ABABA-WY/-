package 字符串;

public class LC8 {
    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(new LC8().myAtoi(s));
    }
    public int myAtoi(String s) {
        long ans=0;
        int flag=1;
        for (int i = 0; i < s.length(); i++) {
            while(i<s.length()&&s.charAt(i)==' '){
                i++;
            }
            if(i>=s.length())
                break;
            if(!Character.isDigit(s.charAt(i))){
                if(s.charAt(i)=='-'&&i+1<s.length()&&Character.isDigit(s.charAt(i+1)))
                    flag=-1;
                else if(s.charAt(i) == '+'&&i+1<s.length()&&Character.isDigit(s.charAt(i+1)))
                    flag=1;
                else break;
            }
            else{
                while(i < s.length()){
                    if(Character.isDigit(s.charAt(i))){
                        ans=ans*10+s.charAt(i)-'0';
                        if(ans*flag>Integer.MAX_VALUE)
                            return Integer.MAX_VALUE;
                        if(ans*flag<Integer.MIN_VALUE)
                            return Integer.MIN_VALUE;
                    }
                    else{
                        break;
                    }
                    i++;
                }
                break;
            }
        }
        ans=ans*flag;
        if(ans>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(ans<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)ans;
    }
}
