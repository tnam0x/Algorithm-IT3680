package day_6;

public class HoleyNQueens {
	static boolean[] r, d1, d2;
	static int[] a;
	static int n, m;

	public static void main(String[] args) {
		n = 4;
		list();
	}

	static void list() {
		a = new int[n+1];
		r = new boolean[n + 1];
		d1 = new boolean[2 * n ];
		d2 = new boolean[2 * n - 1];
		for (int i = 1; i <= n; i++) {
			r[i] = true;
		}
		for (int i = 1; i <= 2 * n - 1; i++) {
			d1[i] = true;
		}
		for (int i = 2; i <= 2 * n - 2; i++) {
			d2[i] = true;
		}
	}

	static void TRY(int i) {
		for (int v = 1; v <= n; v++) {
			if (r[v] && d1[i - v] && d2[i+v]) {
				a[i] = v;
				r[v] = false;
				d1[i - v] = false;
				d2[i + v] = false;
				if (i == n) {
					
				}else {
					TRY(i + 1);
				}
				r[v] = true;
				d1[i - v] = true;
				d2[i + v] = true;
			}
		}
	}
}
