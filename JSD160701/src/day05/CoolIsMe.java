package day05;

public class CoolIsMe {
	public static void main(String[] args) {
		// �žų˷���
		for (int num = 1; num <= 9; num++) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + "*" + num + "=" + i * num + "\t");
			}
			System.out.println();
		}
	}
}
