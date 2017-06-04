package ooday01;
//引用类型画等号与null
public class RefTypeNullDemo {
public static void main(String[] args) {
	Cell c =new Cell();
	Cell cc= c;//指向同一对象
	c.row=5;
	cc.row=8;
	System.out.println("c.row");//8
	
	int a=5;
	int b=8;//赋值
	a=8;
	b=88;
	System.out.println(a);//0
	
	Cell c1= new Cell();
	System.out.println(c1.row);//0
	c1=null;//空，没有指向任何对象
	System.out.println(c1.row);//空指针异常
}
}
