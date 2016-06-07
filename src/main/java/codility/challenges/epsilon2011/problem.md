[Codility Task](https://codility.com/programmers/challenges/epsilon2011/)


[C sol](https://github.com/phiphy/codility/blob/master/minfuds-Epsilon_2011.c)
[JS sol 78%](https://codility.com/demo/results/trainingJE6X26-DKQ/)
[Result](https://codility.com/demo/results/training8FW4ZQ-NJJ/)

### Problem

Two non-empty zero-indexed arrays A and B, each consisting of N integers, are given. Four functions are defined based on these arrays:

F(X,K)	=	A[K]*X + B[K]
U(X)	=	max{ F(X,K) : 0 ≤ K < N }
D(X)	=	min{ F(X,K) : 0 ≤ K < N }
S(X)	=	U(X) − D(X)
Write a function:

class Solution { public double solution(int[] A, int[] B); }

that, given two arrays A and B consisting of N integers each, returns the minimum value of S(X) where X can be any real number.

For example, given the following arrays A and B consisting of three elements each:

A[0] = -1    B[0] = 3
A[1] =  1    B[1] = 0
A[2] =  0    B[2] = 2
the function should return 0.5 because:

U(X)		=		−1*X + 3		if		X ≤ 1
U(X)		=		0*X + 2		if		1 ≤ X ≤ 2
U(X)		=		1*X + 0		if		2 ≤ X
and:

D(X)		=		1*X + 0		if		X ≤ 1.5
D(X)		=		−1*X + 3		if		1.5 ≤ X
so for X = 1.5, function S(X) is equal to 0.5 and this is the minimum value of this function.

Assume that:

N is an integer within the range [1..100,000];
each element of arrays A, B is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.