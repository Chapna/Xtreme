/*
 * In The Name Of God
 * ======================================
 * [] Project Name : xtreme
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

import java.util.Scanner;

public class PredictionGames {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for (int i = 0; i < tests; i++) {
			int persons = in.nextInt();
			int competitions = in.nextInt();

			String names[] = new String[persons];
			int predicted_games[][][] = new int[persons][competitions][2];
			int score[] = new int[persons];

			int games[][] = new int[competitions][2];

			/* read games and competitions data */
			for (int j = 0; j < persons; j++) {
				names[j] = in.next();
				for (int k = 0; k < competitions; k++) {
					predicted_games[j][k][0] = in.nextInt();
					predicted_games[j][k][1] = in.nextInt();
				}
			}
			for (int j = 0; j < competitions; j++) {
				try {
					games[j][0] = in.nextInt();
					games[j][1] = in.nextInt();
				} catch (NumberFormatException exception) {
					games[j][0] = -1;
					games[j][0] = -1;
				}
			}

			for (int j = 0; j < persons; j++) {
				for (int k = 0; k < competitions; k++) {
					if (games[k][0] > games[k][1] &&
						predicted_games[j][k][0] > predicted_games[j][k][1]) {
						score[j] += 10;
					}

					if (games[k][0] < games[k][1] &&
						predicted_games[j][k][0] < predicted_games[j][k][1]) {
						score[j] += 10;
					}

					if (games[k][0] != -1 && games[k][1] != -1) {
						score[j] += Math.max(0, 5 -
							Math.abs(predicted_games[j][k][0] - games[k][0]));

						score[j] += Math.max(0, 5 -
							Math.abs(predicted_games[j][k][1] - games[k][1]));

						score[j] += Math.max(0, 5 -
							Math.abs(predicted_games[j][k][0] - predicted_games[j][k][1]
								- games[k][0] + games[k][1])
							);
					}
				}
			}
		}
	}
}
