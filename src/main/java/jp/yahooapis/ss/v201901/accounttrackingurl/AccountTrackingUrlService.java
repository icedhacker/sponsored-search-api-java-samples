
package jp.yahooapis.ss.v201901.accounttrackingurl;

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
@WebServiceClient(name = "AccountTrackingUrlService", targetNamespace = "http://ss.yahooapis.jp/V201901/AccountTrackingUrl", wsdlLocation = "https://ss.yahooapis.jp/services/V201901/AccountTrackingURLService?wsdl")
public class AccountTrackingUrlService
    extends Service
{

    private final static URL ACCOUNTTRACKINGURLSERVICE_WSDL_LOCATION;
    private final static WebServiceException ACCOUNTTRACKINGURLSERVICE_EXCEPTION;
    private final static QName ACCOUNTTRACKINGURLSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V201901/AccountTrackingUrl", "AccountTrackingUrlService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ss.yahooapis.jp/services/V201901/AccountTrackingURLService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCOUNTTRACKINGURLSERVICE_WSDL_LOCATION = url;
        ACCOUNTTRACKINGURLSERVICE_EXCEPTION = e;
    }

    public AccountTrackingUrlService() {
        super(__getWsdlLocation(), ACCOUNTTRACKINGURLSERVICE_QNAME);
    }

    public AccountTrackingUrlService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCOUNTTRACKINGURLSERVICE_QNAME, features);
    }

    public AccountTrackingUrlService(URL wsdlLocation) {
        super(wsdlLocation, ACCOUNTTRACKINGURLSERVICE_QNAME);
    }

    public AccountTrackingUrlService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCOUNTTRACKINGURLSERVICE_QNAME, features);
    }

    public AccountTrackingUrlService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountTrackingUrlService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AccountTrackingUrlServiceInterface
     */
    @WebEndpoint(name = "AccountTrackingUrlService")
    public AccountTrackingUrlServiceInterface getAccountTrackingUrlService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/AccountTrackingUrl", "AccountTrackingUrlService"), AccountTrackingUrlServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountTrackingUrlServiceInterface
     */
    @WebEndpoint(name = "AccountTrackingUrlService")
    public AccountTrackingUrlServiceInterface getAccountTrackingUrlService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V201901/AccountTrackingUrl", "AccountTrackingUrlService"), AccountTrackingUrlServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCOUNTTRACKINGURLSERVICE_EXCEPTION!= null) {
            throw ACCOUNTTRACKINGURLSERVICE_EXCEPTION;
        }
        return ACCOUNTTRACKINGURLSERVICE_WSDL_LOCATION;
    }

}
