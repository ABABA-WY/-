package Competition;

public class LC5930 {
    public int maxDistance(int[] colors) {
        int ans=0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                if (colors[i] != colors[j])
                    ans=Math.max(ans, j-i);
            }
        }
        return ans;
    }
}
