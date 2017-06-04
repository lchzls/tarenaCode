package day04;

import java.util.Scanner;

public class Zouye2 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入会员积分");
        int score = scan.nextInt();
        if(score>8000){
        	System.out.println("discount:0.6");
        }else if(score>=4000){
        	System.out.println("discount:0.7");
        }else if(score>=2000){
        	System.out.println("discount:0.8");
        }else if(score<2000){
        	System.out.println("discount:0.9");
        }
        
	}
}
