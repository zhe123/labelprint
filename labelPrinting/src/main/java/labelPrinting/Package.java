package labelPrinting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.soap.*;
public class Package {
    private  String FileFormat;
    private String OrderId; 
    private String ItemValueCurrencyType;
    private String SenderName;
    private String SenderFirstName;
    private String SenderBusiessName;
    private String SenderAddress_Line_1;
    private String SenderCity;
    private String SenderProvice;
    private String SenderPostal_Code;
    private String SenderCountry_Code;
    private String SenderPhone;
    private String SenderEmail;
    private String SenderSignature;
    private String RecipientFirstName;
    private String RecipientLastName;
    private String RecipientAddress_Line_1;
    private String RecipientCity;
    private String RecipientProvince;
    private String RecipientPostal_Code;
    private String RecipientCountry_Code;
    private String RecipientPhone;
    private String RecipientEmail;
    private String PackageType;
    private String PackageId;
    private double PackageWeight;
    private String WeightUnit;
    private String UnitOfMeasurement;
    private String ServiceType;
    private String RateType;
    private String PackagePhysicalCount;
    private String MailingAgentID;
    private String ValueLoaded;
    private String PFCorEEL;
    private String BoxNUmber;
	private String SenderMiddleInitial;
	private String SenderLastName;
	private String SenderBusinessName;
	private String SenderAddress_Line_2;
	private String SenderAddress_Line_3;
	private String SenderAddress_IsPOBox;
	private String SenderProvince;
	private String RecipientMiddleInitial;
	private String RecipientBusinessName;
	private String RecipientAddress_Line_2;
	private String RecipientAddress_Line_3;
	private String RecipientInLineTransLationAddressLine1;
	private String RecipientInLineTransLationAddressLine2;
	private String RecipientAddress_IsPOBox;
	private String PackageShape;
	private String ShippingandHandling;
	private String ShippingCurrencyType;
	private String PackageLength;
	private String PackageWidth;
	private String PackageHeight;
	private String PostagePaid;
	private String PostagePaidCurrencyType;
	private String RestrictionType;
	private String RestrictionComments;
	private String ReturnAgentID;
	private String LicenseNumber;
	private String CertificateNumber;
	private String InvoiceNumber;
	private String PaymentAndDeliveryTerms;
	private String ReturnServiceRequested;
	private String EntryFacilityZip;
	private String CustomerReferenceID;
	private String RedirectBusinessName;
	private String RedirectFirstName;
	private String RedirectLastName;
	private String RedirectAddress_Line_1;
	private String RedirectAddress_Line_2;
	private String RedirectAddress_Line_3;
	private String RedirectCity;
	private String RedirectProvince;
	private String RedirectPostal_Code;
	private String RedirectCountry_Code;
	private String RedirectPhone;
	private String RedirectEmail;
	private String ExporterReferenceType;
	private String ExporterReferenceValue;
	private String ExporterPhoneNo;
	private String ExporterEmail;
	private String ImporterReferenceType;
	private String ImporterReferenceValue;
	private String ImporterPhoneNo;
	private String ImporterEmail;
	private String DestinationLocation;
	private String PriceCategoryType;
	private String DestinationLocationID;
	private String RecipientFirstName_Foreign;
	private String RecipientLastName_Foreign;
	private String RecipientBusinessName_Foreign;
	private String RecipientAddress_Line_1_Foreign;
	private String RecipientAddress_Line_2_Foreign;
	private String RecipientAddress_Line_3_Foreign;
	private String RecipientCity_Foreign;
	private String RecipientProvince_Foreign;
	private String RecipientPostal_Code_Foreign;
	private String PackageOrderDate;
	private String InsuredAmount;
	
	
    public Package(HashMap map) {
    	this.PackageId=(String) map.get("PackageId");
    	this.OrderId=(String) map.get("OrderId"); 
//    	this.PackageType=(String) map.get("PackageType");
    	this.PackageWeight=(Double) map.get("PackageWeight");  
    	this.ItemValueCurrencyType=(String) map.get("ItemValueCurrencyType");
    	this.SenderName=(String)map.get("SenderName");
    	this.SenderFirstName=(String)map.get("SenderFirstName");
    	this.SenderMiddleInitial=(String)map.get("SenderMiddleInitial");
    	this.SenderLastName=(String)map.get("SenderLastName");
    	this.SenderBusinessName=(String)map.get("SenderBusinessName");
    	this.SenderAddress_Line_1=(String) map.get("SenderAddress_Line_1");
    	this.SenderAddress_Line_2=(String)map.get("SenderAddress_Line_2");
    	this.SenderAddress_Line_3=(String)map.get("SenderAddress_Line_3");
    	this.SenderAddress_IsPOBox=(String) map.get("SenderAddress_ISPOBox");
    	this.SenderCity=(String) map.get("SenderCity");
    	this.SenderProvince=(String) map.get("SenderProvince");
    	this.SenderPostal_Code=(String) map.get("SenderPostal_Code");
    	this.SenderCountry_Code=(String) map.get("SenderCountry_Code");
    	this.SenderCountry_Code=(String)map.get("SenderPhone");
    	this.SenderEmail=(String)map.get("SenderEmail");
    	this.SenderSignature=(String) map.get("SenderSignature");
    	this.RecipientFirstName=(String)map.get("RecipientName");
    	this.RecipientMiddleInitial=(String)map.get("RecipientMiddleInitial");
    	this.RecipientLastName=(String) map.get("RecipientLastName");
    	this.RecipientBusinessName=(String)map.get("RecipientBusinessName");
    	this.RecipientAddress_Line_1=(String)map.get("RecipientAddress_Line_1");
    	this.RecipientAddress_Line_2=(String)map.get("RecipientAddress_Line_2");
    	this.RecipientAddress_Line_3=(String)map.get("RecipientAddress_Line_3");
    	this.RecipientInLineTransLationAddressLine1=(String)map.get("RecipientInLineTranslatinAddressLine1");
    	this.RecipientInLineTransLationAddressLine2=(String)map.get("RecipientInLineTranslationAddressLine2");
    	this.RecipientAddress_IsPOBox=(String)map.get("RecipientAddress_IsPOBox");
    	this.RecipientCity=(String) map.get("RecipientCity");
    	this.RecipientProvince=(String)map.get("RecipientProvince");
    	this.RecipientPostal_Code=(String) map.get("RecipientPostal_Code"); 
    	this.RecipientCountry_Code=(String)map.get("RecipientCountry_Code"); 
    	this.RecipientPhone=(String)map.get("RecipientPhone");
    	this.PackageType=(String)map.get("PackageType");
    	this.PackageShape=(String)map.get("TaxpayerID");
    	this.ShippingandHandling=(String)map.get("ShippingandHandling");
    	this.ShippingCurrencyType=(String)map.get("ShippingCurrencyType");
    	this.WeightUnit=(String)map.get("WeightUnit");
    	this.PackageLength=(String)map.get("PackageLength");
    	this.PackageWidth=(String)map.get("PackageWidth");
    	this.PackageHeight=(String)map.get("PackageHeight");
    	this.UnitOfMeasurement=(String)map.get("UnitOfMeasurement");
    	this.ServiceType=(String)map.get("ServiceType");
    	this.RateType=(String)map.get("RateType");
    	this.PackagePhysicalCount=(String)map.get("PackagePhysicalCount");
    	this.PostagePaid=(String)map.get("PostagePaid");
    	this.PostagePaidCurrencyType=(String)map.get("PostagePaidCurrentyType");
    	this.RestrictionType=(String)map.get("RestrictionType");
    	this.RestrictionComments=(String)map.get("RestrictionComments");
    	this.MailingAgentID=(String)map.get("MailingAgenID");
    	this.ReturnAgentID=(String)map.get("ReturnAgentID");
    	this.ValueLoaded=(String)map.get("ValueLoaded");
    	this.LicenseNumber=(String)map.get("LicenseNumber");
    	this.CertificateNumber=(String)map.get("CertificateNumber");
    	this.InvoiceNumber=(String)map.get("InvoiceNumber");
    	this.PaymentAndDeliveryTerms=(String)map.get("PaymentAndDeliveryTerms");
    	this.PFCorEEL=(String)map.get("PFCorEEL");
    	this.ReturnServiceRequested=(String)map.get("ReturnServiceRequested");
    	this.EntryFacilityZip=(String)map.get("EntryFacilityZip");
    	this.CustomerReferenceID=(String)map.get("CustomerReferenceID");
    	this.RedirectBusinessName=(String)map.get("RedirectBusinessName");
    	this.RedirectFirstName=(String)map.get("RedirectFirstName");
    	this.RedirectLastName=(String)map.get("RedirectLastName");
    	this.RedirectAddress_Line_1=(String)map.get("RedirectAddress_Line_1");
    	this.RedirectAddress_Line_2=(String)map.get("RedirectAddress_Line_2");
    	this.RedirectAddress_Line_3=(String)map.get("RedirectAddress_Line_3");  
    	this.RedirectCity=(String)map.get("RedirectCity");
    	this.RedirectProvince=(String)map.get("RedirectProvice");
    	this.RedirectPostal_Code=(String)map.get("RedirectPostal_Code");
    	this.RedirectCountry_Code=(String)map.get("RedirectCountry_Code");
    	this.RedirectPhone=(String)map.get("RedirectPhone");
    	this.RedirectEmail=(String)map.get("RedirectEmail");
    	this.ExporterReferenceType=(String)map.get("ExporterReferenceValue");
    	this.ExporterReferenceValue=(String)map.get("ExporterReferenceValue");
    	this.ExporterPhoneNo=(String)map.get("ExporterPhoneNo");
    	this.ExporterEmail=(String)map.get("ExporterEmail");
    	this.ImporterReferenceType=(String)map.get("ImporterReferenceType");
    	this.ImporterReferenceValue=(String)map.get("ImporterReferenceValue");
    	this.ImporterPhoneNo=(String)map.get("ImporterPhoneNo");
    	this.ImporterEmail=(String)map.get("ImporterEmail");
    	this.DestinationLocationID=(String)map.get("DestionationLocationID");
    	this.PriceCategoryType=(String)map.get("PriceCategoryType");
    	this.RecipientFirstName_Foreign=(String)map.get("RecipientFirstName_Foreign");
    	this.RecipientLastName_Foreign=(String)map.get("RecipientLastName_Foreign");
    	this.RecipientBusinessName_Foreign=(String)map.get("RecipientBusinessName_Foreign");
    	this.RecipientAddress_Line_1_Foreign=(String)map.get("RecipientAddress_Line_1_Foreign");
    	this.RecipientAddress_Line_2_Foreign=(String)map.get("RecipientAddress_Line_2_Foreign");
    	this.RecipientAddress_Line_3_Foreign=(String)map.get("RecipientAddress_Line_3_Foreign");
    	this.RecipientCity_Foreign=(String)map.get("RecipientCity_Foreign");
    	this.RecipientProvince_Foreign=(String)map.get("RecipientProvince_Foreign");
    	this.RecipientPostal_Code_Foreign=(String)map.get("RecipientPostal_Code_Foreign");
    	this.PackageOrderDate=(String)map.get("PackageOrderDate");
    	this.InsuredAmount=(String)map.get("InsuredAmount");
    }
public Package() {
		// TODO Auto-generated constructor stub
	}
	//    public XmlDocument LoadPackageData(XmlDocument xmlDoc, String AccessToken)
//    public static class Builder {
//    	private Package instance;
//    	public Builder() {
//    		this.instance = new  Package();
//    	}
//    	public Builder setPackageId(String packageid) {
//    		instance.PackageId=packageid;
//    		return this;
//    	}
//    	public Builder setOderI(String orderid) {
//    		instance.OrderId=orderid;
//    		return this;
//    	}
//    	public Builder setPackageType(String packagetype) {
//    		instance.PackageType=packagetype;
//    		return this;
//    	}
//    	public Builder setPackageWeight(double packageweight) {
//    		instance.PackageWeight=packageweight;
//    		return this;
//    	}
//    	public Builder set
//    }
    public SOAPMessage GetPackageLabels() throws SOAPException, IOException {
    	
    	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
		SOAPElement soapBodyElem=soapBody.addChildElement("GetPackageLabels","", Utility.NamespaceUrl);
		SOAPElement soapBodyElem1=soapBodyElem.addChildElement("PackageId");
		SOAPElement soapBodyElem2=soapBodyElem.addChildElement("MailingAgentID");
		SOAPElement soapBodyElem3=soapBodyElem.addChildElement("BoxNumber");
		SOAPElement soapBodyElem4=soapBodyElem.addChildElement("FileFormat");
		SOAPElement soapBodyElem5=soapBodyElem.addChildElement("AccessToken");
		soapBodyElem1.addTextNode(this.PackageId);
		soapBodyElem2.addTextNode(this.MailingAgentID);
		soapBodyElem3.addTextNode(this.BoxNUmber);
		soapBodyElem4.addTextNode(this.FileFormat);
		Token token=new Token();
		soapBodyElem5.addTextNode(token.getAccess_token());
		SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
		return soapResponse;
    }
    public void AddPackageInReceptacle() throws SOAPException {
    	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
    	
    	
    }
    public void Calculate_postage() throws SOAPException {
    	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/GetPackageLabels";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody();
    	
    }
    public  SOAPMessage LoadAndRecordLabeledPackage(String xmlString,String token) throws SOAPException, IOException {
    	
    	String soapAction="http://www.usps-cpas.com/usps-cpas/GSSAPI/LoadAndRecordLabeledPackage";
    	MessageFactory messageFactory=MessageFactory.newInstance();
		SOAPMessage soapMessage=messageFactory.createMessage();
		SOAPBody soapBody=Utility.createSoapEnvelope(soapMessage).getBody(); 
		SOAPElement soapElement=soapBody.addChildElement("LoadAndRecordLabeledPackage", "", Utility.NamespaceUrl);
		SOAPElement soapElement1=soapElement.addChildElement("xmlDoc");
		SOAPElement soapElement2=soapElement.addChildElement("AccessToken");
		soapElement1.addTextNode(xmlString );
		soapElement2.addTextNode(token);
		
		
		SOAPMessage soapResponse=Utility.callUspsApiService(Utility.soapEndPointUrl, soapAction, soapMessage);
		return soapResponse;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
