package day_4;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		float f = scanner.nextFloat();
		scanner.useLocale(Locale.CANADA);
		System.err.println(f);
		scanner.close();
	}
}
