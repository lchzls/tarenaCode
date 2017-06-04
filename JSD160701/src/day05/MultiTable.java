package day05;
//99乘法表
public class MultiTable {
	public static void main(String[] args) {
     
     for(int num=1;num<=9;num++){ //控制行
     for(int i=1;i<=num;i++){     //控制列
    	 System.out.print(i+"*"+num+"="+i*num+"\t");
     }
     System.out.println();//换行
     }
	}
}
