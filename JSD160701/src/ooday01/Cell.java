package ooday01;

public class Cell {
   int row;//�к�
   int col;//�к�
   void drop(){//����һ��
	   row++;
   }
   void moveleft(int n){//����n��
	   col -=n;
   }
   String getCellInfo(){//��ȡ���ӵ��кź��к�
	   return row+"��"+col;
   }
}
