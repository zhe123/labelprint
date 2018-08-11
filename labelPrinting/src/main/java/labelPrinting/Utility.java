package labelPrinting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.*;


public class Utility {
	public static final String soapEndPointUrl="https://gss.usps.com/usps-cpas/TestGSSAPI/ConsolidatorWebService.asmx";
    public static final String NamespaceUrl="http://www.usps-cpas.com/usps-cpas/GSSAPI/";
	 public static SOAPEnvelope createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException{
	    	SOAPPart soapPart=soapMessage.getSOAPPart();
	    	String Namespace3 ="soap";
	    	String Namespace2 ="xsd";
	    	String Namespace1="xsi";
	    	
	    	//String NamespaceUrl="http://www.usps-cpas.com/usps-cpas/GSSAPI/";//the url of usps-gss api
	    	String NamespaceUrl1="http://www.w3.org/2001/XMLSchema-instance";
	    	String NamespaceUrl2="http://www.w3.org/2001/XMLSchema";
	    	String NamespaceUrl3="http://schemas.xmlsoap.org/soap/envelope/";
	    	SOAPEnvelope envelope=soapPart.getEnvelope();
	    	envelope.addNamespaceDeclaration(Namespace1, NamespaceUrl1);
	    	envelope.addNamespaceDeclaration(Namespace2, NamespaceUrl2);
	    	//envelope.addNamespaceDeclaration(Namespace3, NamespaceUrl3);
	    	
	    	/*
	    	 * Constructed SOAP Request Message:
	    	 *          <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
	                <SOAP-ENV:Header/>
	                <SOAP-ENV:Body>
	                    
	                </SOAP-ENV:Body>
	            </SOAP-ENV:Envelope>
	    	 */
	    	//SOAP Body
	      return envelope;
	    	
	    	
	    	
	    }
	 public static SOAPMessage createSOAPRequest(String soapAction,SOAPMessage soapMessage ) throws SOAPException, IOException {
//			MessageFactory messageFactory=MessageFactory.newInstance();
//			SOAPMessage soapMessage=messageFactory.createMessage();
//			createSoapEnvelope(soapMessage);
			MimeHeaders headers=soapMessage.getMimeHeaders();
			headers.addHeader("SOAPAction", soapAction);
			soapMessage.saveChanges();
			/* Print the request message, just for debugging purposes */
	        System.out.println("Request SOAP Message:");
	       ByteArrayOutputStream out = new ByteArrayOutputStream();
	       soapMessage.writeTo(out);
	        String xmlObject=new String(out.toByteArray());
	        soapMessage.writeTo(System.out);
	        System.out.println("\n");

	        return soapMessage;
			
		} 
	 public static SOAPMessage callUspsApiService(String soapApiUrl,String soapAction,SOAPMessage soapMessage) throws SOAPException, IOException {
		 
				SOAPConnectionFactory soapConnectionFactory =SOAPConnectionFactory.newInstance();
				SOAPConnection soapConnection=soapConnectionFactory.createConnection();
				SOAPMessage soapResponse=soapConnection.call(createSOAPRequest(soapAction,soapMessage), soapApiUrl);
				// Print the SOAP Response
//				  System.out.println("Response_first SOAP Message:");
//		            soapResponse.writeTo(System.out);
//		            System.out.println();
		            
	            soapConnection.close();
	            return soapResponse;
		
		 
		 
		 
		 
		 
		 
	        
		 
		
	 }
}
