package 双指针;

import java.util.Arrays;
import java.util.List;

public class LC524 {
    public static void main(String[] args) {
        String s="abpcplea";
        List<String> dictionary= Arrays.asList("ale","apple","monkey","plea");
        StringBuilder b=new StringBuilder("");
        for(String a:dictionary){
            int i=0,j=0;
            while(i<s.length()&&j<a.length()) {
                if(s.charAt(i)==a.charAt(j)){
                    i++;
                    j++;
                }
                else i++;
            }
            if(j==a.length()){

                b=(b.length()>=a.length())? b:new StringBuilder(a);
            }
        }
        System.out.println(b);

    }

}
