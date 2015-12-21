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

import java.util.Scanner;

public class IEEEStateOfMind {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();

		State[] states = new State[n];

		for (int i = 0; i < n; i++) {
			String st = in.nextLine();
			int k = Integer.valueOf(st.split(" ")[1]);
			states[i] = new State(Integer.valueOf(st.split(" ")[0]), k);

			for (int j = 0; j < k; j++) {
				String sh = st.split(" ")[2 + j];

				Transition t = new Transition(m, Integer.valueOf(sh.split("/")[1]));

				sh = sh.split("/")[0];

				String[] inputs = sh.split(",");

				for (String input : inputs) {
					t.addToInp(Integer.valueOf(input.split("=")[1]), input.split("=")[0].charAt(0) - 'A');
				}

				states[i].addToTrans(t, j);
			}
		}

		int num = in.nextInt();
		int current = in.nextInt();

		int[][] inp = new int[num][m];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < m; j++) {
				inp[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < num / 16 + 1; i++) {
			System.out.println("Tick #" + (i * 16 + 1));
			for (int variable = 0; variable < m; variable++) {
				System.out.print((char)('A' + variable) + "     ");
				for (int j = i * 16; j < i * 16 + 16 && j < num; j++) {
					if (inp[j][variable] == 0)
						System.out.print("___");
					else
						System.out.print("***");
				}
				System.out.println();
			}
			String currentStates = "";
			System.out.print("OUT   ");
			for (int j = i * 16; j < i * 16 + 16 && j < num; j++) {
				current = states[current].nextState(inp[j], current);
				currentStates += "  " + current;
				if (states[current].value == 0)
					System.out.print("___");
				else
					System.out.print("***");
			}
			System.out.println();
			System.out.print("STATE ");
			System.out.println(currentStates);
			System.out.println();
		}
	}
}

class State {
	int value;

	Transition[] trans;

	State(int value, int num) {
		this.value = value;
		trans = new Transition[num];
	}

	void addToTrans(Transition t, int index) {
		trans[index] = t;
	}

	int nextState(int[] inp, int current) {
		for (Transition tran : trans) {
			boolean flag = false;
			for (int j = 0; j < tran.inputs.length; j++) {
				if (tran.inputs[j] == 1 && inp[j] == 0) {
					flag = true;
					break;
				}
				if (tran.inputs[j] == 0 && inp[j] == 1) {
					flag = true;
					break;
				}
			}
			if (!flag)
				return tran.to;
		}
		return current;
	}
}

class Transition {
	int to;

	int[] inputs;

	Transition(int m, int to) {
		this.to = to;
		inputs = new int[m];
		for (int i = 0; i < m; i++) {
			inputs[i] = -1;
		}
	}

	void addToInp(int value, int index) {
		inputs[index] = value;
	}
}
