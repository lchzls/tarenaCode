 package ooday01;

public class CellTest {
public static void main(String[] args) {
	Cell c = new Cell();
	c.row = 2;//��
	c.col = 5;//��
	printWall(c);//Cell cc=c;
	
	System.out.println("�����");
	c.drop();
	printWall(c);
	System.out.println("����3��");
	c.moveleft(3);
	printWall(c);
	
	
	for(int i=0;i<20;i++){
		for(int j=0;j<10;j++){
			if(i==c.row && j==c.col){
				System.out.print("* ");
			}else{
				System.out.print("- ");
			}			
		}
		System.out.println();		
	}

	
	
	
	
	
	
	
	/*
	Cell c =new Cell();
		c.row = 2;
		c.col = 5;
		c.drop();
		c.moveLeft(3);
		String str = c.getCellInfo();
	System.out.println(str);
	*/
	}
public static void printWall(Cell c){
	for(int i=0;i<20;i++){
		for(int j=0;j<10;j++){
			if(i==c.row && j==c.col){
				System.out.print("* ");
			}else{
				System.out.print("- ");
			}			
		}
		System.out.println();		
	}
}
}
