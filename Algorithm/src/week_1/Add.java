package week_1;

import java.util.Scanner;
/**
* Doc vao tu ban phim 2 so nguyen
* Sau do in ra man hinh tong 2 so
* Do phuc tap thuat toan: 
*/
public class Add {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(a + b);
		scanner.close();
	}
}
