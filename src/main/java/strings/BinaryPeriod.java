package strings;

/**
 * Find the period of the binary representation of an int
 * 1 <= P <= n/2 or -1
 */
public class BinaryPeriod {
    static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p <= l/2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String... args) {
        for (int i : new int[]{36,72,990,995,1000}) {
            System.out.println(i);
            System.out.println(Integer.toBinaryString(i));
            System.out.println(solution(i));
            System.out.println("---");
        }
    }
}
