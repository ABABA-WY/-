package 字符串;

public class LC12 {
    public String intToRoman(int num) {
        String s=String.valueOf(num);
        StringBuilder ans=new StringBuilder();
        int n=s.length();
        for (int i = 0; i < n; i++) {
            int x=(s.charAt(i)-'0')*(int)Math.pow(10,n-i-1);
            if(x>=1000){
                while(x>=1000){
                    ans.append("M");
                    x-=1000;
                }
            }
            else if(x>=500){
                if(x>=900){
                    ans.append("CM");
                }
                else {
                    ans.append("D");
                    while(x>=600){
                        ans.append("C");
                        x-=100;
                    }
                }
            }
            else if(x>=100){
                if(x>=400){
                    ans.append("CD");
                }
                else{
                    while(x >=100){
                        ans.append("C");
                        x-=100;
                    }
                }
            }
            else if(x>=50){
                if(x>=90){
                    ans.append("XC");
                }
                else {
                    ans.append("L");
                    while (x >= 60) {
                        ans.append("X");
                        x-=10;
                    }
                }
            }
            else if (x >= 10) {
                if(x>=40){
                    ans.append("XL");
                }
                else {
                    ans.append("X");
                    while (x >= 20) {
                        ans.append("X");
                        x -= 10;
                    }
                }
            }
            else if(x >=5){
                if(x >=9){
                    ans.append("IX");
                }
                else {
                    ans.append("V");
                    while (x>=6){
                        ans.append("I");
                        x-=1;
                    }
                }
            }
            else if (x >= 1) {
                if(x>=4){
                    ans.append("IV");
                }
                else{
                    while (x >= 1) {
                        ans.append("I");
                        x -= 1;
                    }
                }
            }
        }
        return ans.toString();
    }
}
