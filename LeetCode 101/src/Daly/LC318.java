package Daly;

public class LC318 {
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] ans=new int[n];
        //用位运算来保存字符串中出现的字符
        for(int i = 0; i < n; i++){
            String word = words[i];
            int num=1;
            for(int j=0;j<word.length(); j++){
                num=num<<(word.charAt(j)-'a');
                ans[i]|=num;
                num=1;
            }
            System.out.println(ans[i]);
        }
        int res=0;
        //检查是否出现相同字符，若不出现则执行计算
        //时间O(n^2)
        for(int i = 0; i < n; i++){
            for(int j=0;j<n; j++){
                if((ans[i]&ans[j])==0){
                    res=Math.max(words[i].length()*words[j].length(),res);
                }
            }
        }
        return res;
    }
}
