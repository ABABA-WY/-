package 枚举;

public class LC2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[] map=new int[26];
        for(int i = 0; i < word.length(); i++){
            map[word.charAt(i)-'a']++;
        }
        boolean ok1;
        boolean ok2;
        for (int i = 0; i < m; i++) {
            int[] ans=map.clone();
            int c1 = 0;//空格数量
            int c2 = 0;//已有相关字母数量
            int c3 = 0;//已有无关字符的数量
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    if (c1 + c2 == word.length()&&c3==0) {
                        return true;
                    }
                    c1 = 0;
                    c2 = 0;
                    c3 = 0;
                } else {
                    if (board[i][j] == ' ')
                        c1++;
                    else if (ans[board[i][j]-'a']>0){
                        c2++;
                        ans[board[i][j]-'a']--;
                    }
                    else
                        c3++;
                }
            }
            if (c1 + c2 == word.length()&&c3==0)
                return true;
        }
        for (int j = 0; j < n; j++) {
            int[] ans=map.clone();
            int c1 = 0;//空格数量
            int c2 = 0;//已有字母数量
            int c3 = 0;//已有无关字符的数量
            for (int i = 0; i < m; i++) {
                if (board[i][j] == '#') {
                    if (c1 + c2 == word.length()&&c3==0) {
                        return true;
                    }
                    c1 = 0;
                    c2 = 0;
                    c3 = 0;
                } else {
                    if (board[i][j] == ' ')
                        c1++;
                    else if (ans[board[i][j]-'a']>0){
                        c2++;
                        ans[board[i][j]-'a']--;
                    }
                    else
                        c3++;
                }

            }
            if (c1 + c2 == word.length()&&c3==0)
                return true;
        }
        return false;
    }
}


