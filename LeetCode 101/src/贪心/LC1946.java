package 贪心;

public class LC1946 {
    public static void main(String[] args) {
        String s="214010";
        int[] changes={6,7,9,7,4,0,3,4,4,7};
        System.out.println(new LC1946().maximumNumber(s,changes));
    }
    public String maximumNumber(String num, int[] change) {

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<num.length(); i++){
            int u=num.charAt(i)-'0';
            if(change[u]>u){
                sb.append(change[u]);
                for(int j=i+1;j < num.length(); j++){
                    int x = num.charAt(j) - '0';
                    if(change[x]>=x){
                        sb.append(change[x]);
                    }
                    else break;
                }
                break;
            }
            else {
                sb.append(num.charAt(i));
            }
        }
        for(int i=sb.length();i<num.length(); i++){
            sb.append(num.charAt(i));
        }

        return sb.toString();
    }
}
