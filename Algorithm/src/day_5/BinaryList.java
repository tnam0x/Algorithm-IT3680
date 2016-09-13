package day_5;

public class BinaryList {
	private static int[] a;
	private static int n;

	private static void TRY(int i) {
		for (int v = 0; v <= 1; v++) {
			a[i] = v;
			if (i == n - 1) {
				for (int j = 0; j < n; j++) {
					System.out.print(a[j]);
				}
				System.out.println();
			} else {
				TRY(i + 1);
			}
		}
	}

	private static void list(int n) {
		BinaryList.n = n;
		a = new int[n];
		TRY(0);
	}

	public static void main(String[] args) {
		list(3);
	}

}
