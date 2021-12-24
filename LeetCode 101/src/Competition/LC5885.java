package Competition;

import java.util.Arrays;

public class LC5885 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum=0;
        for(int i=0;i < seats.length; i++){
            sum+=Math.abs(seats[i]-students[i]);
        }
        return sum;
    }
}
