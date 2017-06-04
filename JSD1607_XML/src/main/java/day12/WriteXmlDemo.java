package day12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class WriteXmlDemo {

	public static void main(String[] args) {
		
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1,"张三",22,"男",5000));
		list.add(new Emp(2,"李四",23,"女",6000));
		list.add(new Emp(3,"王五",24,"男",7000));
		list.add(new Emp(4,"赵六",25,"女",8000));
		list.add(new Emp(5,"钱七",26,"男",9000));
		
		
		
		//1
		Document document = DocumentHelper.createDocument();
		//2 注意，这个addElement("list")方法只能调用一次，因为只有一个根元素
		Element root = document.addElement("list");
		
		for(Emp emp:list){
			//添加name标签并补充内容
			Element empEle = root.addElement("emp");
			Element nameEle = empEle.addElement("name");
			nameEle.addText(emp.getName());
			
			Element ageEle = empEle.addElement("age");
			
			ageEle.addText(String.valueOf(emp.getAge()));
			
			Element genderEle = empEle.addElement("gender");
			genderEle.addText(emp.getGender());
			
			Element salaryEle = empEle.addElement("salary");
			salaryEle.addText(String.valueOf(emp.getSalary()));
			
			empEle.addAttribute("id", String.valueOf(emp.getId()));
			
		}
			//4
			XMLWriter writer = null;
			try {
		//	writer = new XMLWriter();
				//创建一个漂亮的输出
				writer = new XMLWriter(OutputFormat.createPrettyPrint());
				FileOutputStream fos = 
						new FileOutputStream("myemp.xml");
				writer.setOutputStream(fos);
				writer.write(document);
				System.out.println("写出完毕");
			} catch (Exception e) {
				
			}finally{
				if(writer!=null){
					try {
						writer.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}
			
			
			
			
		
		
	}
	/*
	 *  大致步骤：
		1.创建Document对象表示一个空白文档
		2.向Document中添加根元素
		3.向根元素中根据xml文档预定的格式添加若干级子元素
		4.创建XMLWriter
		5.通过XMLWriter将Document写出
	 * 
	 * 
	 */
	
	
	
	
	
}
