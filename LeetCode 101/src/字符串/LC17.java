package 字符串;

import java.util.ArrayList;
import java.util.List;

public class LC17 {
    public String[] ss={
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<String>();
        if(digits.length()<=0){
            return ans;
        }
        Combinations(digits,0,new StringBuilder(""));
        return ans;
    }
    public void Combinations(String digits,int idx,StringBuilder res){
        if(res.length()==digits.length()){
            ans.add(res.toString());
            return;
        }
        int u=digits.charAt(idx)-'2';
        for(int i=0;i<ss[u].length();i++){
            Combinations(digits,idx+1,res.append(ss[u].charAt(i)));
            //res.deleteCharAt(res.length() - 1);
        }
    }
}
