/**
 * Class for a quicksort algoritm with fixed pivot and
 * insertionsort for small sub arrays.
 * @author Erik Vanhainen
 * @version 2018-26-02
 **/
public class QuicksortFixedPivotInsertion extends QuickSortSuper implements IntSorter {
    private InsertionSort insertionSort = new InsertionSort();

    /**
     * Sorts the array.
     * @param v the array that gets sorted.
     **/
    public void sort(int[] v) {
        sort(v, 0, v.length - 1);
    }

    /**
     * Sorts the array from a left and right index recursively.
     * @param v the array that gets sorted.
     * @param left left index.
     * @param right right index.
     **/
     private void sort(int[] v, int left, int right) {
         if(left < right) {
             if(right - left < 15) {
                 insertionSort.sort(v, left, right);
             } else {
                 int pivotIndex = (left + right)/2;
                 int index[] = partition(v, left, right, v[pivotIndex]);
                 int i = index[0];
                 int j = index[1];
                 if(left < j) {
                     sort(v, left, j);
                 }
                 if(i < right) {
                     sort(v, i, right);
                 }
             }
         }
     }
}
