package day12;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXmlDemo1 {

	public static void main(String[] args) {
		
		try {
			File file = new File("emplist.xml");
			SAXReader read = new SAXReader();
			Document document = read.read(file);
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for(Element eleEmp:elements){
				Element nameEle = eleEmp.element("name");
				String name = nameEle.getText();
				System.out.println(name);
				String gender = eleEmp.elementText("gender");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
