package oo.day02;
//J型
public class J {
	Cell[] cells;
	J(){
		this(0,0);
	}
	J(int row,int col){
		cells = new Cell[4];
		cells[0] = new Cell(row,col);
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+2);
	}
	
	void drop(){
		for(int i=0;i<cells.length;i++){ //遍历所有格子
			cells[i].row++; //格子行加1
		}
	}
	void moveLeft(){
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){
		for(int i=0;i<cells.length;i++){
			String str = cells[i].getCellInfo(); //获取每个格子的行号和列号
			System.out.println(str);
		}
	}
	
}



