package day04;
//for的演示
public class ForDemo {
	public static void main(String[] args) {
		int sum = 0; 
		for(int num=1;num<=100;num++){
			if(num%10!=3){
				sum = sum+num;
			}
		}
		System.out.println("sum="+sum);
		
		
		/*理解continue的作用
		int sum = 0; 
		for(int num=1;num<=100;num++){
			if(num%10==3){
				continue; //跳过循环体中剩余语句而进入下一次循环
			}
			sum = sum+num;
		}
		System.out.println("sum="+sum);
		*/
		
		
		
		/*
		 * sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 
		 * num=4 sum=1+2+4
		 * ...
		 * num=13
		 * num=14 sum=1+2+4+...+14 
		 */
		
		
		
		
		
		
		
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;num++){
			sum = sum+num;
			//在某种特定情况下才break退出循环
		}
		System.out.println("sum="+sum);
		*/
		
		
		/*
		int sum = 0;
		int num=1;
		for(;num<=100;num++){
			sum = sum+num;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;){
			sum = sum+num;
			num++;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0; 
		int num=1;
		for(;num<=100;){
			sum = sum+num;
			num++;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		for(;;){ //没有条件的循环，就是死循环
			System.out.println("我要学习...");
		}
		*/
		
		/*
		for(int i=0,j=6;i<5;i+=2,j-=2){

		}
		*/
		/*
		 * i=0,j=6 true
		 * i=2,j=4 true
		 * i=4,j=2 true
		 * i=6,j=0 false
		 */
		
		
		
		
		/*
		//累加:1+2+3+4+...+99+100=5050
		int sum = 0; //和
		for(int num=1;num<=100;num++){
			sum = sum+num;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		 *       sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 sum=1+2+3
		 * num=4 sum=1+2+3+4
		 * ...
		 * num=100 sum=1+2+3+4+...+100
		 * num=101
		 */
		
		
		
		
		/*
		for(int times=0;times<10;times++){
			System.out.println("行动是成功的阶梯");
		}
		System.out.println("over");
		
		for(int num=1;num<=9;num++){
			System.out.println(num+"*9="+num*9);
		}
		System.out.println("over");
		*/
	}
}















