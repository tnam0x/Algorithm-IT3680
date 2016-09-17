package sorts;

import java.util.ArrayList;
import java.util.Collections;

/** Độ phức tạp thuật toán O(n) */
public class BucketSort {

	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 13, 9, 31, 4 };
		a = sort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * Bucket sort
	 * 
	 * @param array array to be sorted
	 * @param bucketCount number of buckets
	 * @return array sorted in ascending order
	 */
	@SuppressWarnings("unchecked")
	public static int[] sort(int[] array, int bucketCount) {
		if (bucketCount <= 0)
			throw new IllegalArgumentException("Invalid bucket count");
		if (array.length <= 1)
			return array; //trivially sorted

		int high = array[0];
		int low = array[0];
		for (int i = 1; i < array.length; i++) { //find the range of input elements
			if (array[i] > high)
				high = array[i];
			if (array[i] < low)
				low = array[i];
		}
		double interval = ((double) (high - low + 1)) / bucketCount; //range of one bucket

		ArrayList<Integer> buckets[] = new ArrayList[bucketCount];
		for (int i = 0; i < bucketCount; i++) { //initialize buckets
			buckets[i] = new ArrayList<>();
		}

		for (int i = 0; i < array.length; i++) { //partition the input array
			buckets[(int) ((array[i] - low) / interval)].add(array[i]);
		}

		int pointer = 0;
		for (int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]); //mergeSort
			for (int j = 0; j < buckets[i].size(); j++) { //merge the buckets
				array[pointer] = buckets[i].get(j);
				pointer++;
			}
		}
		return array;
	}

}
