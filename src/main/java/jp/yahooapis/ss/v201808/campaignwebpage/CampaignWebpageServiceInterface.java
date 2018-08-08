
package jp.yahooapis.ss.v201808.campaignwebpage;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import jp.yahooapis.ss.v201808.Error;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CampaignWebpageServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage")
@XmlSeeAlso({
    jp.yahooapis.ss.v201808.ObjectFactory.class,
    jp.yahooapis.ss.v201808.campaignwebpage.ObjectFactory.class
})
public interface CampaignWebpageServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", className = "jp.yahooapis.ss.v201808.campaignwebpage.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", className = "jp.yahooapis.ss.v201808.campaignwebpage.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage")
        CampaignWebpageSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", mode = WebParam.Mode.OUT)
        Holder<CampaignWebpagePage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param operations
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", className = "jp.yahooapis.ss.v201808.campaignwebpage.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", className = "jp.yahooapis.ss.v201808.campaignwebpage.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage")
        CampaignWebpageOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", mode = WebParam.Mode.OUT)
        Holder<CampaignWebpageReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201808/CampaignWebpage", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
