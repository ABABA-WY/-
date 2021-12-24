package lable9;

public class LC1138 {
    public static void main(String[] args) {
        int x = 0, y = 0;
        String target = "zdz";
        StringBuilder ans = new StringBuilder();
        for (char c : target.toCharArray()) {
            int nx = (c - 'a') / 5, ny = (c - 'a') % 5;
            if (nx < x) ans.append("U".repeat(x - nx));
            if (ny < y) ans.append("L".repeat(y - ny));
            if (ny > y) ans.append("R".repeat(ny - y));
            if (nx > x) ans.append("D".repeat(nx - x));
            ans.append("!");
            x = nx;
            y = ny;
        }
        System.out.println(ans);

    }
}
