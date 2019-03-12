import java.util.Random;
/**
 * Kattis submission.
 **/
public class QuickSort extends QuickSortSuper implements IntSorter {
    private Random random = new Random();
    private InsertionSort insertionSort = new InsertionSort();

    public void sort(int[] v) {
        sort(v, 0, v.length - 1);
    }

    private void sort(int[] v, int left, int right) {
        if(left < right) {
            if(right - left < 10) {
                insertionSort.sort(v, left, right);
            } else {
                int index[] = partition(v, left, right, medianPivot(v, left, right));
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

    private int medianPivot(int[] v, int left, int right) {
        int[] m = new int[3];
        for(int i = 0; i < 3; i++) {
            m[i] = v[left + random.nextInt(right - left)];
        }
        return Math.max(Math.min(m[0],m[1]), Math.min(Math.max(m[0],m[1]),m[2]));
    }
}
