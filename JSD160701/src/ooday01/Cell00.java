package ooday01;

public class Cell00 {
  int row;
  int col;
  void drop(){
	  row++;
  }
  void moveLeft(int n){
	  col-=n;
  }
  String getCellInfo(){
	return row+","+col;  
  }
}
