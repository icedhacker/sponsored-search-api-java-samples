
package jp.yahooapis.ss.V5.FeedItemService;

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
@WebServiceClient(name = "FeedItemService", targetNamespace = "http://ss.yahooapis.jp/V5", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V5.2/FeedItemService?wsdl")
public class FeedItemService
    extends Service
{

    private final static URL FEEDITEMSERVICE_WSDL_LOCATION;
    private final static WebServiceException FEEDITEMSERVICE_EXCEPTION;
    private final static QName FEEDITEMSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V5", "FeedItemService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V5.2/FeedItemService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FEEDITEMSERVICE_WSDL_LOCATION = url;
        FEEDITEMSERVICE_EXCEPTION = e;
    }

    public FeedItemService() {
        super(__getWsdlLocation(), FEEDITEMSERVICE_QNAME);
    }

    public FeedItemService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FEEDITEMSERVICE_QNAME, features);
    }

    public FeedItemService(URL wsdlLocation) {
        super(wsdlLocation, FEEDITEMSERVICE_QNAME);
    }

    public FeedItemService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FEEDITEMSERVICE_QNAME, features);
    }

    public FeedItemService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FeedItemService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FeedItemServiceInterface
     */
    @WebEndpoint(name = "FeedItemService")
    public FeedItemServiceInterface getFeedItemService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V5", "FeedItemService"), FeedItemServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FeedItemServiceInterface
     */
    @WebEndpoint(name = "FeedItemService")
    public FeedItemServiceInterface getFeedItemService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V5", "FeedItemService"), FeedItemServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FEEDITEMSERVICE_EXCEPTION!= null) {
            throw FEEDITEMSERVICE_EXCEPTION;
        }
        return FEEDITEMSERVICE_WSDL_LOCATION;
    }

}
