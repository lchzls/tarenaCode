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
		System.out.println("���ֵΪ��" + max);

		// ���ݣ�����һ��������
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = max;// �����ֵ��ֵ��arr���һ��Ԫ��
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
