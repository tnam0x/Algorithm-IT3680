package kattis;

/**
 * Solution for kattis problem
 * 
 * @author: echoenzo
 */
import java.io.*;
import java.util.*;

public class OtherTrik {

	Kattio io;
	Kattio debug;
	int i = 0, j = 0;
	int ball = 1;

	void solve() {
		/************** START **************/

		String s = io.nextToken();
		for (i = 0; i < s.length(); i++) {
			moveBall(s.charAt(i));
		}
		io.println(ball);

		/*************** END ***************/
	}

	void moveBall(char c) {
		switch (c) {
			case 'A':
				if (ball == 2)
					ball = 1;
				else if (ball == 1)
					ball = 2;
				break;
			case 'B':
				if (ball == 2)
					ball = 3;
				else if (ball == 3)
					ball = 2;
				break;
			case 'C':
				if (ball == 1)
					ball = 3;
				else if (ball == 3)
					ball = 1;
				break;
			default:
		}
	}

	public static void main(String[] args) {
		new OtherTrik().runIO();
	}

	void runIO() {
		io = new Kattio(System.in, System.out);
		debug = new Kattio(System.in, System.err);
		solve();
		io.close();
		debug.close();
	}

	/**
	 * Simple yet moderately fast I/O routines.
	 * 
	 * @author: Kattis
	 */
	class Kattio extends PrintWriter {

		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		// returns a character grid of the next lines of input, until EOF or empty line.
		public char[][] getCharGrid() {
			ArrayList<char[]> lines = new ArrayList<char[]>();
			String ans = nextLine();
			if (ans == null)
				return null;
			while (ans != null && ans.length() > 0) {
				lines.add(ans.toCharArray());
				ans = nextLine();
			}
			char[][] grid = new char[lines.size()][];
			for (int row = 0; row < grid.length; row++) {
				grid[row] = lines.get(row);
			}
			return grid;
		}

		public void printGrid(char[][] g) {
			for (int a = 0; a < g.length; a++) {
				println(new String(g[a]));
			}
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}

		public String nextLine() {
			st = null;
			String s = null;
			try {
				s = r.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}

	}

}