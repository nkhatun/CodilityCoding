package com.nkhatun.future;
/*Write a function:
class Solution { public int solution(String S); }
that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.*/

public class StrSymmetryPoint {
	public static void main(String args[]) {
		System.out.println(solution(""));
		System.out.println(solution("racecar"));
	}

	public static int solution(String S) {
		if (S.isEmpty()) {
			return -1;
		}
		int length = S.length();
		if (length == 1) {
			return 0;
		}
		if (length % 2 == 0) {
			return -1;
		}
		return isSymmytric(S, length);
	}

	private static int isSymmytric(String S, int length) {
		int midIndex = length / 2;
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();

		for (int i = 0; i < length; i++) {
			if (i < midIndex) {
				left.append(S.charAt(i));
			}
			if (i > midIndex) {
				right.append(S.charAt(i));
			}
		}
		if (left.reverse().toString().equals(right.toString())) {
			return midIndex;
		}
		return -1;
	}
}
