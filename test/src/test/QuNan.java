package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Node {
	public int val;

	public Node(int val) {
		this.val = val;
	}

	public Node left;
	public Node right;
}

public class QuNan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pre = new int[n];
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}
		Node head = preInTree(pre, in);
		levelIterator(head);
	}

	public static Node preInTree(int[] pre, int[] in) {
		if (pre == null || in == null)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	public static Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		if (pi > pj)
			return null;
		Node head = new Node(p[pi]);
		int index = map.get(p[pi]);
		head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
		return head;
	}

	public static void levelIterator(Node root) {
		if (root == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		Node current = null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current.val + " ");
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}

	}
}
