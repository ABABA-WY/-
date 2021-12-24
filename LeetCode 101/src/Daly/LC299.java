package Daly;

public class LC299 {
    public String getHint(String secret, String guess) {
        int[] ans=new int[10];
        for(int i=0;i<guess.length(); i++){
            ans[guess.charAt(i)-'0']++;
        }
        int countA=0;
        int countB=0;
        for(int i=0;i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                countA++;
                ans[secret.charAt(i)-'0']--;
            }
        }
        for(int i = 0; i <secret.length(); i++){
            if(ans[secret.charAt(i)-'0']>0&&secret.charAt(i) != guess.charAt(i)){
                countB++;
                ans[secret.charAt(i)-'0']--;
            }
        }
        return String.valueOf(countA)+"A"+String.valueOf(countB) + "B";
    }
}
