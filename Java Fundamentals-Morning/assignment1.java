package assignment;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class assignment1 {

	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> dummy=new HashMap<Integer, Integer>();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		ArrayList<Student> finalList=new ArrayList<Student>();
		DocumentBuilder b;
		try {
			b = factory.newDocumentBuilder();
			Document doc=b.parse("assignment1.xml");
		  NodeList	list=doc.getElementsByTagName("student");
		  for(int i=0;i<list.getLength();i++) 
		  {
			Node s=list.item(i);
			if(s.getNodeType()==Node.ELEMENT_NODE) 
			{
				NodeList child=s.getChildNodes();
				Student student=new  Student();
				student.setRollno(Integer.parseInt(child.item(1).getTextContent()));
				student.setMarks(Integer.parseInt(child.item(3).getTextContent()));
				student.setSub(child.item(5).getTextContent());

				
				finalList.add(student);
				if(dummy.containsKey(student.getRollno())) {
					dummy.put(student.getRollno(), dummy.get(student.getRollno())+student.getMarks());
				}
				else {
					dummy.put(student.getRollno(), student.getMarks());
				}
				
			}
		  }

		  FileOutputStream fos=new FileOutputStream("output.txt");
		  ObjectOutputStream oos=new ObjectOutputStream(fos);

			  oos.writeObject(new Save(dummy));
		  oos.close();
		  
		  FileInputStream fis=new FileInputStream("output.txt");
		  ObjectInputStream ois=new ObjectInputStream(fis);
		  try {
			Save ob=(Save)ois.readObject();
			ois.close();
			for (Integer i : ob.result1.keySet()) {
				  System.out.println("key: " + i + " value: " + ob.result1.get(i));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class Save implements Serializable{
	HashMap<Integer, Integer> result1=new HashMap<Integer, Integer>();

	public Save(HashMap<Integer, Integer> result1) {
		super();
		this.result1 = result1;
	}
	
	
	
}
