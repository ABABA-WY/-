package 链表;

//用数组来模拟链表
public class 数组模拟 {
    private static final int N = 10010;
    private static int head;
    private static int[] val = new int[N];
    private static int[] next = new int[N];
    private static int index;

    //初始化
    public void init() {
        head = -1;
        index = 0;
    }

    //将x插到头结点
    public void add_to_head(int x) {
        val[index] = x;
        next[index] = head;
        head = index++;
    }

    //将x插到下标是k的节点后面
    public void add_to_k(int k, int x) {
        val[index] = x;
        next[index] = next[k];
        next[k] = index++;
    }

    //将下标k的下个数删除
    public void remove(int k) {
        next[k] = next[next[k]];
    }
}
