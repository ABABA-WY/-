package Daly;


class WordDictionary {
    class TriNode{
        TriNode[] tns=new TriNode[26];
        boolean isWord;
    }
    TriNode root;
    public WordDictionary() {
        root=new TriNode();
    }

    public void addWord(String word) {
        TriNode p=root;
        int n=word.length();
        for (int i = 0; i < n; i++) {
            int u=word.charAt(i)-'a';
            if(p.tns[u]==null){
                p.tns[u] = new TriNode();
            }
            p=p.tns[u];
        }
        p.isWord=true;
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }
    public boolean dfs(String word,TriNode p,int idx){
        int n=word.length();
        if(n==idx)  return p.isWord;
        char c = word.charAt(idx);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(p.tns[i]!=null&&dfs(word,p.tns[i],idx+1))
                    return true;
            }
            return false;
        }
        else {
            int u=c-'a';
            if(p.tns[u]==null)
                return false;
            else {
                return dfs(word, p.tns[u], idx + 1);
            }
        }
    }
}
