package prime_factors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crespis on 1/26/2016.
 */
public class GeneratorImpl implements Generator {
    @Override
    public List<Integer> generate(int n) {
        List<Integer> primes = new ArrayList<Integer>();

        for (int candidate = 2; n > 1; candidate++) {
            for (; n % candidate == 0; n /= candidate) {
                primes.add(candidate);
            }
        }
        return primes;
    }
}
