package day04;
import java.util.Scanner;
//随机假加法运算器
public class Addition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;//总得分
		for(int i=1;i<=10;i++){//算十次
		int a=(int)(Math.random()*100);//加数a
		int b=(int)(Math.random()*100);//加数b
		int result = a + b;//存和
		System.out.println("("+i+")."+a+"+"+b+"=?");
		System.out.println("算吧");
		int answer = scan.nextInt();//2.答题
		if(answer==0){
			break;
		}
		if(answer==result){//3.判题
			System.out.println("答对了");
			score+=10;
		}else{
			System.out.println("答错了");
			
		}
		}
		System.out.println("score"+score);
	}

}
