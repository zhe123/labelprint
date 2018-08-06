package labelPrinting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.*;

public class AuthenticateUser {
    public static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException{
    	SOAPPart soapPart=soapMessage.getSOAPPart();
    	String Namespace3 ="soap";
    	String Namespace2 ="xsd";
    	String Namespace1="xsi";
    	String AuthenticateUser="AuthenticateUser";
    	String UserID="UserID";
    	String Password="Password";
    	String Location="LocationID";
    	String Workstation="WorkstationID";
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
//    	UserInfo userinfo = new UserInfo();;
//    	SOAPBody soapBody=envelope.getBody();
//    	SOAPElement soapBodyElem= soapBody.addChildElement(AuthenticateUser,"", NamespaceUrl);
//    	SOAPElement soapBodyElem1=soapBodyElem.addChildElement(UserID);
//    	SOAPElement soapBodyElem2=soapBodyElem.addChildElement(Password);
//    	SOAPElement soapBodyElem3=soapBodyElem.addChildElement(Location);
//    	SOAPElement soapBodyElem4=soapBodyElem.addChildElement(Workstation);
//   
//    	soapBodyElem1.addTextNode(userinfo.userID);
//    	soapBodyElem2.addTextNode(userinfo.password);
//    	soapBodyElem3.addTextNode(UserInfo.locationID);
//    	soapBodyElem4.addTextNode(userinfo.workstationID);
    	
    	
    	
    }
	public static void callauthenticateUserService(String soapApiUrl,String soapAction ) {
		
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
		SOAPMessage soapMessage=messageFactory.createMessage();
		createSoapEnvelope(soapMessage);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String soapApiUrl = "https://gss.usps.com/usps-cpas/TestGSSAPI/ConsolidatorWebService.asmx";
        String soapAction = "http://www.usps-cpas.com/usps-cpas/GSSAPI/AuthenticateUser";

        callauthenticateUserService(soapApiUrl, soapAction);

	}

}
