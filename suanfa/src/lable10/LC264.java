package lable10;

public class LC264 {
    public static void main(String[] args) {
        int n = 10;
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
        data[0] = 1;
        int pMult2 = 0;
        int pMult3 = 0;
        int pMult5 = 0;
        int index=0;
        while(index < n-1){
            index++;
            int d=Math.min(Math.min(data[pMult2]*2,data[pMult3] * 3),data[pMult5]*5);
            data[index]=d;
            while (data[pMult2]*2==data[index])
                pMult2++;
            while (data[pMult3] * 3 == data[index])
                pMult3++;
            while (data[pMult5]*5==data[index])
                pMult5++;
        }
        System.out.println(data[n-1]);
    }
}
