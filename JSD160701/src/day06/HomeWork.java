package day06;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[10];
		for (int i = 0; i < scores.length; i++) {
			System.out.println("请第" + (i + 1) + "个评委打分");
			scores[i] = scan.nextInt();
		}
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length - 1 - i; j++) {
				if (scores[j] > scores[j + 1]) {
					int m = scores[j];
					scores[j] = scores[j + 1];
					scores[j + 1] = m;

				}
			}
		}
		System.out.println("最小值为" + scores[0]);
		System.out.println("最大值为" + scores[scores.length - 1]);
		double mean = 0;
		for (int i = 0; i < scores.length; i++) {
			mean += scores[i];
		}
		double average = mean / (scores.length);
		System.out.println("平均值为" + average);
		scores = Arrays.copyOf(scores, scores.length + 1);
		scores[scores.length - 1] = (int) average;
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
	}
}
