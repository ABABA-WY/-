import java.util.*;

public class P3295 {
    public static int q, p, r, s, t;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> ans = new ArrayList<String>();
        while (true) {
            String str = input.nextLine();
            if (str.equals("0"))
                break;
            else
                ans.add(str);
        }
        for (int i = 0; i < ans.size(); i++) {
            if (judge(ans.get(i)))
                System.out.println("tautology");
            else System.out.println("not");
        }
    }

    public static boolean judge(String str) {
        for (p = 0; p < 2; p++) {
            for (q = 0; q < 2; q++) {
                for (r = 0; r < 2; r++) {
                    for (s = 0; s < 2; s++) {
                        for (t = 0; t < 2; t++)
                            if (!solve(str) )
                                return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean solve(String str) {
        LinkedList<Integer> stack=new LinkedList<Integer>();
        for (int i = str.length() - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case 'p':
                    stack.add(p);
                    break;
                case 'q':
                    stack.add(q);
                    break;
                case 'r':
                    stack.add(r);
                    break;
                case 's':
                    stack.add(s);
                    break;
                case 't':
                    stack.add(t);
                    break;
                case 'K': {
                    int x=stack.getLast();
                    stack.remove(stack.getLast());
                    int y = stack.getLast();
                    stack.remove(stack.getLast());
                    stack.add(x & y);
                    break;
                }
                case 'A': {
                    int x=stack.getLast();
                    stack.remove(stack.getLast());
                    int y = stack.getLast();
                    stack.remove(stack.getLast());
                    stack.add(x | y);
                    break;
                }
                case 'N': {
                    int x = stack.getLast()^1;
                    stack.remove(stack.getLast());
                    stack.add(x);
                    break;
                }
                case 'C': {
                    int x=stack.getLast();
                    stack.remove(stack.getLast());
                    int y = stack.getLast()^1;
                    stack.remove(stack.getLast());
                    stack.add(x & y);
                    break;
                }
                case 'E': {
                    int x=stack.getLast();
                    stack.remove(stack.getLast());
                    int y = stack.getLast();
                    stack.remove(stack.getLast());
                    stack.add(x==y?1:0);
                    break;
                }

            }
        }
        return stack.getLast()==1;
    }
}
