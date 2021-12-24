package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC5942 {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<Integer>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] % 2 != 0) continue;
            if(i > 0 && digits[i]==digits[i-1]) continue;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if(j > 0 && digits[j]==digits[j-1]) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] == 0) continue;
                    if(k > 0 && digits[k]==digits[k-1]) continue;
                    if (digits[i] % 2 == 0 && j != i && j != k && k != i) {
                        int x = digits[k] * 100 + digits[j] * 10 + digits[i];
                        if (!list.contains(x)) list.add(x);
                    }
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
}
