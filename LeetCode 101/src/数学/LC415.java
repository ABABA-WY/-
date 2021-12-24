package 数学;

public class LC415 {
    public static void main(String[] args) {
        String num1 = "3876620623801494171";
        String num2 = "6529364523802684779";
        System.out.println(new LC415().addStrings(num1,num2));
    }
    public String addStrings(String num1, String num2) {
        StringBuffer ans=new StringBuffer();
        int add=0;
        for(int i=num1.length()-1,j = num2.length() - 1;i>=0||j >= 0||add!=0; i--,j--){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int result=x+y+add;
            ans.append(result%10);
            add=result/10;
        }
        ans.reverse();
        return ans.toString();
    }
}
