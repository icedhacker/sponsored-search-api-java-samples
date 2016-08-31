
package jp.yahooapis.ss.V6.AdGroupCriterionService;

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
@WebServiceClient(name = "AdGroupCriterionService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.1/AdGroupCriterionService?wsdl")
public class AdGroupCriterionService
    extends Service
{

    private final static URL ADGROUPCRITERIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPCRITERIONSERVICE_EXCEPTION;
    private final static QName ADGROUPCRITERIONSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "AdGroupCriterionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.1/AdGroupCriterionService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPCRITERIONSERVICE_WSDL_LOCATION = url;
        ADGROUPCRITERIONSERVICE_EXCEPTION = e;
    }

    public AdGroupCriterionService() {
        super(__getWsdlLocation(), ADGROUPCRITERIONSERVICE_QNAME);
    }

    public AdGroupCriterionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPCRITERIONSERVICE_QNAME, features);
    }

    public AdGroupCriterionService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPCRITERIONSERVICE_QNAME);
    }

    public AdGroupCriterionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPCRITERIONSERVICE_QNAME, features);
    }

    public AdGroupCriterionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupCriterionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupCriterionServiceInterface
     */
    @WebEndpoint(name = "AdGroupCriterionService")
    public AdGroupCriterionServiceInterface getAdGroupCriterionService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AdGroupCriterionService"), AdGroupCriterionServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupCriterionServiceInterface
     */
    @WebEndpoint(name = "AdGroupCriterionService")
    public AdGroupCriterionServiceInterface getAdGroupCriterionService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AdGroupCriterionService"), AdGroupCriterionServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPCRITERIONSERVICE_EXCEPTION!= null) {
            throw ADGROUPCRITERIONSERVICE_EXCEPTION;
        }
        return ADGROUPCRITERIONSERVICE_WSDL_LOCATION;
    }

}
