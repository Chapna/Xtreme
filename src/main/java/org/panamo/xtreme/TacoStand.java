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
import java.util.Collections;
import java.util.Scanner;

public class TacoStand {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			long s = in.nextInt();
			long m = in.nextInt();
			long r = in.nextInt();
			long b = in.nextInt();

			ArrayList<Long> ingredients = new ArrayList<Long>();
			ingredients.add(m);
			ingredients.add(r);
			ingredients.add(b);

			Collections.sort(ingredients);

			long answer = Math.min(Math.min(s, ingredients.get(0) + ingredients.get(1)), ingredients.get(2));
			long addy = ingredients.get(0)  + ingredients.get(1) - answer;
			addy /= 2;
			addy *= 2;
			if (ingredients.get(0) >= addy && ingredients.get(1) >= addy)
				answer = (answer + addy / 2 <= s) ? answer + addy/2 : s;
			System.out.println(answer);
		}
	}
}
