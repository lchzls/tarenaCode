package day12;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author adminitartor
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 解析emplist.xml文档中的所有员工信息最终将每个员工信息以一个Emp实例
		 * 保存并存入List集合
		 */
		try {
			/*
			 * 解析XML的大致步骤：
			 * 1.创建SAXReader
			 * 2：使用SAXReader解析xml文档并生成一个Document对象
			 * 这一步就是DOM解析耗时耗资源的地方。
			 * 因为这一步就将xml文档全部解析完毕了存入一个Document对象。
			 * 3.通过Document对象获取根元素
			 * 2.通过根元素按照xml文档结构逐一获取子元素，最终达到遍历xml的目的。
			 */
			
			SAXReader reader = new SAXReader();
			File file = new File("emplist.xml");
			
			//2
			Document doc = reader.read(file);
			
            //3
			/*
			 * Document提供了获取根元素的方法
			 * Element getRootElement()
			 * 
			 * Element类
			 * 其每一个实例用于表示xml文档中的一个元素就是一对标签
			 * 
			 * 这里emplist.xml的根元素就是<list>标签
			 */
			Element root = doc.getRootElement();
	
			//4
			/*
			 * 
				4.Element方法提供了获取其表示的元素的相关内容
				  String getName() //获取当前元素的名字（即：标签名）
				
				  List elements() //获取当前元素下的所有子元素，该集合中的每一个元素都是一个Element实例
				
				  List elements(String name) //获取当前元素下所有的同名子元素
				
				  Element element(String name)//获取当前元素下指定的子元素

			 */
			
			//用来保存所有员工信息的集合
			List<Emp> list = new ArrayList<Emp>();
			/*
			 * 获取根元素《list》下的所有子元素，其中每一个子元素就是一个《emp》标签
			 */
			List<Element> elements = root.elements();
			for(Element empEle:elements){
				//System.out.println(e.getName());
				Element nameEle = empEle.element("name");
				String name = nameEle.getText();
//				System.out.println(name);
				
				//int age = Integer.parseInt(empEle.element("age").getText());
				int age = Integer.parseInt(empEle.elementText("age"));
				
				String gender = empEle.elementText("gender");
				
				int salary = Integer.parseInt(empEle.elementText("salary"));
				
//				System.out.println(age);
//				System.out.println(gender);
//				System.out.println(salary);
				
				/*
				 * Element提供了获取当前标签中间的文本信息
				 * String getText()
				 * String getTextTrim()
				 * */
				
				
				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());
				
				
				Emp emp = new Emp(id,name,age,gender,salary);
				list.add(emp);
				
			}
			System.out.println("解析完毕");
			for(Emp emp:list){
				System.out.println(emp);
			}
		} catch (Exception e) {
			
		}
	}
}
