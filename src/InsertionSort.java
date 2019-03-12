import java.util.Random;

/**
 * Class for insertionsort algoritm.
 * @author Erik Vanhainen
 * @version 2018-26-02
 **/
public class InsertionSort implements IntSorter {
    /**
     * Sorts the array.
     * @param v the array that gets sorted.
     **/
    public void sort(int[] v) {
        for(int i = 1; i < v.length; i++) {
            int key = v[i];
            int j = i - 1;
            while(j >= 0 && v[j] > key) {
                v[j+1] = v[j];
                j = j-1;
            }
            v[j+1] = key;
        }
    }

    /**
     * Sorts the array from a left and right index iteratively.
     * @param v the array that gets sorted.
     * @param left left index.
     * @param right right index.
     **/
    public void sort(int[] v, int left, int right) {
        for(int i = left + 1; i <= right; i++) {
            int key = v[i];
            int j = i - 1;
            while(j >= 0 && v[j] > key) {
                v[j+1] = v[j];
                j = j-1;
            }
            v[j+1] = key;
        }
    }
}
