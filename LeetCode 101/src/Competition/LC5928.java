package Competition;

public class LC5928 {
    public static void main(String[] args) {
        String encodedText = "ch   ie   pr";
        int rows = 3;
        System.out.println(new LC5928().decodeCiphertext(encodedText, rows));
    }

    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int col = n / rows;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            int r = 0;
            int c = i;
            while (r < rows && c < col) {
                //找出当前坐标对应的字符
                //当前行*总列数+当前列=当前二维坐标
                sb.append(encodedText.charAt(r * col + c));
                r++;
                c++;
            }
        }
        int i = sb.length() - 1;
        for (; i > 0 && sb.charAt(i) == ' '; i--) ;
        return sb.toString().substring(0, i + 1);
    }
}
