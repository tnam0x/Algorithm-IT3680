package kattis;

import java.util.Scanner;

public class Zamka {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int L = scanner.nextInt();
		int D = scanner.nextInt();
		int X = scanner.nextInt();
		scanner.close();
		// min
		for (int i = L; i <= D; i++) {
			int sum = 0;
			int temp = i;
			while(temp > 0){
				sum += temp % 10;
				temp = temp / 10;
			}
			if(sum == X){
				System.out.println(i);
				break;
			}
		}
		// max
		for (int i = D; i >= L; i--) {
			int sum = 0;
			int temp = i;
			while(temp > 0){
				sum += temp % 10;
				temp = temp / 10;
			}
			if(sum == X){
				System.out.println(i);
				break;
			}
		}
	}

}
