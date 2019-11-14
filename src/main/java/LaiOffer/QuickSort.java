package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/5/19.
 */
public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null) {
            return array;
        }
        quickSort(array,0,array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(array,left,right);
        quickSort(array,left,pivotPos-1);
        quickSort(array,pivotPos+1,right);
    }
    public int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left,right);
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(array,leftBound++, rightBound--);
            }
        }
        swap(array,leftBound,right);
        return leftBound;
    }
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] array = {2,4,2,1,3,3,6,6};
        System.out.println(Arrays.toString(solution.quickSort(array)));
    }
}
