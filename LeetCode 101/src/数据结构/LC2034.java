package 数据结构;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {
    private Map<Integer,Integer> ans;
    private TreeMap<Integer,Integer> priceMap;
    int currentT;
    public StockPrice() {
        ans=new HashMap<>();
        priceMap = new TreeMap<>();
        currentT = 0;
    }

    public void update(int timestamp, int price) {
        if(ans.containsKey(timestamp)){
            int oldPrice=ans.get(timestamp);
            priceMap.put(oldPrice,priceMap.get(oldPrice)-1);
            if(priceMap.get(oldPrice)==0){
                priceMap.remove(oldPrice);
            }
        }
        priceMap.put(price,priceMap.getOrDefault(price,0)+1);
        ans.put(timestamp,price);
        currentT=Math.max(currentT,timestamp);
    }

    public int current() {
        return ans.get(currentT);
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}