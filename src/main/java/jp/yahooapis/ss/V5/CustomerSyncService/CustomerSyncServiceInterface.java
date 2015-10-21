
package jp.yahooapis.ss.V5.CustomerSyncService;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerSyncServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V5")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerSyncServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V5", className = "jp.yahooapis.ss.V5.CustomerSyncService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V5", className = "jp.yahooapis.ss.V5.CustomerSyncService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V5")
        CustomerSyncSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<CustomerChangeData> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V5", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
