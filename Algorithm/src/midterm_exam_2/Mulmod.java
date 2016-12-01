package midterm_exam_2;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class Mulmod {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int modulo = 0;
		for (int i = 0; i < b; i++) {
			modulo = (modulo + a) % c;
		}
		System.out.println(modulo);
		scanner.close();
	}
}
