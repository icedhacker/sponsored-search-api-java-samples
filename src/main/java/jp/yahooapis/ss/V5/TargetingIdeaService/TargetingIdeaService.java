
package jp.yahooapis.ss.V5.TargetingIdeaService;

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
@WebServiceClient(name = "TargetingIdeaService", targetNamespace = "http://ss.yahooapis.jp/V5", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V5.2/TargetingIdeaService?wsdl")
public class TargetingIdeaService
    extends Service
{

    private final static URL TARGETINGIDEASERVICE_WSDL_LOCATION;
    private final static WebServiceException TARGETINGIDEASERVICE_EXCEPTION;
    private final static QName TARGETINGIDEASERVICE_QNAME = new QName("http://ss.yahooapis.jp/V5", "TargetingIdeaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V5.2/TargetingIdeaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TARGETINGIDEASERVICE_WSDL_LOCATION = url;
        TARGETINGIDEASERVICE_EXCEPTION = e;
    }

    public TargetingIdeaService() {
        super(__getWsdlLocation(), TARGETINGIDEASERVICE_QNAME);
    }

    public TargetingIdeaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TARGETINGIDEASERVICE_QNAME, features);
    }

    public TargetingIdeaService(URL wsdlLocation) {
        super(wsdlLocation, TARGETINGIDEASERVICE_QNAME);
    }

    public TargetingIdeaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TARGETINGIDEASERVICE_QNAME, features);
    }

    public TargetingIdeaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TargetingIdeaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TargetingIdeaServiceInterface
     */
    @WebEndpoint(name = "TargetingIdeaService")
    public TargetingIdeaServiceInterface getTargetingIdeaService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V5", "TargetingIdeaService"), TargetingIdeaServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TargetingIdeaServiceInterface
     */
    @WebEndpoint(name = "TargetingIdeaService")
    public TargetingIdeaServiceInterface getTargetingIdeaService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V5", "TargetingIdeaService"), TargetingIdeaServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TARGETINGIDEASERVICE_EXCEPTION!= null) {
            throw TARGETINGIDEASERVICE_EXCEPTION;
        }
        return TARGETINGIDEASERVICE_WSDL_LOCATION;
    }

}
