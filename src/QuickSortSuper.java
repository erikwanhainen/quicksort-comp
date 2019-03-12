/**
 * Super class for quicksort algoritm.
 * @author Erik Vanhainen
 * @version 2018-26-02
 **/
public class QuickSortSuper {

    /**
     * Partitions the array from a left and right index from a given pivot.
     * All elements less then the pivot is put on the left side and all
     * elements is put on the right side.
     * @param v the array that gets sorted.
     * @param left left index.
     * @param right right index.
     * @param pivot the pivot value.
     * @return index of pivot when array is partitioned.
     **/
    public int[] partition(int[] v, int left, int right, int pivot) {
        int[] arr = new int[2];
        while(left <= right) {
            while(v[left] < pivot) {
                left++;
            }
            while(v[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(v, left, right);
                left++;
                right--;
            }
        }
        arr[0] = left;
        arr[1] = right;
        return arr;
    }

    /**
     * Swaps two elemens from a list.
     * @param v the array that gets two values swaped.
     * @param i one of the elements that gets swaped.
     * @param j the other elements that gets swaped.
     **/
    public void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
