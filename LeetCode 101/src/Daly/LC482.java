package Daly;

public class LC482 {
    public static void main(String[] args) {
        String s="2-5g-3-J";
        int k=2;
        System.out.println(new LC482().licenseKeyFormatting(s,k));
    }
    public String licenseKeyFormatting(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int cnt=0;
        for(int i=s.length() - 1; i >= 0; i--){
            if (s.charAt(i) !='-' ){
                cnt++;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if(cnt%k==0){
                    sb.append('-');
                }
            }
        }
        if(sb.length() > 0&&sb.charAt(sb.length() - 1)=='-'){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
