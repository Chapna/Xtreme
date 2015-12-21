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
import java.util.HashMap;
import java.util.Scanner;

public class MrPipposPizza {

	public static HashMap<BigInteger, Long> C(long maxN) {
		HashMap<BigInteger, Long> res = new HashMap<BigInteger, Long>();
		BigInteger c = BigInteger.ONE;
		for (long n = 2; n < maxN; n++) {
			res.put(c, n);
			c = c.multiply(BigInteger.valueOf(4 * n - 2)).divide(BigInteger.valueOf(n + 1));
		}
		return res;
	}

	public static void main(String args[]) {
		HashMap<BigInteger, Long> table = C(600);
		Scanner in = new Scanner(System.in);
		BigInteger answer;
		while (in.hasNext()){
			answer = in.nextBigInteger();
			System.out.println(table.get(answer) + 1);
		}
	}
}
