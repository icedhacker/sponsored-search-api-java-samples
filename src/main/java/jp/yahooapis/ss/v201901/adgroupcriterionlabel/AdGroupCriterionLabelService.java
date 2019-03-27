
package jp.yahooapis.ss.v201901.adgroupcriterionlabel;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AdGroupCriterionLabelService", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupCriterionLabel", wsdlLocation = "https://ss.yahooapis.jp/services/V201901/AdGroupCriterionLabelService?wsdl")
public class AdGroupCriterionLabelService
    extends Service
{

    private final static URL ADGROUPCRITERIONLABELSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPCRITERIONLABELSERVICE_EXCEPTION;
    private final static QName ADGROUPCRITERIONLABELSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupCriterionLabel", "AdGroupCriterionLabelService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ss.yahooapis.jp/services/V201901/AdGroupCriterionLabelService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPCRITERIONLABELSERVICE_WSDL_LOCATION = url;
        ADGROUPCRITERIONLABELSERVICE_EXCEPTION = e;
    }

    public AdGroupCriterionLabelService() {
        super(__getWsdlLocation(), ADGROUPCRITERIONLABELSERVICE_QNAME);
    }

    public AdGroupCriterionLabelService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPCRITERIONLABELSERVICE_QNAME, features);
    }

    public AdGroupCriterionLabelService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPCRITERIONLABELSERVICE_QNAME);
    }

    public AdGroupCriterionLabelService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPCRITERIONLABELSERVICE_QNAME, features);
    }

    public AdGroupCriterionLabelService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupCriterionLabelService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupCriterionLabelServiceInterface
     */
    @WebEndpoint(name = "AdGroupCriterionLabelService")
    public AdGroupCriterionLabelServiceInterface getAdGroupCriterionLabelService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/AdGroupCriterionLabel", "AdGroupCriterionLabelService"), AdGroupCriterionLabelServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupCriterionLabelServiceInterface
     */
    @WebEndpoint(name = "AdGroupCriterionLabelService")
    public AdGroupCriterionLabelServiceInterface getAdGroupCriterionLabelService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/AdGroupCriterionLabel", "AdGroupCriterionLabelService"), AdGroupCriterionLabelServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPCRITERIONLABELSERVICE_EXCEPTION!= null) {
            throw ADGROUPCRITERIONLABELSERVICE_EXCEPTION;
        }
        return ADGROUPCRITERIONLABELSERVICE_WSDL_LOCATION;
    }

}
