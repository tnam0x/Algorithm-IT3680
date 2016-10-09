package week_1;

import java.util.Scanner;
/*
* Dung cac mang 1 chieu de luu so hang, cot va duong cheo (kieu boolean, mac dinh la true)
* Quet tung hang mot, khi gap quan Queen thi cho tat ca hang, cot va duong cheo chua quan Queen
* do thanh false, khi quet den quan Queen khac thi kiem tra xem no co nam trong hang, co hay duong
* cheo false khong, dong thoi kiem tra tong so quan Queen tren ban co (== 8)
* Do phuc tap thuat toan: 
**/
public class EightQueens {

	public static void main(String[] args) {
		boolean[] row = new boolean[8];
		boolean[] col = new boolean[8];
		
		boolean[] diagonal_right = new boolean[15];
		boolean[] diagonal_left = new boolean[15];
		
		boolean isValid = true;
		int numberOfQueen = 0;

		for (int i = 0; i < 15; i++) {
			if (i < 8) {
				row[i] = true;
				col[i] = true;
			}
			diagonal_right[i] = true;
			diagonal_left[i] = true;
		}

		Scanner scanner = new Scanner(System.in);
		for (int r = 0; r < 8; r++) {
			String line = scanner.nextLine();
			for (int c = 0; c < 8; c++) {
				if (line.charAt(c) == '*') {
					numberOfQueen++;
					
					if (!row[r] || !col[c] || !diagonal_left[r + c] || !diagonal_right[7 - r + c]) {
						isValid = false;
						break;
					} else {
						row[r] = false;
						col[c] = false;
						diagonal_left[r + c] = false;
						diagonal_right[7 - r + c] = false;
					}
				}
				
				if (!isValid) {
					break;
				}
			}
			
			if (!isValid) {
				break;
			}
		}
		
		if (isValid && numberOfQueen == 8) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
		scanner.close();
	}
}