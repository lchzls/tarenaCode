package day06;

	import java.util.Arrays;
	import java.util.Random; 
	public class Nomomo {  
		/**      * �÷���ʵ������ָ��Ԫ����Ŀ�����飬�������Ԫ��Ϊָ����Χ�ڵ�������������ظ�����    
		 *   *      * @param length  
		 *       * ָ������ĳ���    
		 *         * @param max     
		 *          * ָ����Χ�����ֵ   
		 *             * @return ���ɵ�����     
		 *              */   
		public static int[] generateArray(int length, int max) {   
			// ��������Ϊlength������       
			int[] arr = new int[length];       
			// ѭ������length����ֵ������ֵ�������Ԫ��     
			Random ran = new Random();       
			for (int i = 0; i < length; i++) {      
				arr[i] = ran.nextInt(max);     
				}       
			// �������ɵ�����      
			return arr;     }  
		public static void main(String[] args) {   
			//������������ķ���    
			int[] arr=generateArray(6,100);     
			//������ɵ�����       
			System.out.println("���ɵ�����Ϊ��"+Arrays.toString(arr));     } 
		
	}
		 
		 

