package 数学;

public class LC67 {
    public static void main(String[] args) {
        String a="1010";
        String b = "1011";
        System.out.println(new LC67().addBinary(a,b));
    }
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i=a.length()-1;
        int j=b.length() - 1;
        int and=0;
        while (and!=0||j>=0||i>=0){
            int c=i>=0?a.charAt(i)-'0':0;
            int d=j>=0?b.charAt(j)-'0':0;
            int e=c^d^and;
            sb.append(e);
            and=(c&d)|(c&and)|(d&and);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
