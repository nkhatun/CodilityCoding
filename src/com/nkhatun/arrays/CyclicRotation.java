package com.nkhatun.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CyclicRotation {
	//100%
	public static int[] solution(int[] A, int K) {
		int ALength = A.length;
		int rotation = K;
		if (K == 0 || K == ALength || ALength == 0) {
			return A;
		}
		if (K > ALength) {
			rotation = K % ALength;
		}
		int[] firstElements = Arrays.copyOfRange(A, 0, ALength - rotation);
		int[] lastElements = Arrays.copyOfRange(A, ALength - rotation, ALength);

		int[] result = new int[ALength];
		System.arraycopy(lastElements, 0, result, 0, lastElements.length);
		System.arraycopy(firstElements, 0, result, lastElements.length,
				firstElements.length);

		return result;
	}
	// 100%
	public static int[] solution1(int[] A, int K) {
		int len = A.length;
		if (K == 0 || K == len || len == 0) {
			return A;
		}
		int[] result = new int[len];
		IntStream.range(0, A.length).forEach(i -> result[(i + K) % A.length] = A[i]);
		return result;
}
	public static void main(String[] args) {
		int[] firstArray = {1, 5};
		System.out.println(Arrays.toString((solution(firstArray, 9))));
	}
}
