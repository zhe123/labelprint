package labelPrinting;
import java.io.IOException;

import javax.xml.soap.*;

public class UserLogout {
	 public static void createSoapEnvelope(SOAPMessage soapMessage,String token) throws SOAPException{
	    	SOAPPart soapPart=soapMessage.getSOAPPart();
	    	String Namespace3 ="soap";
	    	String Namespace2 ="xsd";
	    	String Namespace1="xsi";
	    	String LogoutUser="LogoutUser";
	    	String AccessToken="AccessToken";
	    	String NamespaceUrl="http://www.usps-cpas.com/usps-cpas/GSSAPI/";//the url of usps-gss api
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
	    	UserInfo userinfo = new UserInfo();;
	    	SOAPBody soapBody=envelope.getBody();
	    	SOAPElement soapBodyElem= soapBody.addChildElement(LogoutUser,"", NamespaceUrl);
	    	SOAPElement soapBodyElem1=soapBodyElem.addChildElement(AccessToken);
	    	
	   
	    	soapBodyElem1.addTextNode(token);
	   
	    	
	    	
	    	
	    }
		public static void callLogoutUserService(String soapApiUrl,String soapAction ) {
			
			try {
				SOAPConnectionFactory soapConnectionFactory =SOAPConnectionFactory.newInstance();
				SOAPConnection soapConnection=soapConnectionFactory.createConnection();
				SOAPMessage soapResponse=soapConnection.call(createSOAPRequest(soapAction), soapApiUrl);
				// Print the SOAP Response
	            System.out.println("Response SOAP Message:");
	            soapResponse.writeTo(System.out);
	            System.out.println();

	            soapConnection.close();
			}catch(Exception e ) {
				System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
	            e.printStackTrace();
			}
		}
		public static SOAPMessage createSOAPRequest(String soapAction ) throws SOAPException, IOException {
			MessageFactory messageFactory=MessageFactory.newInstance();
			Token toke=new Token();
			SOAPMessage soapMessage=messageFactory.createMessage();
			String token=toke.getAccess_token();
			createSoapEnvelope(soapMessage,token);
			MimeHeaders headers=soapMessage.getMimeHeaders();
			headers.addHeader("SOAPAction", soapAction);
			soapMessage.saveChanges();
			/* Print the request message, just for debugging purposes */
	        System.out.println("Request SOAP Message:");
	        soapMessage.writeTo(System.out);
	        System.out.println("\n");

	        return soapMessage;
			
		} 
	

}
