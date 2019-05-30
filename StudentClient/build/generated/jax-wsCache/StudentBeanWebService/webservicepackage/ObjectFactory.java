
package webservicepackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservicepackage package. 
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

    private final static QName _PlusStudent_QNAME = new QName("http://WebServicePackage/", "plusStudent");
    private final static QName _GetStudentListResponse_QNAME = new QName("http://WebServicePackage/", "getStudentListResponse");
    private final static QName _SetStudentList_QNAME = new QName("http://WebServicePackage/", "setStudentList");
    private final static QName _CreateStudent_QNAME = new QName("http://WebServicePackage/", "createStudent");
    private final static QName _PlusStudentResponse_QNAME = new QName("http://WebServicePackage/", "plusStudentResponse");
    private final static QName _GetStudentList_QNAME = new QName("http://WebServicePackage/", "getStudentList");
    private final static QName _CreateStudentResponse_QNAME = new QName("http://WebServicePackage/", "createStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservicepackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateStudentResponse }
     * 
     */
    public CreateStudentResponse createCreateStudentResponse() {
        return new CreateStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentList }
     * 
     */
    public GetStudentList createGetStudentList() {
        return new GetStudentList();
    }

    /**
     * Create an instance of {@link PlusStudentResponse }
     * 
     */
    public PlusStudentResponse createPlusStudentResponse() {
        return new PlusStudentResponse();
    }

    /**
     * Create an instance of {@link CreateStudent }
     * 
     */
    public CreateStudent createCreateStudent() {
        return new CreateStudent();
    }

    /**
     * Create an instance of {@link SetStudentList }
     * 
     */
    public SetStudentList createSetStudentList() {
        return new SetStudentList();
    }

    /**
     * Create an instance of {@link GetStudentListResponse }
     * 
     */
    public GetStudentListResponse createGetStudentListResponse() {
        return new GetStudentListResponse();
    }

    /**
     * Create an instance of {@link PlusStudent }
     * 
     */
    public PlusStudent createPlusStudent() {
        return new PlusStudent();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlusStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "plusStudent")
    public JAXBElement<PlusStudent> createPlusStudent(PlusStudent value) {
        return new JAXBElement<PlusStudent>(_PlusStudent_QNAME, PlusStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getStudentListResponse")
    public JAXBElement<GetStudentListResponse> createGetStudentListResponse(GetStudentListResponse value) {
        return new JAXBElement<GetStudentListResponse>(_GetStudentListResponse_QNAME, GetStudentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "setStudentList")
    public JAXBElement<SetStudentList> createSetStudentList(SetStudentList value) {
        return new JAXBElement<SetStudentList>(_SetStudentList_QNAME, SetStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "createStudent")
    public JAXBElement<CreateStudent> createCreateStudent(CreateStudent value) {
        return new JAXBElement<CreateStudent>(_CreateStudent_QNAME, CreateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlusStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "plusStudentResponse")
    public JAXBElement<PlusStudentResponse> createPlusStudentResponse(PlusStudentResponse value) {
        return new JAXBElement<PlusStudentResponse>(_PlusStudentResponse_QNAME, PlusStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "getStudentList")
    public JAXBElement<GetStudentList> createGetStudentList(GetStudentList value) {
        return new JAXBElement<GetStudentList>(_GetStudentList_QNAME, GetStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "createStudentResponse")
    public JAXBElement<CreateStudentResponse> createCreateStudentResponse(CreateStudentResponse value) {
        return new JAXBElement<CreateStudentResponse>(_CreateStudentResponse_QNAME, CreateStudentResponse.class, null, value);
    }

}
