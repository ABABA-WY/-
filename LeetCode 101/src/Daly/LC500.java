package Daly;

import java.util.ArrayList;
import java.util.List;

public class LC500 {
    public static void main(String[] args) {
        String[] words={"Hello","Alaska","Dad","Peace"};
        String[] res=new LC500().findWords(words);
    }
    public String[] findWords(String[] words) {
        String[] ss={"qwertyuiop","asdfghjkl","zxcvbnm"};
        List<String> ans=new ArrayList<>();
        int[] c=new int[26];
        for(int i=0;i<ss.length; i++){
            for(char u:ss[i].toCharArray()){
                c[u-'a']=i+1;
            }
        }
        for(String word : words){
            int x=c[Character.toLowerCase(word.charAt(0))-'a'];
            int i=0;
            for (;i<word.length(); i++) {
                char u=Character.toLowerCase(word.charAt(i));
                if(c[u-'a']!=x)
                    break;
            }
            if(i == word.length() ){
                ans.add(word);
            }
        }
        String[] res=new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
