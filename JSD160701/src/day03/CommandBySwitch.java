package day03;
import java.util.Scanner;
public class CommandBySwitch {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("��ѡ���ܣ�1.��ʾȫ����¼ 2.��ѯ��¼��¼ 0.�˳�");
	int command = scan.nextInt();
	
	switch(command){
	case 1:
		System.out.println("��ʾȫ����¼");
		break;
	case 2:
		System.out.println("��ѯ��¼��¼");
		break;
	case 0:
		System.out.println("�˳�");
		break;
	default:
		System.out.println("�������");
	    
	}
	
}
}
