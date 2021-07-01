package com.nkhatun.future;

import java.util.Arrays;
/*An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
Write a function:
class Solution { public int solution(int[] A); }
that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
For example, in the following array:
 A[0] = -1 A[1] = 6 A[2] = 3
 A[3] =  4 A[4] = 7 A[5] = 4
there are four inversions:   (1,2)  (1,3)  (1,5)  (4,5) so the function should return 4.*/

public class ArrayInversionCount {
	public static int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int[] aux = Arrays.copyOf(A, A.length);
		return mergesort(A, aux, 0, A.length - 1);
	}
	public static int mergesort(int[] arr, int[] aux, int low, int high) {
		if (high == low) {
			return 0;
		}
		// find midpoint
		int mid = (low + ((high - low) >> 1));
		int inversionCount = 0;
		// recursively split runs into two halves until run size == 1,
		// then merges them and return up the call chain
		// split/merge left half
		inversionCount += mergesort(arr, aux, low, mid);
		// split/merge right half
		inversionCount += mergesort(arr, aux, mid + 1, high);
		// merge the two half runs
		inversionCount += merge(arr, aux, low, mid, high);
		if (inversionCount > Math.pow(10, 9)) {
			return -1;
		}
		return inversionCount;
	}
	// Merge two sorted subarrays `arr[low … mid]` and `arr[mid+1 … high]`
	public static int merge(int[] arr, int[] aux, int low, int mid, int high) {
		int k = low, i = low, j = mid + 1;
		int inversionCount = 0;
		// while there are elements in the left and right runs
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				aux[k++] = arr[i++];
			} else {
				aux[k++] = arr[j++];
				inversionCount += (mid - i + 1); // NOTE
			}
		}
		// copy remaining elements
		while (i <= mid) {
			aux[k++] = arr[i++];
		}

		/*
		 * no need to copy the second half (since the remaining items are
		 * already in their correct position in the temporary array)
		 */

		// copy back to the original array to reflect sorted order
		for (i = low; i <= high; i++) {
			arr[i] = aux[i];
		}
		return inversionCount;
	}

	public static void main(String[] args) {
		int[] a = {-1, 6, 3, 4, 7, 4};
		System.out.println(solution(a));
	}
}
