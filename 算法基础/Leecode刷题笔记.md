# Leecode刷题笔记



### 前缀和



[LC2017](https://leetcode-cn.com/problems/grid-game/)

- 开两个前缀和数组，dp1存第一行从1到n-1的前缀和，dp2存第二行从n-2到0的前缀和
- 第一个机器人的值**dp1[k]+dp2[k]**
- 第二个机器人的值要么只存在与第一行，要么存在于第二行，最大值为**Math.max(dp1[n - 1] - dp1[k], dp2[0] - dp2[k])**
- 定义一个存储位置的数k，每当存在i使的机器人2所得的数值变小时，更新k位置

```java
package 前缀和;

public class LC2017 {
    public static void main(String[] args) {
        int[][] grid = {{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}};
        //[[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]
        System.out.println(new LC2017().gridGame(grid));
    }

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = 0;
        //[[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]
        for (int i = 1; i < n; i++) {
            dp1[i] = dp1[i - 1] + grid[0][i];
        }
        dp2[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = dp2[i + 1] + grid[1][i];
        }
        int k = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
/*            if(dp1[i]+dp2[i]>dp1[k]+dp2[k])//第一个机器人的数值最大
                k=i;*/
            if (Math.max(dp1[n - 1] - dp1[k], dp2[0] - dp2[k]) > Math.max(dp1[n - 1] - dp1[i], dp2[0] - dp2[i]))//第二个机器人的数值最小
                k = i;
        }
        max = Math.max(dp1[n - 1] - dp1[k], dp2[0] - dp2[k]);
        return max;
    }
}
```





[和可被k整除的子数组](https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/)

- 通常，涉及连续子数组问题的时候，我们使用前缀和来解决。

  我们令 **P[i]=nums[0]+nums[1]+…+nums[i]**。那么每个连续子数组的和**sum(i,j)** 就可以写成 **P[j]−P[i−1]**（其中 0 < i < j0<i<j）的形式。此时，判断子数组的和能否被 k 整除就等价于判断**(P[j]−P[i−1])modk==0**，根据 **同余定理**，只要**P[j]modk==P[i−1]modk**，就可以保证上面的等式成立。

  因此我们可以考虑对数组进行遍历，在遍历同时统计答案。当我们遍历到第 ii 个元素时，我们统计以 ii 结尾的符合条件的子数组个数。我们可以维护一个以前缀和模 kk 的值为键，出现次数为值的哈希表record，在遍历的同时进行更新。这样在计算以 ii 结尾的符合条件的子数组个数时，根据上面的分析，答案即为 [0..i-1][0..i−1] 中前缀和模 k 也为 P[i]modk 的位置个数，即record[P[i]modk]。

  最后的答案即为以每一个位置为数尾的符合条件的子数组个数之和。需要注意的一个边界条件是，我们需要对哈希表初始化，记录 record[0]=1，这样就考虑了前缀和本身被 kk 整除的情况。

  

```java
package 前缀和;

import java.util.HashMap;
import java.util.Map;

public class LC974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        //前缀和计算；
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //k本身
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            //取模
            int key = (sum % k + k) % k;
            int contain = map.getOrDefault(key, 0);
            ans += contain;
            map.put(key, contain + 1);
        }
        return ans;
    }
}
```









### 二分



[搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

- 时间复杂度： ***O*(log*n*)**
- 空间：**O(1)**

- 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。

- 如果 [mid, r] 是有序数组，且 target 的大小满足 (nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。

  

```java
package 二分查找;

public class LC33 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target=3;
        System.out.println(new LC33().search(nums,target));
    }
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int mid=l+(r-l)/2;
        while(l<=r){
            mid=l+(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                if(target<=nums[r]&&nums[mid]> nums[r]){
                    l=mid+1;
                }
                else
                    r=mid-1;
            }
            else{
                if(target>=nums[l]&&nums[l]>nums[mid]){
                    r=mid-1;
                }
                else
                    l = mid + 1;
            }

        }
        return nums[mid]==target?mid:-1;
    }
}
```





**二分加排序**



[每一个查询的最大美丽值](https://leetcode-cn.com/problems/most-beautiful-item-for-each-query/)

- 将items数组进行排序，先按照价格排序，然后再按照美丽值排序，这里要重写compare函数（要牢记）
- 更新每一个items的美丽值，将每一个items的美丽值设置为当前或之前所遇到的最大的数。
- 通过二分查找的方式查看是否有符合条件的价格，因为小于等于都算上，所以二分的时候，l应该更新为mid，这样便不会跳过当前值，最后判断是否符合条件，如果符合，则将这个美丽值加到数组中。

```Java
package Competition;

import java.util.Arrays;
import java.util.Comparator;


public class LC5912 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,new Comparator<int[]>() {
            public int compare(int[]a,int[]b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else
                    return a[0] - b[0];
            }
        });
        int value=0;
        for(int i = 0; i < items.length; i++){
            if(items[i][1]<=value){
                items[i][1]=value;
            }
            else {
                value = items[i][1];
            }
        }
        int n=queries.length;
        int m=items.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int l=0,r=m-1;
            while(l<r){
                int mid=l+(r-l)/2+1;
                if(items[mid][0]>queries[i])
                    r=mid-1;
                else
                    l = mid;
            }
            ans[i]=items[r][0]<=queries[i] ? items[r][1] : 0;
        }

        return ans;
    }
}
```



[区间内查找数字的频率](https://leetcode-cn.com/problems/range-frequency-queries/)

- 因为题目中给的数据范围较大，并且查询次数为**10^5**，所以只能用**logn**时间复杂度的查询算法，即**二分查找**
- 数据的存储方式有很多种，可以用**map**和**邻接表**来存储，这里用 **List<List<Integer>>**来模拟邻接表，开始时

​		先将表头初始化，再往表头节点之后添加每次表头节点在数组中出现时的坐标。

- 我们只需要从当前表头节点中找出left和right之间**所有的坐标数量**，即可得到答案。
- 因为坐标是按顺序添加，邻接表已经自然排序，故只需要logn时间复杂度
- 在进行二分查找时，如果所找到左边的点的坐标小于left或者大于right，则说明所要查询的区间内不含有value
- 找到的右坐标比right大，则可以将右坐标进行左移。
- 最后只需计算左右点的差值。

```java
package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RangeFreqQuery {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public RangeFreqQuery(int[] arr) {
        //表头节点初始化
        for (int i = 0; i < 10010; i++) {
            ans.add(new ArrayList<Integer>());
        }
        //在表头节点之后添加坐标
        for (int i = 0; i < arr.length; i++) {
            ans.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (ans.get(value).size() == 0) return 0;
        List<Integer> now = ans.get(value);
        int l = 0, r = now.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (now.get(mid) < left) {
                l = mid + 1;
            } else
                r = mid;
        }
        //记录当前的左坐标
        int a = l;
        //不符合条件
        if (a > right || a < left) return 0;
        r = now.size() - 1;
        //找到与right相等或者比right稍大的数
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (now.get(mid) > right) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //当前右坐标
        int b = l;
        //如果当前坐标比right大，则坐标左移
        while(now.get(b) > right) b--;

        return b - a + 1;
    }
}
```



### Tire树

[键值映射](https://leetcode-cn.com/problems/map-sum-pairs/)

```java
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
        return dfs(p);
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
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```





### 数据结构



[反转偶数长度的节点](https://leetcode-cn.com/problems/reverse-nodes-in-even-length-groups/)

- 定义一个List，存储链表的所有val
- 每次用另一个List取出cur_len长度的数据
- 如果i+cur_len的长度大于n，则只取到n，即链表的最后一个节点
- 如果cures.size()%2==0，则将List反转，否则则不用
- 将cures.size()长度的数据存储到新创建的链表中
- 存储结束后，更新i和cur_len的值。

```java
package Competition;

import java.util.*;

public class LC5927 {
    List<Integer> list = new ArrayList<Integer>();

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int n = getLength(head);
        List<Integer> cures;
        int cur_len = 1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //从0开始
        int i = 0;
        while (i < n) {
            //取出该段，同时注意边界问题
            cures = new ArrayList<>(list.subList(i, Math.min(i + cur_len, n)));
            if (cures.size() % 2 == 0) {
                //用Collection类的reverse将链表反转
                Collections.reverse(cures);
            }
            for (int j = 0; j < cures.size(); j++) {
                p.next = new ListNode(cures.get(j));
                p = p.next;
            }
            i += cur_len;
            cur_len++;
        }
        return dummy.next;
    }


    public int getLength(ListNode head) {
        int n = 0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
            n++;
        }
        return n;
    }
}
```



[删除链表倒数第n个节点](https://leetcode-cn.com/problems/SLwz0R/)

```java
package 数据结构;

public class JZ021 {
    //正常解法
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        len++;
        if (len == 1)
            return null;
        if (len == n) {
            head = head.next;
            return head;
        }
        p = head;
        for (int i = 1; i < len - n; i++) {
            p = p.next;
        }
        p.next = p.next.next == null ? null : p.next.next;
        return head;
    }
*/
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //考虑到删除头结点的问题，所以创建另一个头结点
        ListNode domy = new ListNode(0, head);
        ListNode fast = head, low = domy;
        //fast先走n步
        while (n-- > 0) {
            fast = fast.next;
        }
        //令low指向要被删除的节点
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return domy.next;
    }
}
```



[复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

> 构建哈希表，将每个节点以及新建副本都保存到map中
>
> 通过访问哈希表来实现链表的复制。

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node cur = head;
        //将所有节点都复制一遍
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
```



### 模拟



[解码斜向换位密码](https://leetcode-cn.com/problems/decode-the-slanted-ciphertext/)

- 时间复杂度：O(n)
- 空间：O(n)
- 最主要的方法为化一维为二维，并从二维坐标中找出字符

```java
package Competition;

public class LC5928 {
    public static void main(String[] args) {
        String encodedText = "ch   ie   pr";
        int rows = 3;
        System.out.println(new LC5928().decodeCiphertext(encodedText, rows));
    }

    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int col = n / rows;
        StringBuilder sb = new StringBuilder();
        //按列寻找，直至遍历完最后一列
        for (int i = 0; i < col; i++) {
            int r = 0;
            int c = i;
            while (r < rows && c < col) {
                 //找出当前坐标对应的字符
                //当前行*总列数+当前列=当前二维坐标
                sb.append(encodedText.charAt(r * col + c));
                r++;
                c++;
            }
        }
        int i = sb.length() - 1;
        for (; i > 0 && sb.charAt(i) == ' '; i--) ;
        return sb.toString().substring(0, i + 1);
    }
}
```







### 贪心



[可以到达的最远建筑物](https://leetcode-cn.com/problems/furthest-building-you-can-reach/)

**贪心加优先队列**

```java
package 贪心;

import java.util.PriorityQueue;

public class LC1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //用来存放用去的砖头,降序排序
        PriorityQueue<Integer> ans = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            int sub = heights[i] - heights[i - 1];
            //后面的楼比前面的高
            if (sub > 0) {
                //先消耗砖头
                ans.add(sub);
                bricks -= sub;
                if (bricks < 0) {
                    //砖头不够，梯子来凑
                    if (ladders > 0) {
                        ladders--;
                        bricks += ans.poll();
                    }
                    //梯子不够，回家吃饭
                    else
                        return i - 1;
                }
            }
        }
        //到达最后一栋楼
        return heights.length - 1;
    }
}
```



[过河问题](https://www.luogu.com.cn/problem/P1809)

- 不妨先对所有人按所需时间ai从小到大排序

- 对于河此岸人数n==2的情况，很显然，耗费时间为二者中最长的一个，两人即可全部到达对岸；
- 对于n==3的情况，先让最快的人带一人去对岸，最快的人回来，再接另一人去对岸，总共花费时间为a1+a2+a3

- 那么对于n>3的情况怎么来呢？我们可以先运送此岸上用时最长的两人，那么最优秀的运送方法有两种

- 1.最快的1载最慢的n去对岸，1回此岸继续载次慢的n-1去对岸，a1最后再回到此岸，共用时2*a1+an+a(n-1)

- 2.最快的人1与次快的人2去对岸，最快的人1回到此岸，最慢的人n再与次慢的人n-1去对岸，次快的人2回到此岸，共用时a1+2*a2+an



```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int[] people = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            people[i] = input.nextInt();
        }
        Arrays.sort(people);

        int time = 0;
        while (n > 3) {
            time += Math.min(people[1] * 2 + people[n] + people[n - 1], people[1] + people[2] * 2 + people[n]);
            n -= 2;
        }
        if (n == 3) {
            time += people[1] + people[2] + people[3];
        }
        if (n == 2) {
            time += people[2];
        }
        if (n == 1) {
            time += people[1];
        }
        System.out.println(time);
    }
}
```





### 排序



**Map的value排序**

[出现频率最高的k个数字](https://leetcode-cn.com/problems/g5c51o/)

- 将数组中的所有数字用map存起来
- 将map转换成list，在通过list的排序对map的value进行排序
- 对list进行排序时用到**collections.sort**的方法
- 如果要对map的key进行排序，则可以调用Treemap（升序，逆序只需要使用lambda表达式）



```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) ->
                o2.getValue() - o1.getValue());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> e = list.get(i);
            ans[i] = e.getKey();
        }
        return ans;
    }
}
```



- 也可以用优先队列的方式进行排序

```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (queue.size() == k) {
            if (queue.peek()[1] < entry.getValue()) {
                queue.poll();
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        } else {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
        res[i] = queue.poll()[0];
    }
    return res;
}
```







### 回溯



[全排列](https://leetcode-cn.com/problems/permutations-ii/)

[组合总和2](https://leetcode-cn.com/problems/combination-sum-ii/)

- 时间复杂度：*O*(*N*×*N*!)，这里 *N* 为数组的长度。
- 空间：O（N）

```java
package 图论;

import java.util.*;

public class LC46 {
    //只回溯
    /*List<List<Integer>> ans=new ArrayList<List<Integer>>();
    boolean[] visited;
    int len;
    public List<List<Integer>> permute(int[] nums) {
        len=nums.length;
        visited=new boolean[len];
        dfs(nums,new ArrayList<Integer>());
        return ans;
    }
    public void dfs(int[] nums,List<Integer> list){
        if(list.size()==len){
            //list 公用一个内存地址
            //如果只是add(list) 的话，最终ans中的链表内容为空
            //所以要创建一片新内存地址
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                dfs(nums,list);
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }*/
    //回溯加剪枝
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    boolean[] visited;
    int len;

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        len = nums.length;
        visited = new boolean[len];
        dfs(nums, new ArrayList<Integer>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> list) {
        if (list.size() == len) {
            //list 公用一个内存地址
            //如果只是add(list) 的话，最终ans中的链表内容为空
            //所以要创建一片新内存地址
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            //回溯的时候，如果是相同的数字，然后前面的数字没有访问过，
            // 说明现在的数字要在相同的那个没有访问过的数字前面。而这种情况已经发生过了，所以continue；
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]))
                continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
```







### 动态规划





[01矩阵](https://leetcode-cn.com/problems/01-matrix/)

对于任一点 ((i,j)，距离 0 的距离为：f(i,j)=

 if matrix[i] [j] == 1：1+min(f(i−1,j),f(i,j−1),f(i+1,j),f(i,j+1))}
if matrix[i] [j] == 0：0

- 首先从左上角开始递推 dp [i] [j]是由其 「左方」和 「左上方」的最优子状态决定的；
- 然后从右下角开始递推 dp [i] [j]是由其 「右方」和 「右下方」的最优子状态决定的；

```java
package 动态规划;

import java.util.Arrays;

public class LC542 {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        //Integer.MAX_VALUE/2是为了防止进行加法后溢出变成负数
        for(int i=0;i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (mat[i][j] != 0) {
                    if (j < m - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                    if (i < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                }
            }
        }
        return dp;
    }
}
```







[解码方法](https://leetcode-cn.com/problems/decode-ways/)

```java
package 动态规划;

import java.util.Arrays;

public class LC91 {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==0) return 0;
        int pre = s.charAt(0)-'0';
        if(pre==0) return 0;
        if(n==1) return 1;
        s=" " + s;
        //第i个数可以构成的解码数量
        int[] dp=new int [n+1];
        char [] cs=s.toCharArray();
        dp[0]=1;
        for(int i=1;i<=n; i++){
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0';
            int b = (cs[i-1] - '0')*10+cs[i]-'0';
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if(1<=a&&a<=9)
                dp[i]=dp[i-1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if(10<=b&&b<=26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
```
