package lable9;

public class LC794 {
    public static void main(String[] args) {
        String[] board = {"XOX", "O O", "XOX"};
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }
        }
        if (xCount != oCount && oCount != xCount - 1) return;
        if (!win(board, 'X') && oCount != xCount - 1) return;
        if (!win(board, 'O') && oCount != xCount - 1) return;

    }

    public static boolean win(String[] board, char p) {
        for (int i = 0; i < 3; i++) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i))
                return false;
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2))
                return false;
        }
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2))
            return false;
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0))
            return false;
        return true;
    }
}