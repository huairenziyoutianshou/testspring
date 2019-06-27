package net.testSpring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.propertyeditors.ResourceBundleEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//引入配置文件
		Resource re = new FileSystemResource("helloMessage.xml");
		//
		BeanFactory bf = new XmlBeanFactory(re);
		
		//
		
		person person =  (person) bf.getBean("person");
		
		String s = person.sayHello();
		
		System.out.println(s);
				

	}

}
