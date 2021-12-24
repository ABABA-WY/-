package Competition;

public class LC5919 {
    public static void main(String[] args) {
        String word = "aba";
        System.out.println(new LC5919().countVowels(word));
    }
    public long countVowels(String word) {
        int n = word.length();
        long cnt=0;
        int dp=0;
        for(int i = 0; i < n; i++){
            if(isValid(word.charAt(i))){
                dp+=i+1;//当前值的贡献
                /*
                可用排列组合的思想来想这个问题，从i可以往前取i+1个数（0~i）

                * */
            }
            cnt+=dp;
        }
        return cnt;
    }
    public boolean isValid(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
