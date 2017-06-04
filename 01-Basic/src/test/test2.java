package test;
/*
 * 面试题：
 */
public class test2 {
	public static void main(String[] args) {
		System.out.println(getValue(1));
	
		
	}
   public static int getValue(int i){
	
	    int result = 0;
	    switch(i){
	    case 1:
	    	result = result+1;
	    case 2:
	    	result = result +i*2;
	    case 3:
	    	result = result +i*3;
	    }
	    return result;
   }
}
