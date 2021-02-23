package assignment2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Task2 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate cur_date = LocalDate.now();
		
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc1=dBuilder.newDocument();
            Element rootElement1 = doc1.createElement("CSR_Report");
            
            
            Element body1 = doc1.createElement("CSR_Report_Body");
            
            
            Document doc2=dBuilder.newDocument();
            Element rootElement2 = doc2.createElement("CSR_Report");
            
            
            Element body2 = doc2.createElement("CSR_Report_Body");
            Document doc = dBuilder.parse("result.xml");
            NodeList l1=doc.getElementsByTagName("CSR_Producer");
            
            for(int i=0;i<l1.getLength();i++) 
            {	
            	if(l1.item(i).getNodeType()==Node.ELEMENT_NODE) {
            		Element csr_prod=(Element)l1.item(i);
            		int add1=0;
            		int add2=0;
            		Node dummy1 = null,dummy2=null;
            		NodeList lsclist=csr_prod.getChildNodes();
            		for(int j=0;j<lsclist.getLength();j++) {
            			boolean flag1=false;
            			if(lsclist.item(j).getNodeType()==Node.ELEMENT_NODE) {
            				Element license=(Element)lsclist.item(j);
            				String date=license.getAttribute("License_Expiration_Date");
            				LocalDate exp_date=LocalDate.parse(date, dtf);
            			
            				flag1=cur_date.isBefore(exp_date);
            				
            				//System.out.println("flag value ---- "+flag);
            				if(flag1) {
            					add1++;
            					//System.out.println("Add value ---- "+add);
            					if(add1==1) {
            						System.out.println("Create dummy producer ---- ");
            						dummy1=createCSR_Producer(doc1, csr_prod.getAttribute("NIPR_Number"), csr_prod.getAttribute("Entity_Id"), csr_prod.getAttribute("Secondary_ID"));
            						 if(dummy1.getNodeType()==Node.ELEMENT_NODE) {
            							 System.out.println(((Element)dummy1).getAttribute("NIPR_Number"));
            						 }
            					}
            					if(dummy1 != null) {
            						Node newLisc = lsclist.item(j).cloneNode(true);
            	        		   doc1.adoptNode(newLisc);
            	        		   dummy1.appendChild(newLisc);	
            	        		 //  System.out.println("Adding license with date -------------"+license.getAttribute("License_Expiration_Date"));
                       			//System.out.println("/inside dummy producer ---- "+dummycsr.getChildNodes().getLength());
            					}
            				}
            				else {
            					add2++;
            					//System.out.println("Add value ---- "+add);
            					if(add2==1) {
            						System.out.println("Create dummy producer ---- ");
            						dummy2=createCSR_Producer(doc2, csr_prod.getAttribute("NIPR_Number"), csr_prod.getAttribute("Entity_Id"), csr_prod.getAttribute("Secondary_ID"));
            						 if(dummy2.getNodeType()==Node.ELEMENT_NODE) {
            							 System.out.println(((Element)dummy2).getAttribute("NIPR_Number"));
            						 }
            					}
            					if(dummy2 != null) {
            						Node newLisc = lsclist.item(j).cloneNode(true);
            	        		   doc2.adoptNode(newLisc);
            	        		   dummy2.appendChild(newLisc);	
            	        		 //  System.out.println("Adding license with date -------------"+license.getAttribute("License_Expiration_Date"));
                       			//System.out.println("/inside dummy producer ---- "+dummycsr.getChildNodes().getLength());
            					}
            				}
            				
            				
            				
            			}
            		}
            		if(dummy1 != null) {
            			if(dummy1.getNodeType()==Node.ELEMENT_NODE) {
							 System.out.println(((Element)dummy1).getAttribute("NIPR_Number"));
						 }
            			body1.appendChild(dummy1);
            		}
            		if(dummy2 != null) {
            			if(dummy2.getNodeType()==Node.ELEMENT_NODE) {
							 System.out.println(((Element)dummy2).getAttribute("NIPR_Number"));
						 }
            			body2.appendChild(dummy2);
            		}
            	}
            }
            rootElement1.appendChild(body1);
            doc1.appendChild(rootElement1);
            
            rootElement2.appendChild(body2);
            doc2.appendChild(rootElement2);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source1 = new DOMSource(doc1);
            DOMSource source2 = new DOMSource(doc2);

            // write to console or file
//            StreamResult console = new StreamResult(System.out);
            StreamResult file1 = new StreamResult(new File("valid.xml"));
            StreamResult file2 = new StreamResult(new File("invalid.xml"));

            // write data
//            transformer.transform(source, console);
            transformer.transform(source1, file1);
            transformer.transform(source2, file2);

	}
	 private static Node createCSR_Producer(Document doc, String NIPR_Number, String Entity_Id, String Secondary_ID) {
	        Element user = doc.createElement("CSR_Producer");

	        // set id attribute
	        user.setAttribute("NIPR_Number", NIPR_Number);
	        user.setAttribute("Entity_Id", Entity_Id);
	        user.setAttribute("Secondary_ID", Secondary_ID);

	        // create firstName element


	        return user;
	    }

}
