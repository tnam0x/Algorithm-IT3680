package day_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T9Spelling {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCase = Integer.parseInt(reader.readLine());
		for (int i = 0; i < numOfTestCase; i++) {
			char[] input = reader.readLine().toCharArray();
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
