package ooday01;
//�������ͻ��Ⱥ���null
public class RefTypeNullDemo {
public static void main(String[] args) {
	Cell c =new Cell();
	Cell cc= c;//ָ��ͬһ����
	c.row=5;
	cc.row=8;
	System.out.println("c.row");//8
	
	int a=5;
	int b=8;//��ֵ
	a=8;
	b=88;
	System.out.println(a);//0
	
	Cell c1= new Cell();
	System.out.println(c1.row);//0
	c1=null;//�գ�û��ָ���κζ���
	System.out.println(c1.row);//��ָ���쳣
}
}
