
package jp.yahooapis.ss.v201901.accounttrackingurl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201901.SoapHeader;
import jp.yahooapis.ss.v201901.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201901.accounttrackingurl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/AccountTrackingUrl", "ResponseHeader");
    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/AccountTrackingUrl", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201901/AccountTrackingUrl", "ApiExceptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201901.accounttrackingurl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mutate }
     * 
     */
    public Mutate createMutate() {
        return new Mutate();
    }

    /**
     * Create an instance of {@link AccountTrackingUrlOperation }
     * 
     */
    public AccountTrackingUrlOperation createAccountTrackingUrlOperation() {
        return new AccountTrackingUrlOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AccountTrackingUrlPage }
     * 
     */
    public AccountTrackingUrlPage createAccountTrackingUrlPage() {
        return new AccountTrackingUrlPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AccountTrackingUrlSelector }
     * 
     */
    public AccountTrackingUrlSelector createAccountTrackingUrlSelector() {
        return new AccountTrackingUrlSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AccountTrackingUrlReturnValue }
     * 
     */
    public AccountTrackingUrlReturnValue createAccountTrackingUrlReturnValue() {
        return new AccountTrackingUrlReturnValue();
    }

    /**
     * Create an instance of {@link AccountTrackingUrlValues }
     * 
     */
    public AccountTrackingUrlValues createAccountTrackingUrlValues() {
        return new AccountTrackingUrlValues();
    }

    /**
     * Create an instance of {@link AccountTrackingUrl }
     * 
     */
    public AccountTrackingUrl createAccountTrackingUrl() {
        return new AccountTrackingUrl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AccountTrackingUrl", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AccountTrackingUrl", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AccountTrackingUrl", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

}
