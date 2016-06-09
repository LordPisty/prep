package codility.challenges.theta2011;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    static final int LIMIT = 1000000000;

    class City {
        int index;
        int base;
        int refill;

        City(int index) {
            this.index = index;
        }

        int getFuel() {
            return base + refill;
        }
    }

    private long getCost(int[] prices, City city) {
        return (long) prices[city.index] * city.refill;
    }

    private int getEarn(int[] distances, City city) {
        return city.getFuel() - distances[city.index];
    }

    /**
     * - only keep track of previous if cost < next
     * - if previous cost >= next, no advantage in using prev
     * - at most 2 in consideration in list
     * - maintain list of cities with outgoing capacity, ordered by price ascending
     *
     * @param D
     * @param P
     * @param T
     * @return
     */
    public int solution(int[] D, int[] P, int T) {
        // write your code in Java SE 8
        for (int distance : D) {
            if (distance > T) {
                return -1;
            }
        }

        LinkedList<City> cities = new LinkedList<City>();
        int[] prices = Arrays.copyOf(P, P.length + 1);
        cities.addLast(new City(0));
        long cost = 0;

        for (int i = 0; i < D.length; i++) {
            int dist = D[i];

            while (dist > 0) {
                City head = cities.getFirst();
                int delta = Math.min(dist, T - head.getFuel());
                dist -= delta;
                head.refill += delta;

                if (head.getFuel() == T) {
                    cost += getCost(prices, head);
                    if (cost > LIMIT) {
                        return -2;
                    }

                    cities.removeFirst();
                    if (!cities.isEmpty()) {
                        cities.getFirst().base += getEarn(D, head);
                    }
                }
            }

            City added = new City(i + 1);
            while (!cities.isEmpty() && prices[cities.getLast().index] >= prices[i + 1]) {
                City tail = cities.removeLast();
                cost += getCost(prices, tail);
                if (cost > LIMIT) {
                    return -2;
                }

                added.base += getEarn(D, tail);
            }
            cities.addLast(added);
        }

        return (int)cost;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{10,9,1,1,10,8},new int[]{2,1,5,1,3}, 15));
    }
}