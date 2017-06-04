package test;

import java.util.ArrayList;
import java.util.List;

import bean.Stock;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

	/*
	 * 如何将java对象转换成json字符串
	 * {"code":"000410","name":“沈阳机房";"price":10}
	 */
	public static void test1(){
		
		Stock s = new Stock();
		s.setCode("000410");
		s.setName("沈阳机房");
		s.setPrice(10);
		JSONObject jsonObj = JSONObject.fromObject(s);
		String jsonStr = jsonObj.toString();
		System.out.println(jsonStr);
	}
	
	/*
	 * 如何将对个对象组成的数组或者集合转换为json字符串
	 */
	public static void test2(){
		List<Stock> stocks = new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s = new Stock();
			s.setCode("000041"+i);
			s.setName("沈阳机床"+i);
			s.setPrice(10+i);
			stocks.add(s);
		}
		//fromObject方法也可以使用数组作为参数
		JSONArray jsonArr = JSONArray.fromObject(stocks);
		String jsonStr = jsonArr.toString();
		System.out.println(jsonStr);
	}
	public static void main(String[] args) {
		//test1();
		test2();
		
	}
	
}
