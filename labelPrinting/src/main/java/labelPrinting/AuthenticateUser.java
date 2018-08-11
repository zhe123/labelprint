package labelPrinting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.*;

public class AuthenticateUser {
   
    public static SOAPMessage authenticateUser() throws SOAPException, IOException{
        
        //create soap xml file and post http request to Gss api for authenticating user credientials
        String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/AuthenticateUser";
        MessageFactory messageFactory=MessageFactory.newInstance();
        // create soapmessage
        SOAPMessage soapMessage=messageFactory.createMessage();
        SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
        SOAPElement soapBodyElem=soapBody.addChildElement("AuthenticateUser","", Utility.NamespaceUrl);
        SOAPElement soapBodyElem1=soapBodyElem.addChildElement("UserID");
        SOAPElement soapBodyElem2=soapBodyElem.addChildElement("Password");
        SOAPElement soapBodyElem3=soapBodyElem.addChildElement("LocationID");
        SOAPElement soapBodyElem4=soapBodyElem.addChildElement("WorkstationID");
      
        soapBodyElem1.addTextNode(UserInfo.userID);
        soapBodyElem2.addTextNode(UserInfo.password);
        soapBodyElem3.addTextNode(UserInfo.locationID);
        soapBodyElem4.addTextNode(UserInfo.workstationID);
        //post http request
        SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
//        System.out.println("Response-second SOAP Message:");
//        soapResponse.writeTo(System.out);
//        System.out.println();
        return soapResponse;
    }
	
	// public static void main(String[] args) {
	// 	// TODO Auto-generated method stub
	// 	String soapApiUrl = "https://gss.usps.com/usps-cpas/TestGSSAPI/ConsolidatorWebService.asmx";
 //        String soapAction = "http://www.usps-cpas.com/usps-cpas/GSSAPI/AuthenticateUser";

 //        callauthenticateUserService(soapApiUrl, soapAction);

	// }

}
