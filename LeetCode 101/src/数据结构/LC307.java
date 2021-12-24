package 数据结构;

class NumArray {
    int[] array;
    public NumArray(int[] nums) {
        array=nums.clone();
    }

    public void update(int index, int val) {
        array[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum=0;
        for (int i = left; i <= right; i++) {
            sum += array[i];
        }
        return sum;
    }

}
