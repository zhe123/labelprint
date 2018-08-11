package labelPrinting;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class Receptacle {
	
	
public void CreateReceptacleForRateTypeToDestination() throws SOAPException {
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	
	
	
}
public void GetReceptacleLabel() throws SOAPException {
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	
	
}
public void MoveReceptacleToOpenDispatch() throws SOAPException{
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
}
	
	
	

}
