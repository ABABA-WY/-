package 数据结构;

import java.util.Arrays;

class TripleInOne{
    public int[] a;
    private int stackSize;
    private int index1,index2,index3;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        a = new int[stackSize * 3];
        index1 = -1;// [0,stackSize)
        index2 = stackSize - 1;//[stackSize,stackSize*2)
        index3 = stackSize * 2 - 1 ;//[stackSize*2,stackSize*3)
        for (int i = 0; i < a.length; i++) {
            a[i] = -1;
        }
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0){
            if (index1+1 < stackSize){
                index1++;
                a[index1] = value;
            }else{
                return;
            }
        }
        if (stackNum == 1){
            if (index2+1 < stackSize*2){
                index2++;
                a[index2] = value;
            }else{
                return;
            }
        }
        if (stackNum == 2){
            if (index3+1 < stackSize*3){
                index3++;
                a[index3] = value;
            }
        }
    }


    public int pop(int stackNum) {
        if (stackNum == 0 && index1 >= 0){
            index1--;
            return a[index1+1];
        }
        if (stackNum == 1 && index2 >= stackSize){
            index2--;
            return a[index2+1];
        }
        if (stackNum == 2 && index3 >= stackSize*2){
            index3--;
            return a[index3+1];
        }
        return -1;
    }

    public int peek(int stackNum) {
        int result = -1;
        if (stackNum == 0 && index1 >= 0){
            result = a[index1];
        }
        if (stackNum == 1 && index2 >= stackSize){
            result = a[index2];
        }
        if (stackNum == 2 && index3 >= stackSize*2){
            result = a[index3];
        }
        return result;
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0 && index1 == -1){
            return true;
        }
        if (stackNum == 1 && index2 == stackSize-1){
            return true;
        }
        if (stackNum == 2 && index3 == stackSize*2-1){
            return true;
        }
        return false;
    }
}

