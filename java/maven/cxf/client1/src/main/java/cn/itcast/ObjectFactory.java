
package cn.itcast;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.itcast package. 
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

    private final static QName _Info_QNAME = new QName("http://itcast.cn/", "info");
    private final static QName _InfoResponse_QNAME = new QName("http://itcast.cn/", "infoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.itcast
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InfoResponse }
     * 
     */
    public InfoResponse createInfoResponse() {
        return new InfoResponse();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Info }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itcast.cn/", name = "info")
    public JAXBElement<Info> createInfo(Info value) {
        return new JAXBElement<Info>(_Info_QNAME, Info.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itcast.cn/", name = "infoResponse")
    public JAXBElement<InfoResponse> createInfoResponse(InfoResponse value) {
        return new JAXBElement<InfoResponse>(_InfoResponse_QNAME, InfoResponse.class, null, value);
    }

}
