package daysofcode;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class Anagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextInt(); // the number of test cases
		while (scanner.hasNext()) {
			String s = scanner.next();
			int length = s.length();
			// không thể chia thành 2 chuỗi có độ dài bằng nhau
			if (length % 2 != 0) {
				System.out.println(-1);
				continue;
			}
			int halfLength = length / 2;
			int[] occurrence = new int[26]; // lưu số kí tự được dùng
			// Count up how many letters are used in the first half of the string
			for (int j = 0; j < halfLength; j++) {
				++occurrence[s.charAt(j) - 'a'];
			}
			// Count down all the letters that are used in the second half
			for (int j = halfLength; j < length; j++) {
				--occurrence[s.charAt(j) - 'a'];
			}
			// Sum all occurrences of all characters
			int sum = 0;
			for (int value : occurrence) {
				sum += value > 0 ? value : -value;
			}
			System.out.println(sum / 2);
		}
		scanner.close();
	}

}
