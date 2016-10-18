package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <P>
 *         Sắp xếp mảng chứa số ngày phát triển của các hạt giống theo thứ tự
 *         giảm dần, theo thứ tự từ 1..n.
 *         Tìm giá trị lớn nhất của tổng i + seeds[i] với i là số thứ tự của hạt
 *         giống seeds[i] trong mảng.
 *         Số ngày sớm nhất cần tìm sẽ là tổng trên + 1
 *         <p>
 *         Độ phức tạp thuật toán: O(nlogn) - xấu nhất: O(n^2). Do dùng
 *         QuickSort để sắp xếp nên độ phức tạp sẽ là của thuật toán sắp xếp đó.
 */
public class PlantingTrees {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numSeeds = scanner.nextInt();
		int seeds[] = new int[numSeeds + 1];
		for (int i = 1; i <= seeds.length; i++) {
			seeds[i] = scanner.nextInt();
		}
		sort(seeds, 0, numSeeds - 1);
		int max = 0;
		for (int i = 0; i < seeds.length; i++) {
			int sum = i + seeds[i];
			if (max < sum) {
				max = sum;
			}
		}
		System.out.println(max + 2);
		scanner.close();
	}

	public static void sort(int a[], int left, int right) {
		int i = left, j = right;
		int x = a[(left + right) / 2];
		do {
			// tìm phần tử sai vị trí
			while (a[i] > x)
				i++;
			while (a[j] < x)
				j--;
			// Hoán đổi nếu i nằm trước j
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		} while (i < j);
		if (left < j) {
			sort(a, left, j);
		}
		if (right > i) {
			sort(a, i, right);
		}
	}
}
