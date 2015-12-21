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
import java.util.Comparator;
import java.util.List;

public class CarSpark {
	List<input> data = new ArrayList<input>();

	class input {
		public int profit;
		public int deadline;
		public int index1;
		public int index2;

		public int sum() {
			return index1 + index2;
		}

		public input(int deadline, int profit) {
			super();
			this.profit = profit;
			this.deadline = deadline;
		}

	}

	@SuppressWarnings("unchecked")
	public void sortByProfit(List<input> data) {
		Collections.sort(data, new Comparator() {

			public int compare(Object o1, Object o2) {
				if (((input) (o1)).profit < ((input) (o2)).profit)
					return 1;
				else if (((input) (o1)).profit == ((input) (o2)).profit)
					return 0;
				else return -1;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void sortByDeadline(List<input> data) {
		Collections.sort(data, new Comparator() {

			public int compare(Object o1, Object o2) {
				if (((input) (o1)).deadline > ((input) (o2)).deadline)
					return 1;
				else if (((input) (o1)).deadline == ((input) (o2)).deadline)
					return 0;
				else return -1;
			}
		});
	}


	@SuppressWarnings("unchecked")
	public void sortBySum(List<input> data) {
		Collections.sort(data, new Comparator() {

			public int compare(Object o1, Object o2) {
				if (((input) (o1)).sum() > ((input) (o2)).sum())
					return 1;
				else if (((input) (o1)).sum() == ((input) (o2)).sum())
					return 0;
				else return -1;
			}
		});
	}


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		CarSpark tsk = new CarSpark();


		while (tsk.data.size() > 0) {
			//sort by profit
			tsk.sortByProfit(tsk.data);
			int idx0 = 1;
			//assign index
			for (input data : tsk.data) {
				data.index1 = idx0;
				idx0++;
			}

			//sort by deadline
			tsk.sortByDeadline(tsk.data);
			int idx2 = 1;
			for (input data : tsk.data) {
				data.index2 = idx2;
				idx2++;
			}

			//sort by sum and profit
			tsk.sortBySum(tsk.data);

			List<input> tmpdatas = new ArrayList<input>();
			int valsum = tsk.data.get(0).sum();
			for (input data : tsk.data) {
				if (data.sum() == valsum)
					tmpdatas.add(data);
			}
			tsk.sortByProfit(tmpdatas);

			//get the first one as result
			input thedata = tmpdatas.get(0);

			System.out.println(thedata.profit);

			tsk.data.remove(thedata);
			tmpdatas = new ArrayList<input>();
			for (input data : tsk.data) {
				data.deadline--;
				if (data.deadline > 0)
					tmpdatas.add(data);
			}
			tsk.data = tmpdatas;
		}
	}
}
