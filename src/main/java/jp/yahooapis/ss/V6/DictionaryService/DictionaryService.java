
package jp.yahooapis.ss.V6.DictionaryService;

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
@WebServiceClient(name = "DictionaryService", targetNamespace = "http://ss.yahooapis.jp/V6", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V6.3/DictionaryService?wsdl")
public class DictionaryService
    extends Service
{

    private final static URL DICTIONARYSERVICE_WSDL_LOCATION;
    private final static WebServiceException DICTIONARYSERVICE_EXCEPTION;
    private final static QName DICTIONARYSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V6", "DictionaryService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V6.3/DictionaryService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DICTIONARYSERVICE_WSDL_LOCATION = url;
        DICTIONARYSERVICE_EXCEPTION = e;
    }

    public DictionaryService() {
        super(__getWsdlLocation(), DICTIONARYSERVICE_QNAME);
    }

    public DictionaryService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DICTIONARYSERVICE_QNAME, features);
    }

    public DictionaryService(URL wsdlLocation) {
        super(wsdlLocation, DICTIONARYSERVICE_QNAME);
    }

    public DictionaryService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DICTIONARYSERVICE_QNAME, features);
    }

    public DictionaryService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DictionaryService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DictionaryServiceInterface
     */
    @WebEndpoint(name = "DictionaryService")
    public DictionaryServiceInterface getDictionaryService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "DictionaryService"), DictionaryServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DictionaryServiceInterface
     */
    @WebEndpoint(name = "DictionaryService")
    public DictionaryServiceInterface getDictionaryService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V6", "DictionaryService"), DictionaryServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DICTIONARYSERVICE_EXCEPTION!= null) {
            throw DICTIONARYSERVICE_EXCEPTION;
        }
        return DICTIONARYSERVICE_WSDL_LOCATION;
    }

}
