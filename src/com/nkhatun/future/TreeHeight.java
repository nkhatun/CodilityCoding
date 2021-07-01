package com.nkhatun.future;
/*Write a function:
class Solution { public int solution(Tree T); }
that, given a non-empty binary tree T consisting of N nodes, returns its height. For example, given tree T shown in the figure above, the function should return 2, as explained above. Note that the values contained in the nodes are not relevant in this task.*/
public class TreeHeight {
	public static int solution(Tree T) {
		// check if root is empty
		if (T == null) {
			return 0;
		}
		int height_left = 0;
		int height_right = 0;
		if (T.l != null) {
			height_left = 1 + solution(T.l);
		}
		if (T.r != null) {
			height_right = 1 + solution(T.r);
		}
		return Math.max(height_left, height_right);
	}
	public static class Tree {
		int data;
		Tree l;
		Tree r;
		Tree(int data) {
			this.data = data;
			this.l = this.r = null;
		}
	}
	public static void main(String args[]) {
		Tree root = new Tree(5);
		root.l = new Tree(2);
		root.r = new Tree(6);
		root.l.l = new Tree(1);
		root.l.r = new Tree(3);
		System.out.println(solution(root));
	}
}
