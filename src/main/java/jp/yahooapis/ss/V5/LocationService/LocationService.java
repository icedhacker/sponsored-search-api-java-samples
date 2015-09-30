
package jp.yahooapis.ss.V5.LocationService;

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
@WebServiceClient(name = "LocationService", targetNamespace = "http://ss.yahooapis.jp/V5", wsdlLocation = "https://sandbox.ss.yahooapis.jp/services/V5.2/LocationService?wsdl")
public class LocationService
    extends Service
{

    private final static URL LOCATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException LOCATIONSERVICE_EXCEPTION;
    private final static QName LOCATIONSERVICE_QNAME = new QName("http://ss.yahooapis.jp/V5", "LocationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sandbox.ss.yahooapis.jp/services/V5.2/LocationService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOCATIONSERVICE_WSDL_LOCATION = url;
        LOCATIONSERVICE_EXCEPTION = e;
    }

    public LocationService() {
        super(__getWsdlLocation(), LOCATIONSERVICE_QNAME);
    }

    public LocationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LOCATIONSERVICE_QNAME, features);
    }

    public LocationService(URL wsdlLocation) {
        super(wsdlLocation, LOCATIONSERVICE_QNAME);
    }

    public LocationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LOCATIONSERVICE_QNAME, features);
    }

    public LocationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LocationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LocationServiceInterface
     */
    @WebEndpoint(name = "LocationService")
    public LocationServiceInterface getLocationService() {
        return super.getPort(new QName("http://ss.yahooapis.jp/V5", "LocationService"), LocationServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LocationServiceInterface
     */
    @WebEndpoint(name = "LocationService")
    public LocationServiceInterface getLocationService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ss.yahooapis.jp/V5", "LocationService"), LocationServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LOCATIONSERVICE_EXCEPTION!= null) {
            throw LOCATIONSERVICE_EXCEPTION;
        }
        return LOCATIONSERVICE_WSDL_LOCATION;
    }

}
