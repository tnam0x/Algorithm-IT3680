package adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class InitInput {
	public static final String PATH_OUTPUT_FILE = "D:\\ToiletSeat\\Test";

	public static void main(String[] args) throws IOException {
		Scanner inp = new Scanner(System.in);
		for (int index = 1; index <= 10; index++) {
			//			System.out.print("Nhập số phần tử: ");
			int numberOfInteger = 0;
			String path = PATH_OUTPUT_FILE;
			if (index != 10) {
				path += "0" + index;
			} else {
				path += index;
			}
			File file = new File(path);
			file.mkdirs();
			try (PrintWriter writer = new PrintWriter(new FileWriter(file + "\\ToiletSeat.inp", false), true)) {
				//				writer.println(numberOfInteger);
				Random random = new Random();
				numberOfInteger = random.nextInt(1001);
				for (int i = 0; i < numberOfInteger; i++) {
					int x = random.nextInt(2);
					if (x == 0) {
						writer.print("U");
					} else {
						writer.print("D");
					}
				}
				System.out.println("Done: " + index);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
		inp.close();
	}
}
