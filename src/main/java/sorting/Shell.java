package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public class Shell extends Sort implements Sortable{

    /**
     * O(<N^2)
     * bad:
     *
     * good:
     * - adaptive (smarter exchanges)
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = (3 * h) + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j>= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }
}
