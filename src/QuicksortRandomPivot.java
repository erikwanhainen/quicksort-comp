import java.util.Random;
/**
 * Class for a quicksort algoritm with random pivot.
 * @author Erik Vanhainen
 * @version 2018-26-02
 **/
public class QuicksortRandomPivot extends QuickSortSuper implements IntSorter {
    private Random random = new Random();

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
             int pivotIndex = left + random.nextInt(right - left);
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
