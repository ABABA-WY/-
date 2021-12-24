package 数学;

import java.util.Random;

class Solution {
    private int[] originals;
    private int[] array;
    Random random=new Random();
    public Solution(int[] nums) {
        array=nums;
        originals=nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originals;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j=randRange1(array.length,i);
            array[i]=array[j];
            array[j] = temp;
        }
        return array;
    }
    private int randRange1(int max,int min){
        return random.nextInt(max-min)+min;
    }
}
