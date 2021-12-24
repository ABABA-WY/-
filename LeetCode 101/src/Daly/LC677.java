package Daly;

class Tire{
    Tire[] t;
    int value;
    public Tire(){
        t = new Tire[26];
        value = 0;
    }
}
class MapSum {
    Tire tire;
    int[] hash = new int[2510];

    public static void main(String[] args) {
        MapSum test = new MapSum();
        test.insert("apple",5);
        System.out.println(test.sum("app"));

    }
    public MapSum() {
        tire = new Tire();
    }

    public void insert(String key, int val) {
        Tire p=tire;
        for(char c:key.toCharArray()){
            int u=c-'a';
            if(p.t[u]==null)
                p.t[u] = new Tire();
            p=p.t[u];
        }
        p.value=val;

    }

    public int sum(String prefix) {
        Tire p=tire;
        int sum=0;
        for (char c : prefix.toCharArray()) {
            int u = c-'a';
            if(p.t[u] == null)
                return 0;
            p=p.t[u];
        }
        sum= p.value;
        return sum+dfs(p);
    }
    public int dfs(Tire p){
        int ans= p.value;
        for(int i=0;i<26;i++){
            if(p.t[i] != null){
                ans+=dfs(p.t[i]);
            }
        }
        return ans;
    }
}
