package 数学;

import java.util.*;

public class LC22 {
    List<String> ans=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n<=0){
            return null;
        }
        generateParen("",n,n);
        return ans;

    }
    public void generateParen(String s,int l,int r){
        if(l==0&&r == 0){
            ans.add(s);
            return;
        }
        if(l==r){
            generateParen(s+"(",l-1,r);
        }
        else{
            if(l>0){
                generateParen(s+"(", l-1,r);
            }
            generateParen(s+")",l,r-1);
        }
    }
}
