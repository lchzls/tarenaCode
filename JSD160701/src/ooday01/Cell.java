package ooday01;

public class Cell {
   int row;//行号
   int col;//列号
   void drop(){//下落一格
	   row++;
   }
   void moveleft(int n){//左移n格
	   col -=n;
   }
   String getCellInfo(){//获取格子的行号和列号
	   return row+"，"+col;
   }
}
