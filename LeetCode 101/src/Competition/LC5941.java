package Competition;

import java.util.*;

public class LC5941 {
    public static void main(String[] args) {
        int n=11;
        int[][]m={{5,1,4},{0,4,18}};
        int f=1;
        List<Integer> l=new LC5941().findAllPeople(n,m,f);
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> res = new ArrayList<Integer>();
        int m = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        boolean[] st = new boolean[n];
        st[0] = true;
        st[firstPerson] = true;
        res.add(0);
        res.add(firstPerson);
        for (int i = 0; i < m; i++) {
            if (st[meetings[i][0]] && !st[meetings[i][1]]) {
                System.out.println(meetings[i][0]+" "+meetings[i][ 1]);
                res.add(meetings[i][1]);
                st[meetings[i][1]] = true;
                int j = i - 1;
                while (j >= 0 && meetings[j][2] == meetings[i][2]) {
                    if (st[meetings[j][0]] && !st[meetings[j][1]]) {
                        res.add(meetings[j][1]);
                        st[meetings[j][1]] = true;
                    }
                    if (!st[meetings[j][0]] && st[meetings[j][1]]) {
                        res.add(meetings[j][0]);
                        st[meetings[j][0]] = true;
                    }
                    j--;
                }
            }
            if (!st[meetings[i][0]] && st[meetings[i][1]]) {
                System.out.println(meetings[i][0]+" "+meetings[i][ 1]);
                res.add(meetings[i][0]);
                st[meetings[i][0]] = true;
                int j = i - 1;
                while (j >= 0 && meetings[j][2] == meetings[i][2]) {
                    if (st[meetings[j][0]] && !st[meetings[j][1]]) {
                        res.add(meetings[j][1]);
                        st[meetings[j][1]] = true;
                    }
                    if (!st[meetings[j][0]] && st[meetings[j][1]]) {
                        res.add(meetings[j][0]);
                        st[meetings[j][0]] = true;
                    }
                    j--;
                }
            }
        }
        return res;
    }
}
