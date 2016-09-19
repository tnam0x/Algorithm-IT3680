package day_4;

import java.util.Scanner;

public class RockPaperScissorsTournament {

	public static void main(String[] args) {
		int n, k, totalGames;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			n = scanner.nextInt();
			if (n == 0) {
				break;
			}
			k = scanner.nextInt();
			int[] gamePlayed = new int[n];
			int[] wins = new int[n];
			totalGames = k * n * (n - 1) / 2;
			String m1, m2;
			int p1, p2;
			for (int i = 0; i < totalGames; i++) {
				p1 = scanner.nextInt() - 1;
				m1 = scanner.next();
				p2 = scanner.nextInt() - 1;
				m2 = scanner.next();
				if (!m1.equals(m2)) {
					gamePlayed[p1]++;
					gamePlayed[p2]++;
					if (isWinner(m1, m2)) {
						wins[p1]++;
					} else {
						wins[p2]++;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				if (gamePlayed[i] == 0) {
					System.out.println("-");
				} else {
					System.out.format("%.3f\n", (float) wins[i] / gamePlayed[i]);
				}
			}
			System.out.println();
		}
		scanner.close();
	}

	static boolean isWinner(String m1, String m2) {
		if (m1.equals("rock")) {
			return m2.equals("scissors");
		} else if (m1.equals("paper")) {
			return m2.equals("rock");
		} else {
			return m2.equals("paper");
		}
	}
}
