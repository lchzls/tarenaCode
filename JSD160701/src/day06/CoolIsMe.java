package day06;

public class CoolIsMe {
public static void main(String[] args) {
	int count =0;
	for(int num=2;num<=100;num++){
		boolean flag=true;
		for(int i=2;i<Math.sqrt(num);i++){
			if(num%i==0){
				flag= false;
				break;
			}
		}
		
	
	if (flag){
		count++;
		System.out.print(num+"\t");
		if(count%10==0){
			System.out.println();
		}
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	/*int num = 8;
	boolean flag =false;    //1.����������
	for(int i=2;i<num;i++){ //2/3/4/5/6...
		if(num%i==0){
			flag=false;     //2.�޸�Ϊ��������
			break;
		}
	}
	if(flag==true){          //3.�жϵý��� , if(flag==true)�൱�� if(flag)
		System.out.println(num+"������");
	}else{
		System.out.println(num+"��������");
	}
	*/
}
}
