/*
 * In The Name Of God
 * ======================================
 * [] Project Name : Xtreme 
 * 
 * [] Package Name : org.panamo.xtreme
 *
 * [] Creation Date : 24-10-2015
 *
 * [] Created By : Parham Alvani (parham.alvani@gmail.com)
 * =======================================
*/
/**
 * @author Parham Alvani
 */
package org.panamo.xtreme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BonVoyage {
	public static int maxMatching(boolean[][] graph) {
		int n1 = graph.length;
		int n2 = n1 == 0 ? 0 : graph[0].length;
		int[] matching = new int[n2];
		Arrays.fill(matching, -1);
		int matches = 0;
		for (int u = 0; u < n1; u++)
			if (findPath(graph, u, matching, new boolean[n1]))
				++matches;
		return matches;
	}

	static boolean findPath(boolean[][] graph, int u1, int[] matching, boolean[] vis) {
		vis[u1] = true;
		for (int v = 0; v < matching.length; ++v) {
			int u2 = matching[v];
			if (graph[u1][v] && (u2 == -1 || !vis[u2] && findPath(graph, u2, matching, vis))) {
				matching[v] = u1;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int step = 0; step < T; step++) {
			int r = in.nextInt() + 1;
			int p = in.nextInt() + 1;
			boolean[][] g = new boolean[p][r];
			HashMap<Pair<Integer, Integer>, ArrayList<Integer>> conflicts =
				new HashMap<Pair<Integer, Integer>, ArrayList<Integer>>();
			for (int i = 1; i < p; i++) {
				int r1 = in.nextInt();
				int r2 = in.nextInt();

				Pair<Integer, Integer> pair;
				if (r1 < r2)
					pair = new Pair<Integer, Integer>(r1, r2);
				else
					pair = new Pair<Integer, Integer>(r2, r1);
				ArrayList<Integer> array = conflicts.get(pair);
				if (array == null) {
					array = new ArrayList<Integer>();
					array.add(i);
					conflicts.put(pair, array);
				} else {
					array.add(i);
				}

				g[i][r1] = true;
				g[i][r2] = true;
			}
			System.err.println(conflicts);
			for (ArrayList<Integer> value: conflicts.values()) {
				if(value.size() > 2) {
					for (int person : value){
						for (int i = 1; i < r; i++) {
							g[person][i] = false;
						}
					}
				}
			}
			int res = maxMatching(g);
			System.out.println(res);
		}
	}
}

class Pair<A, B> {
	private A first;
	private B second;

	public Pair(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}

	public int hashCode() {
		int hashFirst = first != null ? first.hashCode() : 0;
		int hashSecond = second != null ? second.hashCode() : 0;

		return (hashFirst + hashSecond) * hashSecond + hashFirst;
	}

	public boolean equals(Object other) {
		if (other instanceof Pair) {
			Pair otherPair = (Pair) other;
			return
				((  this.first == otherPair.first ||
					( this.first != null && otherPair.first != null &&
						this.first.equals(otherPair.first))) &&
					(	this.second == otherPair.second ||
						( this.second != null && otherPair.second != null &&
							this.second.equals(otherPair.second))) );
		}

		return false;
	}

	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}

	public A getFirst() {
		return first;
	}

	public void setFirst(A first) {
		this.first = first;
	}

	public B getSecond() {
		return second;
	}

	public void setSecond(B second) {
		this.second = second;
	}
}