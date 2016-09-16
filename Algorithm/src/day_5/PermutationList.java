package day_5;

import java.util.Scanner;

public class PermutationList {

	static int[] permutation;
	static boolean[] visited;
	static int n, k, index;

	static void TRY(int number) {
		for (int v = 1; v <= n; v++) {
			if (!visited[v]) {
				permutation[number] = v;
				visited[v] = true;
				if (number == n) {
					index++;
					if (index == k) {
						for (int i = 1; i <= n; i++) {
							System.out.print(permutation[i] + " ");
						}
						System.exit(0);
					}
				} else {
					TRY(number + 1);
				}
				visited[v] = false;
			}
		}
	}

	static void list() {
		permutation = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			visited[i] = false;
		}
		TRY(1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		scanner.close();
		list();
		System.out.println(-1);
	}

}
