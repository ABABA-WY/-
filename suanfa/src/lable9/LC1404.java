package lable9;

public class LC1404 {
    public static void main(String[] args) {
        String s="1111011110000011100000110001011011110010111001010111110001";
        int count=0;
        boolean c=false;
        for(int i=s.length()-1;i >= 0; i--){
            if(c){
                if(s.charAt(i)=='0')  {
                    count+=2;
                    c=true;
                }
                else {
                    count++;
                    c=true;
                }
            }
            else {
                if(s.charAt(i)=='0')  {
                    count+=1;
                    c=false;
                }
                else {
                    count+=2;
                    c=false;
                }
            }
        }
        System.out.println(count);
    }
}
