import java.util.Scanner;

public class P1177 {
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        qSort(arr,0,n-1);
        for(int i=0;i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void qSort(int[] a,int l,int r){
        if(l>=r)
            return;
        int x=a[(l+r)/2];
        int i=l-1;
        int j=r+1;
        while(i<j){
            do{
                i++;
            }
            while(a[i]<x) ;
            do {
                j--;
            }
            while(a[j]>x) ;
            if (i < j) {
                int temp = a[l];
                a[l] = a[r];
                a[r]=temp;
            }
        }
        qSort(a,l,j);
        qSort(a,j+1,r);
    }
}
