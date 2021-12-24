package 二分;

public class 二分查找 {
    static int[] array;

    public static void main(String[] args) {
        array = new int[]{1, 2, 3, 4, 5};
        System.out.println(bSearch1(array, 0));
        System.out.println(bSearch2(array, 2));
    }

    public static int bSearch1(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (array[mid] >= x) right = mid;
            else left = mid + 1;
        }
        if (array[left] == x)
            return left;
        return -1;
    }

    public static int bSearch2(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (array[mid] <= x) left = mid;
            else right = mid - 1;
        }
        if (array[left] == x)
            return left;
        return -1;
    }
}
