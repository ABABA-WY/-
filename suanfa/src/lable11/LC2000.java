package lable11;

public class LC2000 {
    public static void main(String[] args) {
        String word = "xyxzxe";
        char ch='a';
        System.out.println(new LC2000().reversePrefix(word,ch));
    }
    public String reversePrefix(String word, char ch) {
        int left=0;
        int right = 0;
        StringBuffer ans=new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                break;
            }
            else right++;
        }
        if(right>=word.length())
            return word;
        left=right+1;
        while(right>=0) {
            ans.append(word.charAt(right--));
        }
        while(left<word.length()){
            ans.append(word.charAt(left++));
        }
        return ans.toString();
    }
}
