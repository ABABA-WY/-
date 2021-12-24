package lable5;

public class Lc344 {
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        for(int i = 0; i < s.length/2; i++){
            char temp=s[i];
            s[i]=s[s.length - 1-i];
            s[s.length - 1-i]=temp;
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
