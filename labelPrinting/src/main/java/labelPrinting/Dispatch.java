package labelPrinting;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class Dispatch {
    private String dispatchID;
   
	public void setDispatchID(String dispatchID) {
		this.dispatchID=dispatchID;
	}
	public SOAPMessage close_dispatch() throws SOAPException, IOException {
		
		
		String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/CloseDispatch";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
		SOAPElement soapBodyElem=soapBody.addChildElement("CloseDispatch","", Utility.NamespaceUrl);
		SOAPElement soapElement1=soapBodyElem.addChildElement("AccessToken");
		Token token=new Token();
		soapElement1.addTextNode(token.getAccess_token());
		SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
		return soapResponse;
	}
	public SOAPMessage get_required_reports_for_dispatch(String DispatchID) throws SOAPException, IOException {
		
		
		String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetRequiredReportsForDispatch";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
		SOAPElement soapBodyElem=soapBody.addChildElement("GetRequiredReportsForDispatch","", Utility.NamespaceUrl);
		SOAPElement soapElement1=soapBodyElem.addChildElement("AccessToken");
		SOAPElement soapElement2=soapBodyElem.addChildElement("DispatchID");
		Token token=new Token();
		soapElement1.addTextNode(token.getAccess_token());
		soapElement2.addTextNode(DispatchID);
		SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
		return soapResponse;

	}
	public SOAPMessage get_dispatch_report(String reportName,String requestFormat) throws SOAPException, IOException {
		
		String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetDispatchReport";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
		SOAPElement soapBodyElem=soapBody.addChildElement("GetDispatchReport","", Utility.NamespaceUrl);
		SOAPElement soapElement1=soapBodyElem.addChildElement("DispatchID");
		SOAPElement soapElement2=soapBodyElem.addChildElement("LocationID");
		SOAPElement soapElement3=soapBodyElem.addChildElement("ReportName");
		SOAPElement soapElement4=soapBodyElem.addChildElement("RequestFormat");
		SOAPElement soapElement5=soapBodyElem.addChildElement("AccessToken");
		soapElement1.addTextNode(this.dispatchID);
		soapElement2.addTextNode(UserInfo.locationID);
		soapElement4.addTextNode(reportName);
		soapElement2.addTextNode(requestFormat);
		Token token=new Token();
		soapElement5.addTextNode(token.getAccess_token());
		
		SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
		return soapResponse;
		
		
		
		
	}
}
