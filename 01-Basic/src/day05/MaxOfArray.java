package day05;
import java.util.Arrays;
//求数组元素的最大值
public class MaxOfArray {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		
		int max = arr[0]; //假设第1个元素的值为最大值
		for(int i=1;i<arr.length;i++){ //遍历剩余元素
			if(arr[i]>max){ //若剩余元素大于max
				max=arr[i]; //修改max为较大的
			}
		}
		System.out.println("最大值为:"+max);
		
		//扩容(扩大一个容量)
		arr = Arrays.copyOf(arr,arr.length+1);
		arr[arr.length-1] = max; //将最大值赋值给最后一个元素
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
	}
}




















