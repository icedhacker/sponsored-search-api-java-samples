
package jp.yahooapis.ss.v201901.auditlog;

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
@WebService(name = "AuditLogServiceInterface", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog")
@XmlSeeAlso({
    jp.yahooapis.ss.v201901.ObjectFactory.class,
    jp.yahooapis.ss.v201901.auditlog.ObjectFactory.class
})
public interface AuditLogServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", className = "jp.yahooapis.ss.v201901.auditlog.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", className = "jp.yahooapis.ss.v201901.auditlog.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog")
        AuditLogSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", mode = WebParam.Mode.OUT)
        Holder<AuditLogPage> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", mode = WebParam.Mode.OUT)
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
    @RequestWrapper(localName = "addJob", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", className = "jp.yahooapis.ss.v201901.auditlog.AddJob")
    @ResponseWrapper(localName = "addJobResponse", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", className = "jp.yahooapis.ss.v201901.auditlog.AddJobResponse")
    public void addJob(
        @WebParam(name = "operations", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog")
        AuditLogOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", mode = WebParam.Mode.OUT)
        Holder<AuditLogReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://ss.yahooapis.jp/V201901/AuditLog", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}