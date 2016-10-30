package week_7;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <p>
 *         Code tham khảo
 *         <p>
 *         Độ phức tạp thuật toán: O(n)
 *         <p>
 *         Do Air tăng cả H (health) và A (armor), nên ta sẽ bắt đầu từ Air. Mỗi
 *         bước di chuyển lẻ ( sau khi di chuyển vào Air hoặc Water), ta di
 *         chuyển quay lại Air.
 *         Điều kiện rằng buộc là H > 0 và A > 0.
 *         <ul>
 *         <li>Nếu H < 5 và A < 10, không thể đi vào Water.
 *         <li>Nếu H < 20, không thể đi vào Fire.
 *         <li>Nếu H <= 5 và A <= 10, kết thúc trò chơi.
 *         </ul>
 *         surviveTime lưu tổng thời gian bạn có thể tồn tại. Tăng thêm 2 do có
 *         2 lần di chuyển từ Air - Water - Air (tương tự với Fire).
 */
public class DIEHARD {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		while (testCases-- > 0) {
			int health = scanner.nextInt();
			int armor = scanner.nextInt();
			if (health == 0 || armor == 0) {
				System.out.println(0);
			} else {
				int surviveTime = 1;
				health += 3;
				armor += 2;
				while (true) {
					if (health > 5 && armor > 10) { // water & air
						health -= 2;
						armor -= 8;
						surviveTime += 2;
					} else if (health > 20 && armor <= 10) { // fire & air
						health -= 17;
						armor += 7;
						surviveTime += 2;
					} else { // game ends
						System.out.println(surviveTime);
						break;
					}
				}
			}
		}
		scanner.close();
	}

}
