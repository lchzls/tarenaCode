package ioc;

public class A {

	private IB b;
	
	public void setB(IB b){
		System.out.println("A's setB()");
		this.b = b;
	}
	public A() {
		System.out.println("A()");
	}

	public void execute(){
		//��Ҫ����B�ṩ��f1()����
		b.f1();
	}
}
