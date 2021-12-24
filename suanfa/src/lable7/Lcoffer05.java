package lable7;

public class Lcoffer05 {
    public static void main(String[] args) {
        String s="We are happy.";
        StringBuilder b=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) !=' ') {
                b.append(s.charAt(i));
            }
            else b.append("%20");
        }
        s=b.toString();
        System.out.println(s);
    }
}
