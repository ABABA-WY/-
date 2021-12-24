package 字符串;

public class LC43 {
    public static void main(String[] args) {
        String num1 = "123", num2 = "40";
        System.out.println(new LC43().multiply(num1, num2));
    }

    StringBuilder sb = new StringBuilder();
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            String s = mul(num1, num2.charAt(i));
            String w = sb.toString();
            sb=new StringBuilder();
            int j = 0;
            int k = num2.length() - 1 - i;
            int carry = 0;
            sb.append(w.substring(0,k));//移位
            while (j < s.length() || k < w.length()) {
                int x = j < s.length() ? s.charAt(j) - '0' : 0;
                int y = k < w.length() ? w.charAt(k) - '0' : 0;
                int m = x + y + carry;
                sb.append(m % 10);
                carry = m / 10;
                j++;
                k++;
            }
            if (carry > 0)
                sb.append(carry);
        }

        return sb.reverse().toString();
    }
//取出一个字符与字符串相乘
    public String mul(String num1, char c) {
        int carry = 0;
        int y = c - '0';
        int n = num1.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (n >= 0) {
            int x = num1.charAt(n) - '0';
            int m = x * y + carry;
            ans.append(m % 10);
            carry = m / 10;
            n--;
        }
        if (carry > 0)
            ans.append(carry);
        return ans.toString();
    }
}
