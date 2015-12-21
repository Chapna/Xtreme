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

import java.nio.charset.Charset;
import java.util.Scanner;

public class ShorteningInTheRealWorld {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String baseUEL = in.next();
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			String targetURL = in.next();
			int len = Math.min(baseUEL.length(), targetURL.length());
			int[] newURL = new int[len];
			for (int i = 0; i < len; i++) {
				newURL[i] = targetURL.getBytes(Charset.forName("UTF-8"))[i] ^
					baseUEL.getBytes(Charset.forName("UTF-8"))[i];
			}
			long value = 0;
			for (int i = 1; i <= 8 ; i++) {
				value = ((long) newURL[newURL.length - i] & 0xFFL) + (value << 8);
			}
			System.out.println(value);
		}
	}
}
