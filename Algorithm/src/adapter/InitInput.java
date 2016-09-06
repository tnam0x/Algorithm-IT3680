package adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class InitInput {
	public static final String PATH_OUPUT_FILE = "combsort.inp";

	public static void main(String[] args) throws IOException {
		Scanner inp = new Scanner(System.in);
		System.out.print("Nhập số phần tử: ");
		int numberOfInteger = inp.nextInt();
		inp.close();
		try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_OUPUT_FILE, false), true)) {
			writer.println(numberOfInteger);
			Random random = new Random();
			for (int i = 0; i < numberOfInteger; i++) {
				String token = "";
				double d = Math.sqrt(random.nextInt(Integer.MAX_VALUE));
				token += Math.round(d * 100) / 100.0;
				if (i != numberOfInteger - 1) {
					token += " ";
				}
				writer.print(token);
			}
			System.out.println("Done");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}