package 字符串;

import java.util.ArrayList;
import java.util.List;

public class LC6 {
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int numRows=4;
        System.out.println(new LC6().convert(s,numRows));
    }
    public String convert(String s, int numRows) {
        if(numRows<2)
            return s;
        List<StringBuilder> ans=new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++)
            ans.add(new StringBuilder());
        int i=0,flag=-1;
        for (char c:s.toCharArray()) {
            ans.get(i).append(c);
            if(i==0||i==numRows - 1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder ret=new StringBuilder();
        for(StringBuilder b : ans){
            ret.append(b);
        }
        return ret.toString();
    }
}
