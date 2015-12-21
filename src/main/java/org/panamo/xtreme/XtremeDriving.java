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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XtremeDriving {

	public static int MOD = 1000 * 1000 * 1000 + 7;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		BigInteger K = in.nextBigInteger();
		int N = in.nextInt();

		int highway[] = new int[4];

		/* we are on leftmost unit at the fist */
		highway[0] = 1;
		highway[1] = 0;
		highway[2] = 0;
		highway[3] = 0;

		HashMap<BigInteger, ArrayList<Integer>> cows = new HashMap<BigInteger, ArrayList<Integer>>();

		for (int i = 0; i < N; i++) {
			int x = in.nextInt() - 1;
			BigInteger y = in.nextBigInteger();

			ArrayList<Integer> array = cows.get(y);
			if (array == null) {
				array = new ArrayList<Integer>();
				array.add(x);
				cows.put(y, array);
			} else {
				array.add(x);
			}
		}

		for (BigInteger i = new BigInteger("2"); K.compareTo(i) >= 0; i = i.add(new BigInteger("1"))) {
			int new_highway[] = new int[4];

			new_highway[0] = highway[0] + highway[1];
			new_highway[1] = (highway[0] + highway[1]) % MOD + highway[2];
			new_highway[2] = (highway[1] + highway[2]) % MOD + highway[3];
			new_highway[3] = highway[2] + highway[3];

			ArrayList<Integer> array = cows.get(i);
			if (array != null) {
				for (int x : array)
					new_highway[x] = 0;
			}

			highway[0] = new_highway[0] % MOD;
			highway[1] = new_highway[1] % MOD;
			highway[2] = new_highway[2] % MOD;
			highway[3] = new_highway[3] % MOD;
		}
		System.out.println(highway[0]);
	}
}
