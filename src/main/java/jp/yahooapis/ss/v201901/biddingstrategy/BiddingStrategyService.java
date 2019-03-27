
package jp.yahooapis.ss.v201901.biddingstrategy;

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
@WebServiceClient(name = "BiddingStrategyService", targetNamespace = "http://ss.yahooapis.jp/V201901/BiddingStrategy", wsdlLocation = "https://ss.yahooapis.jp/services/V201901/BiddingStrategyService?wsdl")
public class BiddingStrategyService
    extends Service
{

    private final static URL BIDDINGSTRATEGYSERVICE_WSDL_LOCATION;
    private final static WebServiceException BIDDINGSTRATEGYSERVICE_EXCEPTION;
    private final static QName BIDDINGSTRATEGYSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201901/BiddingStrategy", "BiddingStrategyService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ss.yahooapis.jp/services/V201901/BiddingStrategyService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BIDDINGSTRATEGYSERVICE_WSDL_LOCATION = url;
        BIDDINGSTRATEGYSERVICE_EXCEPTION = e;
    }

    public BiddingStrategyService() {
        super(__getWsdlLocation(), BIDDINGSTRATEGYSERVICE_QNAME);
    }

    public BiddingStrategyService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BIDDINGSTRATEGYSERVICE_QNAME, features);
    }

    public BiddingStrategyService(URL wsdlLocation) {
        super(wsdlLocation, BIDDINGSTRATEGYSERVICE_QNAME);
    }

    public BiddingStrategyService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BIDDINGSTRATEGYSERVICE_QNAME, features);
    }

    public BiddingStrategyService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BiddingStrategyService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BiddingStrategyServiceInterface
     */
    @WebEndpoint(name = "BiddingStrategyService")
    public BiddingStrategyServiceInterface getBiddingStrategyService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/BiddingStrategy", "BiddingStrategyService"), BiddingStrategyServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BiddingStrategyServiceInterface
     */
    @WebEndpoint(name = "BiddingStrategyService")
    public BiddingStrategyServiceInterface getBiddingStrategyService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/BiddingStrategy", "BiddingStrategyService"), BiddingStrategyServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BIDDINGSTRATEGYSERVICE_EXCEPTION!= null) {
            throw BIDDINGSTRATEGYSERVICE_EXCEPTION;
        }
        return BIDDINGSTRATEGYSERVICE_WSDL_LOCATION;
    }

}
