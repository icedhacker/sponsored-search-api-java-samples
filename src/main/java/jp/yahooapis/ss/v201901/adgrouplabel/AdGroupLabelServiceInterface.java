
package jp.yahooapis.ss.v201901.adgrouplabel;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.ss.v201901.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AdGroupLabelServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupLabel")
@XmlSeeAlso({
    jp.yahooapis.ss.v201901.ObjectFactory.class,
    jp.yahooapis.ss.v201901.adgrouplabel.ObjectFactory.class
})
public interface AdGroupLabelServiceInterface {


    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupLabel", className = "jp.yahooapis.ss.v201901.adgrouplabel.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupLabel", className = "jp.yahooapis.ss.v201901.adgrouplabel.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupLabel")
        AdGroupLabelOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupLabel", mode = WebParam.Mode.OUT)
        Holder<AdGroupLabelReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/AdGroupLabel", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
