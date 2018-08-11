package labelPrinting;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws SOAPException, IOException, ParserConfigurationException, SAXException, TransformerException {
		// TODO Auto-generated method stub
     //authenticateUser
		Token token=new Token();
		SOAPMessage soapResponse=AuthenticateUser.authenticateUser();
     System.out.println("Response SOAP Message:");
     soapResponse.writeTo(System.out);
     System.out.println(); 
     //autheticateuserResponse
     if(XmlDocument.isSuccess(soapResponse, "AuthenticateUser")) {
    	 
    	SOAPBody body= soapResponse.getSOAPBody();
    	NodeList list=body.getElementsByTagName("AccessToken");
    	System.out.println("haha"+list.item(0).getTextContent().toString());
    	token.setAccess_token(list.item(0).getTextContent().toString());
     }
     File xmlfile=new File("C://Users/annie/inputfile.xml");
  //   LinkedHashMap<String,LinkedHashMap> map=new LinkedHashMap<String,LinkedHashMap>();
     DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
     DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
     Document doc=dBuilder.parse(xmlfile);
     doc.setXmlStandalone(true);

     TransformerFactory tf = TransformerFactory.newInstance();
     Transformer transformer = tf.newTransformer();
     transformer.setOutputProperty(OutputKeys.METHOD, "xml");
     transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

     transformer.setOutputProperty(OutputKeys.INDENT, "yes");
     transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
     StringWriter writer = new StringWriter();
     transformer.transform(new DOMSource(doc), new StreamResult(writer));
     String output = writer.getBuffer().toString();//.replaceAll("\n|\r", "");
//     doc.getDocumentElement().normalize();
//     NodeList list=doc.getElementsByTagName("Manifest");
//    NodeList tempnode= list.item(0).getChildNodes(); 
//    	 for(int j=0;j<tempnode.getLength();j++) {
//    		 LinkedHashMap tempMap=new LinkedHashMap();
//    		 if(tempnode.item(j).getNodeType()==Node.TEXT_NODE) {
//    			 continue;
//    		 }
//    		 System.out.println(tempnode.item(j).getNodeName());
//    			 NodeList itemList=tempnode.item(j).getChildNodes();
//    		 for(int temp=0;temp<itemList.getLength();temp++) {
//    			if(itemList.item(temp).getNodeType()==Node.TEXT_NODE) {
//    					 continue; 
//    			}
//    			if(itemList.item(temp).getNodeName()=="Item") {
//    				 
//    				NodeList endList=itemList.item(temp).getChildNodes();
//    				LinkedHashMap endMap=new LinkedHashMap();
//    				for(int end=0;end<endList.getLength();end++) {
//    					if(endList.item(end).getNodeType()==Node.TEXT_NODE) {
//       					 continue; 
//       			         }
//    					 endMap.put(endList.item(end).getNodeName(),endList.item(end).getTextContent());
//    				}
//    				map.put(itemList.item(temp).getNodeName(), endMap);
//    				break;
//    			}
//    				 tempMap.put(itemList.item(temp).getNodeName(),itemList.item(temp).getTextContent());
//    				
//    		}
//    			 map.put(tempnode.item(j).getNodeName(),tempMap);
//    		
//    	}
//    		 
//    		 
   

    	 
    	 
     
     Package package1=new Package();
//     String xmlfile1=XmlDocument.writePackageDataToFile(map);
 //    String xml="<![CDATA["+xmlfile1+"]]>";
 //     System.out.println(xml);
     SOAPMessage soapResponse1=package1.LoadAndRecordLabeledPackage("<![CDATA[" +output+"]]>",token.getAccess_token());
   //Print the SOAP Response
	  System.out.println("Response SOAP Message:");
       soapResponse1.writeTo(System.out);
       System.out.println();
     
     
	}

}
