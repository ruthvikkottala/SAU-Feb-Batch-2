package assignment2;

import java.io.File;
import java.io.IOException;

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


public class Code {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            Element rootElement = doc.createElement("CSR_Report");
            
          
            Element body = doc.createElement("CSR_Report_Body");
         
//            -------------------- 
            
            Document f1=dBuilder.parse("license1.xml");
            Document f2=dBuilder.parse("license2.xml");
           
            
           NodeList file1=f1.getElementsByTagName("CSR_Report");
           if(file1.item(0).getNodeType()==Node.ELEMENT_NODE) {
        	   Node f1_body=file1.item(0);
               NodeList f1_rd=f1_body.getChildNodes();
               //Loop thru all CSR_Report_Body Elements
               for(int b=0;b<f1_rd.getLength();b++) {
            	   if(f1_rd.item(b).getNodeType()==Node.ELEMENT_NODE && f1_rd.item(b).getNodeName()=="CSR_Report_Body") {
	            		Node bd=f1_rd.item(b);
	            		NodeList csr_prod=bd.getChildNodes();
	            		//Get all CSR_Producers
	            		for(int i=0;i<csr_prod.getLength();i++) {
	            			// adding all producers from first file into result file
	            			if(csr_prod.item(i).getNodeType()==Node.ELEMENT_NODE) {
	            				Node csr_n=csr_prod.item(i).cloneNode(true);
	            				doc.adoptNode(csr_n);
	            				body.appendChild(csr_n);
	            			}
	            		}
            	   }
               }
               
        
        }
        //compare and add elements from second file
           NodeList file2=f2.getElementsByTagName("CSR_Producer");
           NodeList firstFile =body.getChildNodes();
           for(int a=0;a<file2.getLength();a++) {
        	   Element outerNode = (Element)file2.item(a);
        	   NodeList outerList = outerNode.getChildNodes();
        	   //System.out.println(outerNode.getAttribute("NIPR_Number"));
        	   boolean flag = false;
           //search if nipr number already added
        	   for(int b=0;b<firstFile.getLength();b++) {
        	   if(firstFile.item(b).getNodeType()==Node.ELEMENT_NODE) {
        		   Element node = (Element)firstFile.item(b);
        		   if (node.hasAttribute("NIPR_Number") && node.getAttribute("NIPR_Number").equals(outerNode.getAttribute("NIPR_Number"))) {
        			   System.out.println("Match found for - ");
        			   System.out.println(node.getAttribute("NIPR_Number"));
        			   //get list of licenses
        			   NodeList innerList = node.getChildNodes();
        			   for(int c=0;c<outerList.getLength();c++) {
        				   if(outerList.item(c).getNodeType()==Node.ELEMENT_NODE) {
        				   Element outerlisc = (Element)outerList.item(c);
	        				   for(int d=0;d<innerList.getLength();d++) {
	        					   if(innerList.item(d).getNodeType()==Node.ELEMENT_NODE) {
		        					   Element lisc = (Element)innerList.item(d);
		        	        		   if (lisc.hasAttribute("License_Number") && lisc.getAttribute("License_Number").equals(outerlisc.getAttribute("License_Number"))) {
		        	        			   System.out.println("Same license number found -------------");
		        	        			   //same license node found
		        	        			   //clone all LAO from (outer) file2 and append to (inner) license node in result file
		        	        			  
		        	        				   NodeList prodList = body.getChildNodes();
		        	        				   for(int x=0;x<prodList.getLength();x++) {
		        	        					   NodeList resultList = prodList.item(x).getChildNodes();
		        	        					   
		    		        	        				   for(int f=0;f<resultList.getLength();f++) {
		    		        	        					   if(resultList.item(f).getNodeType()==Node.ELEMENT_NODE) {
		    		        		        					   Element reslisc = (Element)resultList.item(f);
		    		        		        					  
		    		        	        					   if(reslisc.hasAttribute("License_Number") && reslisc.getAttribute("License_Number").equals(outerlisc.getAttribute("License_Number"))) {
		    		        	        						   System.out.println("+++++++++++++");
		    		        	        						   System.out.println(reslisc.getAttribute("License_Number"));
		    		        	        						   NodeList newLAOList = outerlisc.getChildNodes();
		    		        	        						   
		    		    		        	        			   for(int e=0;e<newLAOList.getLength();e++) {
		    		    		        	        				   if(newLAOList.item(e).getNodeType()==Node.ELEMENT_NODE) {
			    		    		        	        				   System.out.println(((Element)newLAOList.item(e)).getAttribute("LOA_Name"));
			    		    		        	        				   Node newLAO = newLAOList.item(e);
			    		    		        	        				   doc.adoptNode(newLAO);
			    		    		        	        				   reslisc.appendChild(newLAO);
			    		    		        	        				   System.out.println("Adding new LAO+++++++++++++");
		    		    		        	        				   }
		    		    		        	        			   }
		    		        	        						  
		    		        	        					   }
		    		        	        					   }
		    		        	        				   } 
		        	        				   }
		        	        				
		        	        				   
		        	        				  // lisc.appendChild(newLAO);
		        	        			   
		        	        			   
		        	        		   }
	        					   }
	        				   }
        				   }
        			   }
        			   //check if same license number append LAO nodes
        			   System.out.println("------------------------------------------ ");
        			   flag= true;
        		   }
        	   	}
        	   }
        	 //If new nipr number append the CSR_Producer node to result file
        	   if(!flag) {
        		   System.out.println("No match found for - "); 
        		   System.out.println(outerNode.getAttribute("NIPR_Number"));  
        		   Node newProducer = outerNode.cloneNode(true);
        		   doc.adoptNode(newProducer);
        		   body.appendChild(newProducer);
        	   }
        	   flag = false; 
           }
           rootElement.appendChild(body);
           doc.appendChild(rootElement);
           
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           // for pretty print
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");
           DOMSource source = new DOMSource(doc);

           // write to console or file
//           StreamResult console = new StreamResult(System.out);
           StreamResult file = new StreamResult(new File("result.xml"));

           // write data
//           transformer.transform(source, console);
           transformer.transform(source, file);
    }



    

}