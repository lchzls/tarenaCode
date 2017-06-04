package day05;

import java.util.Arrays;

public class MaxOfArray {
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
		System.out.println("最大值为：" + max);

		// 扩容（扩大一个容量）
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = max;// 将最大值赋值给arr最后一个元素
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		/*
		 * int [] arr1=new int [10]; 
		 * for(int i=0;i<arr1.length;i++){
		 * arr1[i]=(int)(Math.random()*100);
		 *  } for(int i=0;i<arr1.length;i++){
		 * System.out.println(arr1[i]); }
		 */
	}
}
