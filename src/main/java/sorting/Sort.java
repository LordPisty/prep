package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public abstract class Sort {

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
