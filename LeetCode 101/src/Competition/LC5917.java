package Competition;

public class LC5917 {
    public boolean possiblyEquals(String s1, String s2) {
        if(s1.equals(s2))return true;
        int t=0;
        int j=0;
        for(int i=0;i<s2.length(); i++){
            if(Character.isDigit(s2.charAt(i))){
                t=t*10+s2.charAt(i)-'0';
                if(j+t<s1.length()){
                        j += t;
                        t=0;
                }
            }
            else {
                if(s1.charAt(j)!=s2.charAt(i))
                    return false;
                j++;
            }
        }
        return true;
    }

}
