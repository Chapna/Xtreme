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

import java.util.HashMap;
import java.util.Scanner;

public class SnakeBunnie {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String st = in.nextLine();

		int n = Integer.valueOf(st);

		char[][] table = new char[n][n];

		for (int i = n - 1; i >= 0; n--) {
			st = in.nextLine();
			String[] temp = st.split(" ");

			for (int k = n - 1; k >= 0; k--) {
				table[i][k] = temp[k].charAt(0);
			}
			HashMap<Character, Position> relations = new HashMap<Character, Position>();
			HashMap<Position, Position> destinations = new HashMap<Position, Position>();
			for (int j = 0; j < n; j++) {
				if (table[i][j] >= 'a' && table[i][j] <= 'z') {
					if (!relations.containsKey(table[i][j])) {
						relations.put(table[i][j], new Position(i, j));
					} else {
						destinations.put(relations.get(table[i][j]), new Position(i, j));
					}
				} else if (table[i][j] >= '0' && table[i][j] <= '9') {
					if (!relations.containsKey(table[i][j])) {
						relations.put(table[i][j], new Position(i, j));
					} else {
						destinations.put(new Position(i, j), relations.get(table[i][j]));
					}
				} else {
					destinations.put(new Position(i, j), new Position(i, j));
				}
			}

			int turn = 1;
			int playersNumber = Integer.valueOf(in.nextLine());
			Position[] playersPosition = new Position[playersNumber];

			for (int m = 0; m < playersNumber; m++) {
				playersPosition[m] = new Position(0, 0);
			}

			while (in.hasNext()) {
				int dice1 = in.nextInt();
				int dice2 = in.nextInt();
				int diceSum = dice1 + dice2;

				if (turn % playersNumber == 1) {
					int newPlace = playersPosition[0].x + 5 * (playersPosition[0].y) + diceSum;
					Position newPosition = destinations.get(new Position(newPlace % 5, newPlace / 5));


				}
				if (turn % playersNumber == 2) {

				}
				if (turn % playersNumber == 3) {

				}
				if (turn % playersNumber == 4) {

				}
			}
		}

	}
}

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public boolean equals(Position pos) {
		if (this.x == pos.x && this.y == pos.y) {
			return true;
		} else {
			return false;
		}
	}

}
