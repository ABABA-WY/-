package 字符串;

public class LC1880 {
    public static void main(String[] args) {
        String firstWord = "acb", secondWord = "cba", targetWord = "cdb";
        System.out.println(new LC1880().isSumEqual(firstWord,secondWord,targetWord));
    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int m = firstWord.length()-1;
        int n = secondWord.length()-1;
        int len=targetWord.length()-1;
        int d = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            if(len<0)
                return false;
            int num1 = m < 0 ? 0 : firstWord.charAt(m) - 'a';
            int num2 = n < 0 ? 0 : secondWord.charAt(n) - 'a';
            int sum = (num1 + num2 + d) % 10;
            d = (num1 + num2 + d) / 10;
            if(sum!=targetWord.charAt(len--)-'a')
                return false;
            m--;
            n--;
        }
        return true;
    }
}
