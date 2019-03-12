import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for testing comparing sorting algorithms.
 *
 * @author Erik Vanhainen
 * @version 2019-11-03
 */
public final class TimingExample {

    /**
     * Loops through each implementation of IntSorter along with javas built in
     * sorting algorithm. The time to sort an array for each implementation and
     * testing size is measured ten times and an average is calculated and stored.
     *
     * Two tests are preformed. The first includes insertion sort but is with
     * a bit smaller arrays. The second excludes insertion sort and is with
     * bigger arrays.
     *
     * A matlab script for represeting the results as a bar chart is then printed.
     *
    **/
    public static void main(String[] args) {

        /**
         * Implementations of IntSorter tested excluding insertion sort.
         **/
        IntSorter[] a1 = new IntSorter[] {
            new QuicksortFixedPivot(),
            new QuicksortFixedPivotInsertion(),
            new QuicksortRandomPivot(),
            new QuicksortRandomPivotInsertion(),
        };

        /**
         * Size of arrays tested.
         **/
        int[] n1 = {
            50000,
            100000,
            500000,
            1000000,
        };

        /**
         * Loop where the test is preformed.
         **/
        ArrayList<ArrayList<String>> finalResult1 = new ArrayList<ArrayList<String>>();
        for(int j = 0; j < a1.length+1; j++) {
            Data[] tests = {
                new Data(n1[0], n1[0], Data.Order.RANDOM),
                new Data(n1[0], n1[0], Data.Order.RANDOM),
                new Data(n1[0], n1[0], Data.Order.RANDOM),

                new Data(n1[0], n1[0], Data.Order.RANDOM),
                new Data(n1[1], n1[1], Data.Order.RANDOM),
                new Data(n1[2], n1[2], Data.Order.RANDOM),
                new Data(n1[3], n1[3], Data.Order.RANDOM),
            };
            ArrayList<String> results = new ArrayList<String>();
            Stopwatch s = new Stopwatch();
            for (Data d : tests) {
                ArrayList<String> avrResults = new ArrayList<String>();
                for(int k = 0; k < 10; k++) {
                    if(j == a1.length) {
                        s.start();
                        Arrays.sort(d.get());
                        s.stop();
                        avrResults.add(String.valueOf(s.milliseconds()));
                        s.reset();
                    } else {
                        s.start();
                        a1[j].sort(d.get());
                        s.stop();
                        avrResults.add(String.valueOf(s.milliseconds()));
                        s.reset();
                    }
                }
                long avr = 0;
                for(int i = 0; i < avrResults.size(); i++) {
                    avr += Long.valueOf(avrResults.get(i));
                }
                avr /= avrResults.size();
                results.add(String.valueOf(avr));
            }
            ArrayList<String> validResults = new ArrayList<>(results.subList(3, results.size()));
            finalResult1.add(validResults);
        }

        /**
         * Printing matlab script for table 1.
         **/
        System.out.println();
        ArrayList<String> classNames1 = new ArrayList<String>();
        for(int i = 0; i < finalResult1.size(); i++) {
            if(i == a1.length) {
                classNames1.add("Arrays.sort");
            } else {
                classNames1.add(a1[i].getClass().getName());
            }
            System.out.println(classNames1.get(i) + " = " + finalResult1.get(i));
        }
        System.out.println("transposedRuntime = [" + classNames1.get(0) + ";" + classNames1.get(1) + ";" + classNames1.get(2) + ";" +  classNames1.get(3) + ";" + classNames1.get(4) + "]");
        System.out.println("runtime = transpose(transposedRuntime)");
        System.out.println("bar(runtime)");
        System.out.println("title(\'Analysis of Sorting Runtime for Growing Problem Sizes\')");
        System.out.println("xlabel(\'Problem Size (number of ints)\')");
        System.out.println("ylabel(\'Running Time (ms)\')");
        System.out.println("legend('QS fixed pivot', 'QS fixed pivot with insertion sort', 'QS random pivot', 'QS random pivot with insertion sort', 'Arrays.sort')");
        System.out.println("set(gca,'xticklabel',{'" + n1[0] + "','" + n1[1] + "','" + n1[2]+ "','" + n1[3] + "'})");
        System.out.println();


        /**
         * Implementations of IntSorter tested including insertion sort.
         **/
        IntSorter[] a2 = new IntSorter[] {
            new QuicksortFixedPivot(),
            new QuicksortFixedPivotInsertion(),
            new QuicksortRandomPivot(),
            new QuicksortRandomPivotInsertion(),
            new InsertionSort(),
        };

        /**
         * Size of arrays tested.
         **/
        int[] n2 = {
            5000,
            10000,
            50000,
            100000,
        };

        /**
         * Loop where the test is preformed.
         **/
        ArrayList<ArrayList<String>> finalResult2 = new ArrayList<ArrayList<String>>();
        for(int j = 0; j < a2.length+1; j++) {
            Data[] tests = {
                new Data(n2[0], n2[0], Data.Order.RANDOM),
                new Data(n2[0], n2[0], Data.Order.RANDOM),
                new Data(n2[0], n2[0], Data.Order.RANDOM),

                new Data(n2[0], n2[0], Data.Order.RANDOM),
                new Data(n2[1], n2[1], Data.Order.RANDOM),
                new Data(n2[2], n2[2], Data.Order.RANDOM),
                new Data(n2[3], n2[3], Data.Order.RANDOM),
            };

            ArrayList<String> results = new ArrayList<String>();
            Stopwatch s = new Stopwatch();
            for (Data d : tests) {
                ArrayList<String> avrResults = new ArrayList<String>();
                for(int k = 0; k < 10; k++) {
                    if(j == a2.length) {
                        s.start();
                        Arrays.sort(d.get());
                        s.stop();
                        avrResults.add(String.valueOf(s.milliseconds()));
                        s.reset();
                    } else {
                        s.start();
                        a2[j].sort(d.get());
                        s.stop();
                        avrResults.add(String.valueOf(s.milliseconds()));
                        s.reset();
                    }
                }
                long avr = 0;
                for(int i = 0; i < avrResults.size(); i++) {
                    avr += Long.valueOf(avrResults.get(i));
                }
                avr /= avrResults.size();
                results.add(String.valueOf(avr));
            }
            ArrayList<String> validResults = new ArrayList<>(results.subList(3, results.size()));
            finalResult2.add(validResults);
        }


        /**
         * Printing matlab script for table 2.
         **/
        System.out.println();
        ArrayList<String> classNames2 = new ArrayList<String>();
        for(int i = 0; i < finalResult2.size(); i++) {
            if(i == a2.length) {
                classNames2.add("Arrays.sort");
            } else {
                classNames2.add(a2[i].getClass().getName());
            }
            System.out.println(classNames2.get(i) + " = " + finalResult2.get(i));
        }
        System.out.println("transposedRuntime = [" + classNames2.get(0) + ";" + classNames2.get(1) + ";" + classNames2.get(2) + ";" +  classNames2.get(3) + ";" + classNames2.get(4) + ";" + classNames2.get(5) + "]");
        System.out.println("runtime = transpose(transposedRuntime)");
        System.out.println("bar(runtime)");
        System.out.println("title(\'Analysis of Sorting Runtime for Growing Problem Sizes\')");
        System.out.println("xlabel(\'Problem Size (number of ints)\')");
        System.out.println("ylabel(\'Running Time (ms)\')");
        System.out.println("legend('QS fixed pivot', 'QS fixed pivot with insertion sort', 'QS random pivot', 'QS random pivot with insertion sort', 'Insertion sort', 'Arrays.sort')");
        System.out.println("set(gca,'xticklabel',{'" + n2[0] + "','" + n2[1] + "','" + n2[2]+ "','" + n2[3] + "'})");
        System.out.println();
    }
}
