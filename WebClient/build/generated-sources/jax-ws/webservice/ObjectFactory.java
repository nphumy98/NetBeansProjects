
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
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

    private final static QName _GetCustomerList_QNAME = new QName("http://WebService/", "getCustomerList");
    private final static QName _CreateCustomerResponse_QNAME = new QName("http://WebService/", "createCustomerResponse");
    private final static QName _AddCustomerResponse_QNAME = new QName("http://WebService/", "addCustomerResponse");
    private final static QName _PlusCustomer_QNAME = new QName("http://WebService/", "plusCustomer");
    private final static QName _CreateCustomer_QNAME = new QName("http://WebService/", "createCustomer");
    private final static QName _PlusCustomerResponse_QNAME = new QName("http://WebService/", "plusCustomerResponse");
    private final static QName _GetCustomerListResponse_QNAME = new QName("http://WebService/", "getCustomerListResponse");
    private final static QName _AddCustomer_QNAME = new QName("http://WebService/", "addCustomer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCustomer }
     * 
     */
    public AddCustomer createAddCustomer() {
        return new AddCustomer();
    }

    /**
     * Create an instance of {@link GetCustomerListResponse }
     * 
     */
    public GetCustomerListResponse createGetCustomerListResponse() {
        return new GetCustomerListResponse();
    }

    /**
     * Create an instance of {@link PlusCustomerResponse }
     * 
     */
    public PlusCustomerResponse createPlusCustomerResponse() {
        return new PlusCustomerResponse();
    }

    /**
     * Create an instance of {@link CreateCustomer }
     * 
     */
    public CreateCustomer createCreateCustomer() {
        return new CreateCustomer();
    }

    /**
     * Create an instance of {@link AddCustomerResponse }
     * 
     */
    public AddCustomerResponse createAddCustomerResponse() {
        return new AddCustomerResponse();
    }

    /**
     * Create an instance of {@link PlusCustomer }
     * 
     */
    public PlusCustomer createPlusCustomer() {
        return new PlusCustomer();
    }

    /**
     * Create an instance of {@link CreateCustomerResponse }
     * 
     */
    public CreateCustomerResponse createCreateCustomerResponse() {
        return new CreateCustomerResponse();
    }

    /**
     * Create an instance of {@link GetCustomerList }
     * 
     */
    public GetCustomerList createGetCustomerList() {
        return new GetCustomerList();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getCustomerList")
    public JAXBElement<GetCustomerList> createGetCustomerList(GetCustomerList value) {
        return new JAXBElement<GetCustomerList>(_GetCustomerList_QNAME, GetCustomerList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "createCustomerResponse")
    public JAXBElement<CreateCustomerResponse> createCreateCustomerResponse(CreateCustomerResponse value) {
        return new JAXBElement<CreateCustomerResponse>(_CreateCustomerResponse_QNAME, CreateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "addCustomerResponse")
    public JAXBElement<AddCustomerResponse> createAddCustomerResponse(AddCustomerResponse value) {
        return new JAXBElement<AddCustomerResponse>(_AddCustomerResponse_QNAME, AddCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlusCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "plusCustomer")
    public JAXBElement<PlusCustomer> createPlusCustomer(PlusCustomer value) {
        return new JAXBElement<PlusCustomer>(_PlusCustomer_QNAME, PlusCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "createCustomer")
    public JAXBElement<CreateCustomer> createCreateCustomer(CreateCustomer value) {
        return new JAXBElement<CreateCustomer>(_CreateCustomer_QNAME, CreateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlusCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "plusCustomerResponse")
    public JAXBElement<PlusCustomerResponse> createPlusCustomerResponse(PlusCustomerResponse value) {
        return new JAXBElement<PlusCustomerResponse>(_PlusCustomerResponse_QNAME, PlusCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getCustomerListResponse")
    public JAXBElement<GetCustomerListResponse> createGetCustomerListResponse(GetCustomerListResponse value) {
        return new JAXBElement<GetCustomerListResponse>(_GetCustomerListResponse_QNAME, GetCustomerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "addCustomer")
    public JAXBElement<AddCustomer> createAddCustomer(AddCustomer value) {
        return new JAXBElement<AddCustomer>(_AddCustomer_QNAME, AddCustomer.class, null, value);
    }

}
