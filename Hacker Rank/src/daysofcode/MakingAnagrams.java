package daysofcode;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class MakingAnagrams {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		// đếm số lần các kí tự được dùng trong chuỗi s1
		int[] charArray1 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++charArray1[s1.charAt(i) - 'a'];
		}
		// đếm số lần các kí tự được dùng trong chuỗi s2
		int[] charArray2 = new int[26];
		for (int i = 0; i < s2.length(); i++) {
			++charArray2[s2.charAt(i) - 'a'];
		}
		// tính số kí tự cần xóa để chuỗi s1 và s2 là đảo chữ của nhau
		int count = 0;
		for (int i = 0; i < 26; i++) {
			count += Math.abs(charArray1[i] - charArray2[i]);
		}
		System.out.println(count);
		scanner.close();
	}
}
