import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Random;

/**
 * Abstract test class for  implementations.
 * Implementing test classes must override the getIntSorter method.
 *
 * @author Erik Vanhainen
 * @version 2018-26-02
 */
public abstract class IntSorterTest {
    private Data[] oddArrays;
    private Data[] evenArrays;
    private Data[] ascendingArrays;
    private Data[] descendingArrays;
    private Data[] randomArrays;
    private Data allElementsEqualArray;
    private Data zeroElementsArray;
    private Data veryLargeArray;

    private IntSorter sorter;

    /**
     * Returns an implementation of the IntSorter interface. Extending classes
     * must override this method.
     * @return An implementation of Set.
     */
    protected abstract IntSorter getIntSorter();


    /**
     * Initiation arrays that gets tested.
     **/
    @Before
    public void setUp() {
        sorter = getIntSorter();

        oddArrays = new Data[]{
                new Data(101, 50, Data.Order.RANDOM),
                new Data(101, 50, Data.Order.ASCENDING),
                new Data(101, 50, Data.Order.DESCENDING),
        };
        evenArrays = new Data[]{
                new Data(100, 50, Data.Order.RANDOM),
                new Data(100, 50, Data.Order.ASCENDING),
                new Data(100, 50, Data.Order.DESCENDING),
        };
        ascendingArrays = new Data[] {
                new Data(100, 50, Data.Order.ASCENDING),
                new Data(50, 100, Data.Order.ASCENDING),
        };
        descendingArrays = new Data[]{
                new Data(100, 50, Data.Order.DESCENDING),
                new Data(50, 100, Data.Order.DESCENDING),
        };
        randomArrays = new Data[]{
                new Data(100, 50, Data.Order.RANDOM),
                new Data(50, 100, Data.Order.RANDOM),
        };

        allElementsEqualArray = new Data(100, 1, Data.Order.RANDOM);
        zeroElementsArray = new Data(0, 10, Data.Order.RANDOM);
        veryLargeArray = new Data(100000, 1000, Data.Order.RANDOM);
    }

    /**
     * Assert that odd arrays gets sorted.
     **/
    @Test
    public void oddArraysGetsSorted() {
        for (Data d : oddArrays) {
            int[] sortedArrJava = d.get();
            Arrays.sort(sortedArrJava);
            int[] sortedArrTest = d.get();
            sorter.sort(sortedArrTest);
            assertThat(sortedArrTest, equalTo(sortedArrJava));
        }
    }

    /**
     * Assert that even arrays gets sorted.
     **/
    @Test
    public void evenArraysGetsSorted() {
        for (Data d : evenArrays) {
            int[] sortedArrJava = d.get();
            Arrays.sort(sortedArrJava);
            int[] sortedArrTest = d.get();
            sorter.sort(sortedArrTest);
            assertThat(sortedArrTest, equalTo(sortedArrJava));
        }
    }

    /**
     * Assert that ascending arrays gets sorted.
     **/
    @Test
    public void ascendingArraysGetsSorted() {
        for (Data d : ascendingArrays) {
            int[] sortedArrJava = d.get();
            Arrays.sort(sortedArrJava);
            int[] sortedArrTest = d.get();
            sorter.sort(sortedArrTest);
            assertThat(sortedArrTest, equalTo(sortedArrJava));
        }
    }

    /**
     * Assert that descending arrays gets sorted.
     **/
    @Test
    public void descendingArraysGetsSorted() {
        for (Data d : descendingArrays) {
            int[] sortedArrJava = d.get();
            Arrays.sort(sortedArrJava);
            int[] sortedArrTest = d.get();
            sorter.sort(sortedArrTest);
            assertThat(sortedArrTest, equalTo(sortedArrJava));
        }
    }

    /**
     * Assert that random arrays gets sorted.
     **/
    @Test
    public void randomArraysGetsSorted() {
        for (Data d : randomArrays) {
            int[] sortedArrJava = d.get();
            Arrays.sort(sortedArrJava);
            int[] sortedArrTest = d.get();
            sorter.sort(sortedArrTest);
            assertThat(sortedArrTest, equalTo(sortedArrJava));
        }
    }

    /**
     * Assert that array with equal elements gets sorted.
     **/
    @Test
    public void allElementsEqualArrayGetsSorted() {
        int[] sortedArrJava = allElementsEqualArray.get();
        Arrays.sort(sortedArrJava);
        int[] sortedArrTest = allElementsEqualArray.get();
        sorter.sort(sortedArrTest);
        assertThat(sortedArrTest, equalTo(sortedArrJava));
    }

    /**
     * Assert that array with zero elements gets sorted.
     **/
    @Test
    public void zeroElementsArrayGetsSorted() {
        int[] sortedArrJava = zeroElementsArray.get();
        Arrays.sort(sortedArrJava);
        int[] sortedArrTest = zeroElementsArray.get();
        sorter.sort(sortedArrTest);
        assertThat(sortedArrTest, equalTo(sortedArrJava));
    }

    /**
     * Assert that very large array gets sorted.
     **/
    @Test
    public void veryLargeArrayGetsSorted() {
        if(sorter instanceof QuickSort) {
            int[] sortedArrJava = veryLargeArray.get();
            Arrays.sort(sortedArrJava);
            int[] sortedArrTest = veryLargeArray.get();
            sorter.sort(sortedArrTest);
            assertThat(sortedArrTest, equalTo(sortedArrJava));
        }
    }

}
