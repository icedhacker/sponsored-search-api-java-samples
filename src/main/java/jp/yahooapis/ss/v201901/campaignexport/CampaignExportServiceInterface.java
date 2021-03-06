
package jp.yahooapis.ss.v201901.campaignexport;

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
@WebService(name = "CampaignExportServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport")
@XmlSeeAlso({
    jp.yahooapis.ss.v201901.ObjectFactory.class,
    jp.yahooapis.ss.v201901.campaignexport.ObjectFactory.class
})
public interface CampaignExportServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", className = "jp.yahooapis.ss.v201901.campaignexport.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", className = "jp.yahooapis.ss.v201901.campaignexport.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport")
        JobSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", mode = WebParam.Mode.OUT)
        Holder<CampaignExportPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param rval
     * @param error
     * @param setting
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "addJob", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", className = "jp.yahooapis.ss.v201901.campaignexport.AddJob")
    @ResponseWrapper(localName = "addJobResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", className = "jp.yahooapis.ss.v201901.campaignexport.AddJobResponse")
    public void addJob(
        @WebParam(name = "setting", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport")
        ExportSetting setting,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", mode = WebParam.Mode.OUT)
        Holder<CampaignExportReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getExportFields", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", className = "jp.yahooapis.ss.v201901.campaignexport.GetExportFields")
    @ResponseWrapper(localName = "getExportFieldsResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", className = "jp.yahooapis.ss.v201901.campaignexport.GetExportFieldsResponse")
    public void getExportFields(
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", mode = WebParam.Mode.OUT)
        Holder<CampaignExportFieldValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/CampaignExport", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
