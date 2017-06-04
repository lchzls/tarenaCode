package day04;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = (int) (Math.random() * 1000 + 1);// 随机生成1到1000的数；
		System.out.println(num);//作弊的
		int guess;
		do {

			System.out.println("猜吧！");
			guess = scan.nextInt();
			if (guess == 0) {
				break;
			}
			if (guess > num) {
				System.out.println("太大了");
			} else if (guess < num) {
				System.out.println("太小了");
			}
		} while (guess != num);
		if (guess == num) {
			System.out.println("恭喜你，猜对了！");
		} else {
			System.out.println("下次再来吧！");
		}

		/*
		 * System.out.println("猜吧！"); int guess = scan.nextInt();
		 * while(guess!=num){ if(guess==0){ break; } if(guess>num){
		 * System.out.println("太大了"); }else{ System.out.println("太小了"); }
		 * System.out.println("猜吧！"); guess= scan.nextInt(); } if(guess==num){
		 * System.out.println("恭喜你，猜对了！"); }else{ System.out.println("下次再来吧！");
		 * }
		 */
	}
}
