package day05;

public class CoolIsMe3 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
			System.out.println(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}

	}
}
