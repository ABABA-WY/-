package Daly;

public class LC488 {
    public int res=Integer.MAX_VALUE;
    int[] map=new int[26];
    char[] colors = {'R','Y','B','G','W'};
    public int findMinStep(String board, String hand) {
        for(int i=0;i<hand.length(); i++){
            map[hand.charAt(i)-'A']++;
        }
        find(new StringBuilder(board),0);
        return res>=Integer.MAX_VALUE?-1:res;
    }
    public void find(StringBuilder board, int cnt){
        if(cnt>=res)
            return;
        if(board.length()==0){
            res=Math.min(res,cnt);
            return;
        }
        for(int i=0;i<board.length(); i++){
            char c = board.charAt(i);
            int j=i;
            while (j+1<board.length() && board.charAt(j+1) ==c)
                j++;
            //单个字符，将两个插入到这个字符后面
            if(j==i&&map[c-'A']>=2){
                StringBuilder temp = new StringBuilder(board);
                map[c-'A'] -=2;
                temp.insert(i+1,c+""+c);
                find(eliminate(temp),cnt+2);
                map[c-'A'] -=2;//回溯
            }
            //两个字符相邻
            else if(j==i+1){

                //插入颜色相同的球
                if(map[c-'A']>=1) {
                    StringBuilder temp = new StringBuilder(board);
                    map[c - 'A'] -= 1;
                    temp.insert(i + 1, c);
                    find(eliminate(temp), cnt + 1);
                    map[c - 'A']++;
                }

                //插入颜色不相同的球
                for(int k=0;k<colors.length; k++){
                    if(colors[k]==c)
                        continue;
                    if(map[colors[k]-'A']>=1) {
                        StringBuilder temp = new StringBuilder(board);
                        map[colors[k] - 'A']--;
                        temp.insert(i + 1, colors[k]);
                        find(eliminate(temp), cnt + 1);
                        map[colors[k] - 'A']++;
                    }
                }
            }
        }
    }
    public StringBuilder eliminate(StringBuilder board){
        boolean flag=true;
        while (flag) {
            flag=false;
            for(int i = 0; i < board.length(); i++){
                char c = board.charAt(i);
                int j=i+1;
                while(j<board.length() && c ==board.charAt(j)){
                    j++;
                }
                if(j-i>=3){
                    board.delete(i,j);
                    flag = true;
                }
            }
        }
        return board;
    }
}
