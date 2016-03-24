package codility.stacksQueues.stoneWall;

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    if (count == 0) {
                        return 0;
                    } else {
                        count--;
                    }
                    break;
            }
        }
        return count == 0 ? 1 : 0;
    }
}
