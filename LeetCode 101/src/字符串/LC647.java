package 字符串;

public class LC647 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new LC647().countSubstrings(s));
    }
    public int countSubstrings(String s) {
        int count =0;
        for(int i=0;i < s.length(); i++){
            count+=countGet(s,i,i);
            count += countGet(s, i, i+1);
        }
        return count;
    }
    public int countGet(String s,int l,int r){
        int count =0;
        while(l>=0&&r<s.length()&&s.charAt(l) ==s.charAt(r)){
            l--;
            r++;
            count++;
        }
        return count;
    }
}
