package labelPrinting;

import java.io.File;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.*;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class XmlDocument {
	
  public static String writePackageDataToFile(Map map) throws TransformerException, ParserConfigurationException {
	    
	  
	    String namespaceUrl="http://www.w3.org/2001/XMLSchema-instance";
	    String namespaceUrl1="mailerdataformatf07.xsd";
	    String namespaceUrl2="mailerdataformatf07.xsd https://gss.usps.com/usps-cpas/mailerdataformatf07.xsd";
	  
        
        DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
        //create root elements
        Document doc= docBuilder.newDocument();
        Element rootElement =doc.createElement("Manifest");
        
        rootElement.setAttribute("xmlns",namespaceUrl1 );
        rootElement.setAttribute("xmlns:xsi", namespaceUrl);
        rootElement.setAttribute("xsi:schemaLocation", namespaceUrl2);
        doc.appendChild(rootElement);

        //create dispatch elements block
        Element dispatchElement=doc.createElement("Dispatch");  
        dispatchElement.setAttribute("xmlns", namespaceUrl1);
        rootElement.appendChild(dispatchElement);
         ((LinkedHashMap) map.get("Dispatch")).put("DispatchDateTime",LocalDateTime.now());
         ((LinkedHashMap) map.get("Dispatch")).put("TimeZone","PDT"); 
        //dispatch elements
        XmlDocument.getElements(doc,dispatchElement,(LinkedHashMap)map.get("Dispatch"));
        // Element ShippingAgentID=doc.createElement("ShippingAgentID");
        // dispatchElement.appendChild(ShippingAgentID);

        // Element ReceivingAgentID=doc.createElement("ReceivingAgentID");
        // dispatchElement.appendChild(ReceivingAgentID);

        // Element DispatchID=doc.createElement("DispatchID");
        // dispatchElement.appendChild(DispatchID);

        // Element TimeZone=doc.createElement("TimeZone");
        // dispatchElement.appendChild(TimeZone);

        // Element FileFormatVersion=doc.createElement("FileFormatVersion");
        // dispatchElement.appendChild(FileFormatVersion);


        //create package elments block
        Element packageElement=doc.createElement("Package");
        packageElement.setAttribute("PackageID",(String)((HashMap) map.get("Package")).get("PackageID"));
        packageElement.setAttribute("xmlns",namespaceUrl1);
        rootElement.appendChild(packageElement);
        //package elements
        XmlDocument.getElements(doc,packageElement,(LinkedHashMap)map.get("Package"));


        //create item elements block
        Element itemElement=doc.createElement("Item");
        itemElement.setAttribute("xmlns",namespaceUrl1);
        packageElement.appendChild(itemElement);
        //item elements
        XmlDocument.getElements(doc,itemElement,(LinkedHashMap)map.get("Item"));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString();//.replaceAll("\n|\r", "");
	    return output;

	    // write the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(doc);
//		StreamResult result = new StreamResult(new File("C://Users/annie/file.xml"));
//
//		// Output to console for testing
//		//StreamResult result = new StreamResult(System.out);
//
//		transformer.transform(source, result);
//		
//		transformer.setOutputProperty(OutputKeys.INDENT, "yes");



		//System.out.println("File saved!");

	  
		
	  
	  
	  
  }
  private static Element getSingleElement(Document doc,String name,String value) {
	  Element node=doc.createElement(name);
	  node.appendChild(doc.createTextNode(value==null?"":value ));
	  return node;
	  
  }
  private static void getElements(Document doc,Element element,LinkedHashMap map){
     LinkedHashMap tempMap=map;
     Iterator it=tempMap.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry entries=(Map.Entry)it.next();
        	Element temp=XmlDocument.getSingleElement(doc,entries.getKey().toString(),entries.getValue().toString());
        	element.appendChild(temp);
        	
        		
        }


  }
  public static boolean isSuccess(SOAPMessage soapResponse,String name) throws SOAPException {
	 boolean isSuccess = false;
	 SOAPBody body=soapResponse.getSOAPBody();
	 
	 NodeList list=body.getElementsByTagName(name+"Result");
	 for(int i=0;i<list.getLength();i++)
 {      NodeList innerList=list.item(i).getChildNodes();
		for(int j=0;j<innerList.getLength();j++) {
			
	//System.out.println(innerList.item(j).getTextContent().toString());		
	if(innerList.item(j).getNodeName().equalsIgnoreCase("Message")) {
		   isSuccess=innerList.item(j).getTextContent().toString()=="Success"?false:true;
		      
	 if(!isSuccess) {System.out.println("response failed");}
	 }
   }
  }
	 
	  
	  
	  
	  return isSuccess;
	 
	  
  }
  
  // public static void main(String argv[]) {
	  
	 //  XmlDocument xml=new XmlDocument();
	 //  HashMap map=new HashMap();
	  
	 //  xml.writePackageDataToFile(map);
	  
	  
  // }
  
}
