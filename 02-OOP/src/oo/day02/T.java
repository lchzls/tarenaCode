package oo.day02;
//T型
public class T {
	Cell[] cells; //格子数组
	T(){
		this(0,0);
	}
	T(int row,int col){
		cells = new Cell[4]; //创建格子数组对象
		cells[0] = new Cell(row,col); //创建格子对象
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+1);
	}
	void drop(){
		for(int i=0;i<this.cells.length;i++){ //遍历所有格子
			this.cells[i].row++; //格子行加1
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
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].getCellInfo(); //获取每个格子的行号和列号
			System.out.println(str);
		}
	}
	
}













