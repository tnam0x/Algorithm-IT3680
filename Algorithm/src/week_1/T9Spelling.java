package week_1;

import java.util.Scanner;
/**
* Chia cac chu cai thanh cac nhom nho
* Nhom gom cac chu cai tu a - o: chi nhan tu 1 - 3 lan
* Nhom gom cac chu cai p - s, w - z: nhan 1 - 4 lan
* Nhom gom cac chu cai tu t -v: nhan tu 1 - 3 lan
* Con lai la ki tu 0
* Kiem tra ki tu dau vao roi xem no thuoc nhom nao
* Luu ki tu can nhan va so lan nhan tuong ung vao mang gom 2 phan tu
* Do phuc tap thuat toan: 
*/
public class T9Spelling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfTestCase = Integer.parseInt(scanner.nextLine());
		if (numOfTestCase >= 1 && numOfTestCase <= 100) {
			for (int i = 0; i < numOfTestCase; i++) {
				char[] input = scanner.nextLine().toCharArray();
				if (input.length <= 1000) {
					int lastNumber = -1;
					String out = "";
					int numPressed[];
					for (int j = 0; j < input.length; j++) {
						numPressed = getNumberPressed(input[j]);
						if (lastNumber == numPressed[0]) {
							out += " ";
						}
						while (numPressed[1] >= 0) {
							out += numPressed[0];
							numPressed[1]--;
						}
						lastNumber = numPressed[0];
					}
					System.out.println("Case #" + (i + 1) + ": " + out);
				}
			}
		}
		scanner.close();
	}

	public static int[] getNumberPressed(char c) {
		int data[] = new int[2];
		if (c >= 'a' && c <= 'o') {
			data[0] = (c - 'a') / 3 + 2;
			data[1] = (c - 'a') % 3;
		} else if (c >= 'p' && c <= 's') {
			data[0] = 7;
			data[1] = c - 'p';
		} else if (c >= 't' && c <= 'v') {
			data[0] = 8;
			data[1] = c - 't';
		} else if (c >= 'w' && c <= 'z') {
			data[0] = 9;
			data[1] = c - 'w';
		} else {
			data[0] = 0;
			data[1] = 0;
		}
		return data;
	}
}