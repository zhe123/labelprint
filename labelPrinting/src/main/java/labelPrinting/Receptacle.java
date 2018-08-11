package labelPrinting;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class Receptacle {
	private String rateType;
	private String dutiable;
	private String receptacleType;
	private String foreignOECode;
	private String countryCode;
	private String dateOfMailing;
	private String pieceCount;
	private String weightInLbs;

	public Receptacle(HashMap map) {
		
		this.rateType=(String)map.get("RateType");
		this.dutiable=(String) map.get("Dutiable");
		this.receptacleType=(String) map.get("ReceptacleType");
		this.foreignOECode=(String) map.get("ForeignOECode");
		this.countryCode=(String)map.get("CountryCode");
		this.dateOfMailing=(String)map.get("DateofMailing");
		this.pieceCount=(String) map.get("PieceCount");
		this.weightInLbs=(String) map.get("WeightInLbs");
		
		
		
		
	}
	
public SOAPMessage CreateReceptacleForRateTypeToDestination() throws SOAPException, IOException {
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/CreateReceptacleForRateTypeToDestination";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	SOAPElement soapElement=soapBody.addChildElement("CreateReceptacleForRateTypeToDestinationResult", "", Utility.NamespaceUrl);
	SOAPElement soapElement1=soapElement.addChildElement("RateType");
	SOAPElement soapElement2=soapElement.addChildElement("Dutiable");
	SOAPElement soapElement3=soapElement.addChildElement("ReceptacleType");
	SOAPElement soapElement4=soapElement.addChildElement("ForeignOECode");
	SOAPElement soapElement5=soapElement.addChildElement("CountryCode");
	SOAPElement soapElement6=soapElement.addChildElement("DateOfMailing");
	SOAPElement soapElement7=soapElement.addChildElement("PieceCount");
	SOAPElement soapElement8=soapElement.addChildElement("WeightInLbs");
	SOAPElement soapElement9=soapElement.addChildElement("AccessToken");
	soapElement1.addTextNode(this.rateType);
	soapElement2.addTextNode(this.dutiable);
	soapElement3.addTextNode(this.receptacleType);
	soapElement4.addTextNode(this.foreignOECode);
	soapElement5.addTextNode(this.countryCode);
	soapElement6.addTextNode(this.dateOfMailing);
	soapElement7.addTextNode(this.pieceCount);
	soapElement8.addTextNode(this.weightInLbs);
	Token token=new Token();
	soapElement9.addTextNode(token.getAccess_token());
	SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
	return soapResponse;
	
	
	
}
public SOAPMessage GetReceptacleLabel(String ReceptacleID) throws SOAPException, IOException {
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetReceptacleLabel";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	SOAPElement soapElement=soapBody.addChildElement("GetReceptacleLabel", "", Utility.NamespaceUrl);
	SOAPElement soapElement1=soapElement.addChildElement("ReceptacleID");
	SOAPElement soapElement2=soapElement.addChildElement("FileFormat");
	SOAPElement soapElement3=soapElement.addChildElement("AccessToken");
	soapElement1.addTextNode(ReceptacleID);
	soapElement2.addTextNode("PNG");

	Token token=new Token();
	soapElement3.addTextNode(token.getAccess_token());
	SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
	return soapResponse;
	
	
	
	
}
public SOAPMessage AddPackageInReceptacle(String USPSPackageTrackingID,String ReceptacleID) throws SOAPException, IOException {
	
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/AddPackageInReceptacle";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	SOAPElement soapElement=soapBody.addChildElement("AddPackageInReceptacle", "", Utility.NamespaceUrl);
	SOAPElement soapElement1=soapElement.addChildElement("USPSPackageTrackingID");
	SOAPElement soapElement2=soapElement.addChildElement("ReceptacleID");
	SOAPElement soapElement3=soapElement.addChildElement("AccessToken");
	soapElement1.addTextNode(USPSPackageTrackingID);
	soapElement2.addTextNode(ReceptacleID);
	Token token=new Token();
	soapElement3.addTextNode(token.getAccess_token());
	SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
	return soapResponse;
	
}
public SOAPMessage MoveReceptacleToOpenDispatch(String  ReceptacleID) throws SOAPException, IOException{
	
	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/MoveReceptacleToOpenDispatch";
	MessageFactory messageFactory=MessageFactory.newInstance();
	SOAPMessage soapMessage=messageFactory.createMessage();
	SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
	SOAPElement soapElement=soapBody.addChildElement("MoveReceptacleToOpenDispatch", "", Utility.NamespaceUrl);
	SOAPElement soapElement1=soapElement.addChildElement("ReceptacleID");
	SOAPElement soapElement2=soapElement.addChildElement("AccessToken");
	soapElement1.addTextNode(ReceptacleID);
	Token token=new Token();
	soapElement2.addTextNode(token.getAccess_token());
	SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
	return soapResponse;
}
	
	
	

}
