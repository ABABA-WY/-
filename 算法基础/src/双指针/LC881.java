package 双指针;

import java.util.Arrays;

public class LC881 {
    public static void main(String[] args) {
        int[] people = {2,4,5,1};
        int limit = 6;
        System.out.println(new LC881().numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int sum = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res++;
        }
        return res;
    }
}
