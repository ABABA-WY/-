package Competition;

public class LC5902 {
    public static void main(String[] args) {
        String s="1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(new LC5902().areNumbersAscending(s));
    }
    public boolean areNumbersAscending(String s) {

        int t=0;
        int pre=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            t=0;
            if (Character.isDigit(s.charAt(i))){
                if(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
                    t=(s.charAt(i)-'0')*10+s.charAt(i+1);
                    i++;
                }
                else t=s.charAt(i)-'0';
                if(t<=pre){
                    return false;
                }
                pre=t;
            }


        }
        return true;
    }
}
