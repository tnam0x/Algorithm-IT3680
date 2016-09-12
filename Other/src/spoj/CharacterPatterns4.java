package spoj;

import java.util.Scanner;

public class CharacterPatterns4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCase = scanner.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int height = scanner.nextInt();
			int width = scanner.nextInt();

			row = row * (height + 1) + 1;
			col = col * (width + 2) - col + 1;
			
			for(int j = 0; j < row; j++){
				for(int k = 0; k < col; k++){
					if (j%(height+1) == 0) {
						System.out.print("*");
					}else {
						if (k % (width + 1) == 0 ) {
							System.out.print("*");
						}else {
							System.out.print(".");
						}
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		scanner.close();
	}

}
