package daysofcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Use PriorityQueue. Priority queue represented as a balanced binary heap.
 */
public class FindTheRunningMedian {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();

		// max heap: root is biggest
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			};
		});
		// natural ordering: root is smallest
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

		for (int i : a) {
			if (minHeap.isEmpty())
				minHeap.add(i);
			else {
				if (minHeap.size() > maxHeap.size()) {
					if (minHeap.peek() > i) {
						maxHeap.add(minHeap.poll());
						minHeap.add(i);
					} else {
						maxHeap.add(i);
					}
				} else {
					Integer maxHeapRoot = maxHeap.peek();
					if (maxHeapRoot != null && maxHeapRoot >= i) {
						minHeap.add(i);
					} else {
						minHeap.add(maxHeap.poll());
						maxHeap.add(i);
					}
				}
			}

			double median;
			int len = minHeap.size() + maxHeap.size();
			if (len % 2 == 0) {
				median = (minHeap.peek() + maxHeap.peek()) / 2.0;
			} else {
				median = minHeap.peek() / 1.0;
			}
			System.out.println(median);
		}
	}
}
