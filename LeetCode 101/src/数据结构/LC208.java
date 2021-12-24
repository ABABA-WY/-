package 数据结构;

class Trie {
    private int[][] ans;
    private int idx;
    private boolean[] flag;
    public static void main(String[] args) {
        Trie test=new Trie();
        test.insert("apple");
        System.out.println(test.search("apple"));
        System.out.println(test.search("app"));
        System.out.println(test.startsWith("a"));
    }
    public Trie() {
        ans = new int[2001][26];
        idx=0;
        flag=new boolean[2001];
    }
    public void insert(String word) {
        int p=0;
        for(char c:word.toCharArray()){
            int u=c-'a';
            if(ans[p][u]==0){
                ans[p][u]=++idx;
            }
            p=ans[p][u];
        }
        flag[p]=true;
    }

    public boolean search(String word) {
        int p=0;
        for (char c : word.toCharArray()) {
            int u = c-'a';
            if (ans[p][u] == 0) {
                return false;
            }
            p = ans[p][u];
        }
        if(!flag[p])
            return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        int p=0;
        for (char c : prefix.toCharArray()) {
            int u = c-'a';
            if (ans[p][u] == 0) {
                return false;
            }
            p = ans[p][u];
        }
        return true;
    }
}
