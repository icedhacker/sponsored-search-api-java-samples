
package jp.yahooapis.ss.V6.AdGroupFeedService;

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
@WebServiceClient(name = "AdGroupFeedService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.0/AdGroupFeedService?wsdl")
public class AdGroupFeedService
    extends Service
{

    private final static URL ADGROUPFEEDSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADGROUPFEEDSERVICE_EXCEPTION;
    private final static QName ADGROUPFEEDSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "AdGroupFeedService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.0/AdGroupFeedService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADGROUPFEEDSERVICE_WSDL_LOCATION = url;
        ADGROUPFEEDSERVICE_EXCEPTION = e;
    }

    public AdGroupFeedService() {
        super(__getWsdlLocation(), ADGROUPFEEDSERVICE_QNAME);
    }

    public AdGroupFeedService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADGROUPFEEDSERVICE_QNAME, features);
    }

    public AdGroupFeedService(URL wsdlLocation) {
        super(wsdlLocation, ADGROUPFEEDSERVICE_QNAME);
    }

    public AdGroupFeedService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADGROUPFEEDSERVICE_QNAME, features);
    }

    public AdGroupFeedService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupFeedService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdGroupFeedServiceInterface
     */
    @WebEndpoint(name = "AdGroupFeedService")
    public AdGroupFeedServiceInterface getAdGroupFeedService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AdGroupFeedService"), AdGroupFeedServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupFeedServiceInterface
     */
    @WebEndpoint(name = "AdGroupFeedService")
    public AdGroupFeedServiceInterface getAdGroupFeedService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "AdGroupFeedService"), AdGroupFeedServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADGROUPFEEDSERVICE_EXCEPTION!= null) {
            throw ADGROUPFEEDSERVICE_EXCEPTION;
        }
        return ADGROUPFEEDSERVICE_WSDL_LOCATION;
    }

}
