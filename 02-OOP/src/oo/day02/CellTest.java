package oo.day02;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
		
		Cell c1 = new Cell(); //调无参构造
		Cell c2 = new Cell(4); //调1个参数的构造
		Cell c3 = new Cell(2,5); //调2个参数的构造
		
		
		/*
		Cell c = new Cell();
		c.drop();
		c.drop(2);
		c.moveLeft();
		c.moveLeft(3);
		*/
		printWall(c3);
	}

	//打墙+打格
	public static void printWall(Cell cc){
		for(int i=0;i<20;i++){ //行
			for(int j=0;j<10;j++){ //列
				if(i==cc.row && j==cc.col){ //行列匹配
					System.out.print("* ");
				}else{
					System.out.print("- ");
			    }
			}
			System.out.println();
		}
	}
}














