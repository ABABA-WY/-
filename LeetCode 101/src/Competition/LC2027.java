package Competition;

public class LC2027 {
    public static void main(String[] args) {
        String s = "XXOX";
        System.out.println(new LC2027().minimumMoves(s));
    }
    public int minimumMoves(String s) {
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X'){
                cnt++;
                i+=2;
            }
        }
        return cnt;
    }
}
