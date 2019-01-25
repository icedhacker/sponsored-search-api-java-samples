
package jp.yahooapis.ss.v201901.reportdefinition;

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
@WebService(name = "ReportDefinitionServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition")
@XmlSeeAlso({
    jp.yahooapis.ss.v201901.ObjectFactory.class,
    jp.yahooapis.ss.v201901.reportdefinition.ObjectFactory.class
})
public interface ReportDefinitionServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", className = "jp.yahooapis.ss.v201901.reportdefinition.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", className = "jp.yahooapis.ss.v201901.reportdefinition.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition")
        ReportDefinitionSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", mode = WebParam.Mode.OUT)
        Holder<ReportDefinitionPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", className = "jp.yahooapis.ss.v201901.reportdefinition.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", className = "jp.yahooapis.ss.v201901.reportdefinition.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition")
        ReportDefinitionOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", mode = WebParam.Mode.OUT)
        Holder<ReportDefinitionReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param reportType
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getReportFields", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", className = "jp.yahooapis.ss.v201901.reportdefinition.GetReportFields")
    @ResponseWrapper(localName = "getReportFieldsResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", className = "jp.yahooapis.ss.v201901.reportdefinition.GetReportFieldsResponse")
    public void getReportFields(
        @WebParam(name = "reportType", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition")
        ReportType reportType,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", mode = WebParam.Mode.OUT)
        Holder<ReportDefinitionFieldValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/ReportDefinition", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}