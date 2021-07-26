package com.nkhatun.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*Write a function:
class Solution { public int solution(int[] A); }
that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.*/
public class MinAbsSum {
	// A = [1, 5, 2, -2] S = [-1, 1, -1, 1]
	private static int[] absA;
    private static int sum;
    private static Map<Integer, Integer> countMap = new HashMap<>();
    private static int[] subset;

    public static int solution(int[] A) {
        absA =  IntStream.of(A).map(a-> Math.abs(a)).toArray();
        sum = IntStream.of(A).sum();
	        countMap = getCountMap(absA);
        subset = new int[Math.max(sum, 1)];

        Arrays.fill(subset, -1);
        subset[0] = 0;

        for (int key : countMap.keySet()) {
            for (int i=0; i<sum/2+1; i++) {
                if (subset[i] >= 0) {
                    subset[i] = countMap.get(key);
                } else if (i >= key && subset[i - key] > 0) {
                    subset[i] = subset[i - key] - 1;
                }
            }
        }

        int res = sum;
        for (int i=0; i<sum/2+1; i++) {
            if (subset[i] >= 0) {
                res = Math.min(res, sum - i * 2);
            }
        }

        return res;
    }

    private static Map<Integer, Integer> getCountMap(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        IntStream.of(A).map(a-> countMap.put(a, countMap.getOrDefault(a, 0) + 1));
        return countMap;
    }
	
    public static void main(String args[]) {
    	int A[] = {1, 5, 2, -2};
    	System.out.println(solution(A));
    }
}
