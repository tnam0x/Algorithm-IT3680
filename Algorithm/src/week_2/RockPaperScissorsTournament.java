package week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RockPaperScissorsTournament {

	public static void main(String[] args) throws IOException {
		int n, k, totalGames;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] line = reader.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			if (n == 0) {
				break;
			}
			k = Integer.parseInt(line[1]);
			int[] gamePlayed = new int[n];
			int[] wins = new int[n];
			totalGames = k * n * (n - 1) / 2;
			String m1, m2;
			int p1, p2;
			for (int i = 0; i < totalGames; i++) {
				String[] gameInfo = reader.readLine().split(" ");
				p1 = Integer.parseInt(gameInfo[0]) - 1;
				m1 = gameInfo[1];
				p2 = Integer.parseInt(gameInfo[2]) - 1;
				m2 = gameInfo[3];
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
