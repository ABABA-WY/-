public class JZ12 {
    boolean[][] vis;
    int[] d = {1, 0, -1, 0, 1};
    int m, n;

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new JZ12().exist(board,word));
    }
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(word.charAt(0) == board[i][j]) {
                    vis[i][j] = true;
                    if (isIn(board, word, 1, i, j))
                        return true;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean isIn(char[][] board, String word, int idx, int x, int y) {//idx表示当前指针
        if (idx == word.length())
            return true;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i];
            int ny = y + d[i + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (vis[nx][ny]) continue;
                if (board[nx][ny] == word.charAt(idx)) {
                    idx++;
                    vis[nx][ny] = true;
                    flag = flag || isIn(board, word, idx, nx, ny);
                    idx--;
                    vis[nx][ny] = false;
                }
            }
        }
        return flag;
    }
}

