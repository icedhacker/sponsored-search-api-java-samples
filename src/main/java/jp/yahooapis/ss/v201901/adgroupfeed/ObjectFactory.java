
package jp.yahooapis.ss.v201901.adgroupfeed;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import jp.yahooapis.ss.v201901.SoapHeader;
import jp.yahooapis.ss.v201901.SoapResponseHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.ss.v201901.adgroupfeed package. 
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

    private final static QName _RequestHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupFeed", "RequestHeader");
    private final static QName _ApiExceptionFault_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupFeed", "ApiExceptionFault");
    private final static QName _ResponseHeader_QNAME = new QName("http://ss.yahooapis.jp/V201901/AdGroupFeed", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.ss.v201901.adgroupfeed
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
     * Create an instance of {@link AdGroupFeedOperation }
     * 
     */
    public AdGroupFeedOperation createAdGroupFeedOperation() {
        return new AdGroupFeedOperation();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link AdGroupFeedPage }
     * 
     */
    public AdGroupFeedPage createAdGroupFeedPage() {
        return new AdGroupFeedPage();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link AdGroupFeedSelector }
     * 
     */
    public AdGroupFeedSelector createAdGroupFeedSelector() {
        return new AdGroupFeedSelector();
    }

    /**
     * Create an instance of {@link MutateResponse }
     * 
     */
    public MutateResponse createMutateResponse() {
        return new MutateResponse();
    }

    /**
     * Create an instance of {@link AdGroupFeedReturnValue }
     * 
     */
    public AdGroupFeedReturnValue createAdGroupFeedReturnValue() {
        return new AdGroupFeedReturnValue();
    }

    /**
     * Create an instance of {@link AdGroupFeed }
     * 
     */
    public AdGroupFeed createAdGroupFeed() {
        return new AdGroupFeed();
    }

    /**
     * Create an instance of {@link AdGroupFeedValues }
     * 
     */
    public AdGroupFeedValues createAdGroupFeedValues() {
        return new AdGroupFeedValues();
    }

    /**
     * Create an instance of {@link AdGroupFeedList }
     * 
     */
    public AdGroupFeedList createAdGroupFeedList() {
        return new AdGroupFeedList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ss.yahooapis.jp/V201901/AdGroupFeed", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
