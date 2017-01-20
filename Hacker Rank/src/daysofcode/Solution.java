package daysofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for (int i = 0; i < t; i++) {
			int m = input.nextInt();
			int n = input.nextInt();
			int[] array = new int[n];
			for (int j = 0; j < n; j++) {
				array[j] = input.nextInt();
			}
			int[] index = twoSum(array, m);
			for (int j : index) {
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
		input.close();
	}

	static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}