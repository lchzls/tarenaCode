package oo.day04;
//T型与J型的测试类
public class TJTest {
	public static void main(String[] args) {
		Tetromino t = new T(2,5);
		t.print();
		
		Tetromino j = new J(1,4);
		j.print();
	}
	
	//打墙+打图型
	public static void printWall(Tetromino tt){
		for(int i=0;i<20;i++){ //行
			for(int j=0;j<10;j++){ //列
				boolean flag = false; //1.假设打-
				for(int k=0;k<tt.cells.length;k++){
					if(i==tt.cells[k].row && j==tt.cells[k].col){
						flag = true; //2.修改为打*
						break;
					}
				}
				if(flag){ //3.判断得结果
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
	
}















