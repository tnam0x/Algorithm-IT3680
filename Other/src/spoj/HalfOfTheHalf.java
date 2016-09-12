package spoj;

import java.util.Scanner;

public class HalfOfTheHalf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfTestCase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numberOfTestCase; i++) {
			char[] line = sc.nextLine().toCharArray();
			System.out.print(line[0]);
			for (int j = 1; j < line.length / 2; j++) {
				if (j % 2 == 0) {
					System.out.print(line[j]);
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
