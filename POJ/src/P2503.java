import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class P2503 {
    public static void main(String[] args) {
        Map<String,String> ans=new HashMap<>();
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String s1="";
            String s2="";
            if(input.hasNext()){
                s1=input.next();
            }
            if(input.hasNext()){
                 s2 = input.next();
            }
            ans.put(s2, s1);
        }
        while (input.hasNext()){
            String s=input.next();
            if(ans.containsKey(s))
                System.out.println(ans.get(s));
            else
                System.out.println("eh");
        }
    }
}
