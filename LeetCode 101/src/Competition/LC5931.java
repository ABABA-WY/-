package Competition;

public class LC5931 {
    public int wateringPlants(int[] plants, int capacity) {
        int i=0;
        int n = plants.length;
        int m=capacity;
        int ans=0;
        while (i<n){
            if(capacity-plants[i]>=0){
                capacity-=plants[i];
                ans++;
                i++;
            }
            else{
                capacity=m;
                ans+=i*2;
            }

        }
        return ans;
    }
}
