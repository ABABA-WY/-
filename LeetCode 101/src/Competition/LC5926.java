package Competition;

public class LC5926 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans=0;
        for(int i = 0; i < tickets.length; i=(i+1)%tickets.length){
            if(tickets[i] > 0){
                tickets[i]--;
                ans++;
            }
            if(tickets[k]==0)
                return ans;
        }
        return ans;
    }
}
