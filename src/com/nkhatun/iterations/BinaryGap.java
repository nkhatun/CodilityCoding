package com.nkhatun.iterations;
/*A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.*/
public class BinaryGap {
	public static void main(String args[]) {
		System.out.println(solution(32));
	}

	public static int solution(int N) {
		String binaryString = Integer.toBinaryString(N);
		binaryString = binaryString.replaceAll("(?!^)0+$", "");
		int count = 0;
		int max = 0;
		for (char c : binaryString.toCharArray()) {
			if (c != '1') {
				count = count + 1;
				max = Math.max(max, count);
			} else {
				count = 0;
			}
		}
		return max;
	}
}
