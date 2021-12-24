package Competition;

public class LC5910 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] a=new int[26];
        int[] b=new int[26];
        for(int i=0;i<word1.length(); i++){
            a[word1.charAt(i)-'a']++;
            b[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            if(Math.abs(a[word1.charAt(i) - 'a'] -b[word2.charAt(i) - 'a'])>3)
                return false;
        }
        return true;
    }
}
