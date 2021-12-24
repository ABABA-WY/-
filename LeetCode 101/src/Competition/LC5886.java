package Competition;

public class LC5886 {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3)
            return false;
        int countA = 0;
        int countB = 0;
        StringBuilder sb = new StringBuilder(colors);
        for (int j = 1; j < sb.length() - 1; j++) {
            if (sb.charAt(j) == 'A' && sb.charAt(j - 1) == 'A' && sb.charAt(j + 1) == 'A') {
                countA++;
                sb.replace(j, j, "");
            }
        }

        for (int j = 1; j < sb.length() - 1; j++) {
            if (sb.charAt(j) == 'B' && sb.charAt(j - 1) == 'B' && sb.charAt(j + 1) == 'B') {
                countB++;
                sb.replace(j, j, "");
            }
        }


        if (countA > countB) return true;
        return false;
    }
}
