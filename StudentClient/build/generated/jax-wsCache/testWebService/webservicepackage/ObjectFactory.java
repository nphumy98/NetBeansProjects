
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

    private final static QName _Exception_QNAME = new QName("http://WebServicePackage/", "Exception");
    private final static QName _MakeStudentResponse_QNAME = new QName("http://WebServicePackage/", "makeStudentResponse");
    private final static QName _AddStudentResponse_QNAME = new QName("http://WebServicePackage/", "addStudentResponse");
    private final static QName _InitList_QNAME = new QName("http://WebServicePackage/", "initList");
    private final static QName _AddStudent_QNAME = new QName("http://WebServicePackage/", "addStudent");
    private final static QName _InitListResponse_QNAME = new QName("http://WebServicePackage/", "initListResponse");
    private final static QName _MakeStudent_QNAME = new QName("http://WebServicePackage/", "makeStudent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservicepackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link InitListResponse }
     * 
     */
    public InitListResponse createInitListResponse() {
        return new InitListResponse();
    }

    /**
     * Create an instance of {@link MakeStudent }
     * 
     */
    public MakeStudent createMakeStudent() {
        return new MakeStudent();
    }

    /**
     * Create an instance of {@link InitList }
     * 
     */
    public InitList createInitList() {
        return new InitList();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link MakeStudentResponse }
     * 
     */
    public MakeStudentResponse createMakeStudentResponse() {
        return new MakeStudentResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "makeStudentResponse")
    public JAXBElement<MakeStudentResponse> createMakeStudentResponse(MakeStudentResponse value) {
        return new JAXBElement<MakeStudentResponse>(_MakeStudentResponse_QNAME, MakeStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "initList")
    public JAXBElement<InitList> createInitList(InitList value) {
        return new JAXBElement<InitList>(_InitList_QNAME, InitList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "initListResponse")
    public JAXBElement<InitListResponse> createInitListResponse(InitListResponse value) {
        return new JAXBElement<InitListResponse>(_InitListResponse_QNAME, InitListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServicePackage/", name = "makeStudent")
    public JAXBElement<MakeStudent> createMakeStudent(MakeStudent value) {
        return new JAXBElement<MakeStudent>(_MakeStudent_QNAME, MakeStudent.class, null, value);
    }

}
