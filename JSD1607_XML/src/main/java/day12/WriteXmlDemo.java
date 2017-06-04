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
		list.add(new Emp(1,"����",22,"��",5000));
		list.add(new Emp(2,"����",23,"Ů",6000));
		list.add(new Emp(3,"����",24,"��",7000));
		list.add(new Emp(4,"����",25,"Ů",8000));
		list.add(new Emp(5,"Ǯ��",26,"��",9000));
		
		
		
		//1
		Document document = DocumentHelper.createDocument();
		//2 ע�⣬���addElement("list")����ֻ�ܵ���һ�Σ���Ϊֻ��һ����Ԫ��
		Element root = document.addElement("list");
		
		for(Emp emp:list){
			//���name��ǩ����������
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
				//����һ��Ư�������
				writer = new XMLWriter(OutputFormat.createPrettyPrint());
				FileOutputStream fos = 
						new FileOutputStream("myemp.xml");
				writer.setOutputStream(fos);
				writer.write(document);
				System.out.println("д�����");
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
	 *  ���²��裺
		1.����Document�����ʾһ���հ��ĵ�
		2.��Document����Ӹ�Ԫ��
		3.���Ԫ���и���xml�ĵ�Ԥ���ĸ�ʽ������ɼ���Ԫ��
		4.����XMLWriter
		5.ͨ��XMLWriter��Documentд��
	 * 
	 * 
	 */
	
	
	
	
	
}
