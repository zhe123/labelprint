package labelPrinting;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

public class Receptacle {
	
	
public void CreateReceptacleForRateTypeToDestination() {
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	
	
	
}
public void GetReceptacleLabel() {
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	
	
}
public void MoveReceptacleToOpenDispatch(){
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
}
	
	
	

}
