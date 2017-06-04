package ooday01;

public class CellTest00 {
public static void main(String[] args) {
	Cell c=new Cell();
	c.row=2;
	c.col=5;
	printWall(c);
	
	System.out.println("ÏÂÂäºó");
	c.drop();
	printWall(c);
	System.out.println("×óÒÆ3¸ñ");
	c.moveleft(3);
	printWall(c);
	
}
	public static void printWall(Cell c){
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				if(i==c.row&&j==c.col){
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		
	}
	
}

