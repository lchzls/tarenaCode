package day06;

	import java.util.Arrays;
	import java.util.Random; 
	public class Nomomo {  
		/**      * 该方法实现生成指定元素数目的数组，该数组的元素为指定范围内的随机数，并返回该数组    
		 *   *      * @param length  
		 *       * 指定数组的长度    
		 *         * @param max     
		 *          * 指定范围的最大值   
		 *             * @return 生成的数组     
		 *              */   
		public static int[] generateArray(int length, int max) {   
			// 创建长度为length的数组       
			int[] arr = new int[length];       
			// 循环生成length个数值，并赋值给数组的元素     
			Random ran = new Random();       
			for (int i = 0; i < length; i++) {      
				arr[i] = ran.nextInt(max);     
				}       
			// 返回生成的数组      
			return arr;     }  
		public static void main(String[] args) {   
			//调用生成数组的方法    
			int[] arr=generateArray(6,100);     
			//输出生成的数组       
			System.out.println("生成的数组为："+Arrays.toString(arr));     } 
		
	}
		 
		 

