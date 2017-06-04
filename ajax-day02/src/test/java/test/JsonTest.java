package test;

import java.util.ArrayList;
import java.util.List;

import bean.Stock;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

	/*
	 * ��ν�java����ת����json�ַ���
	 * {"code":"000410","name":����������";"price":10}
	 */
	public static void test1(){
		
		Stock s = new Stock();
		s.setCode("000410");
		s.setName("��������");
		s.setPrice(10);
		JSONObject jsonObj = JSONObject.fromObject(s);
		String jsonStr = jsonObj.toString();
		System.out.println(jsonStr);
	}
	
	/*
	 * ��ν��Ը�������ɵ�������߼���ת��Ϊjson�ַ���
	 */
	public static void test2(){
		List<Stock> stocks = new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s = new Stock();
			s.setCode("000041"+i);
			s.setName("��������"+i);
			s.setPrice(10+i);
			stocks.add(s);
		}
		//fromObject����Ҳ����ʹ��������Ϊ����
		JSONArray jsonArr = JSONArray.fromObject(stocks);
		String jsonStr = jsonArr.toString();
		System.out.println(jsonStr);
	}
	public static void main(String[] args) {
		//test1();
		test2();
		
	}
	
}
