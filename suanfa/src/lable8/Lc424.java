package lable8;

public class Lc424 {
    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;
        int result=characterReplacement(s,k);
        System.out.println(result);
    }
    public static int characterReplacement(String s, int k) {
        int len=s.length();
        if(len<2)
            return len;
        int left=0,right = 0;
        int res = 0;
        int maxCount = 0;
        char []charArr=s.toCharArray();
        int [] freq=new int[26];
        while(right < len){
            freq[charArr[right]-'A']++;
            maxCount=Math.max(maxCount,freq[charArr[right] - 'A']);
            right++;
            if(right-left>maxCount+k){
                freq[charArr[left]-'A']--;
                left++;
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}
