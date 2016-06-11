[Codility Task](https://codility.com/programmers/challenges/mu2011/)

[Result](https://codility.com/demo/results/trainingJBMFJA-CY2/)

[Blogged solution](http://blog.codility.com/2011/12/mu-2011-certificate-solution.html)

A positive integer N is given. Consider the sequence of numbers [0, 1, ..., N]. What is the total number of zeros in the decimal representations of these numbers?

N can be very large. Hence, it is given in the form of a non-empty string S of length L, containing a decimal representation of N. S contains no leading zeros.

Write a function:

int solution(char *S);

that, given a string S, which is a decimal representation of some positive integer N, returns the total number of zeros in the decimal representations of numbers [0, 1, ..., N]. If the result exceeds 1,410,000,016, the function should return the remainder from the division of the result by 1,410,000,017.

For example, for S="100" the function should return 12 and for S="219" it should return 42.

Assume that:

* L is an integer within the range [1..10,000];
* string S consists only of digits (0−9);
* string S contains no leading zeros.

Complexity:

* expected worst-case time complexity is O(L);
* expected worst-case space complexity is O(L) (not counting the storage required for input arguments).