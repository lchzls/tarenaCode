package oo.day03;
//四格拼板
public class Tetromino {

	Cell[] cells; //格子数组
	Tetromino(){
		cells = new Cell[4];
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











