package oo.day03;
//格子类
public class Cell {
	int row; //行号
	int col; //列号
	Cell(){
		this(0,0);
	}
	Cell(int n){
		this(n,n);
	}
	Cell(int row,int col){
		this.row = row;
		this.col = col;
	}
	
	void drop(){ //下落一格
		row++;
	}
	void moveLeft(int n){ //左移n格
		col-=n;
	}
	String getCellInfo(){ //获取格子的行号和列号
		return row+","+col;
	}
	void moveRight(int n){
		col+=n;
	}

	void drop(int n){
		row+=n;
	}
	void moveLeft(){
		col--;
	}
}










