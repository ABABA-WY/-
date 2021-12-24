package 链表;

public class 数组模拟单链表 {
    private static final int N = 100010;
    private static int head;
    private static int[] val = new int[N];
    private static int[] L = new int[N];
    private static int[] R = new int[N];
    private static int index;

    //初始化，0为左端点，1为右端点
    public void init() {
        L[1] = 0;
        R[0] = 1;
        index = 2;
    }


    //将x插到下标是k的节点后面
    public void add_to_k(int k, int x) {
        val[index] = x;
        R[index] = R[k];
        L[index] = k;
        L[R[k]] = index;
        R[k] = index++;
    }

    //将下标k的下个数删除
    public void remove(int k) {
        R[L[k]] = R[k];
        L[R[k]] = L[k];
    }

}
