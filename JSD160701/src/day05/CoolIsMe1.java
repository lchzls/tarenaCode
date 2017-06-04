package day05;

public class CoolIsMe1 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
			System.out.println(arr[i]);
		}
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("最大值为" + max);
	}
}
