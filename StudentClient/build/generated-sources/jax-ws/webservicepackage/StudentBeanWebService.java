
package webservicepackage;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentBeanWebService", targetNamespace = "http://WebServicePackage/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentBeanWebService {


    /**
     * 
     * @param name
     * @return
     *     returns webservicepackage.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createStudent", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.CreateStudent")
    @ResponseWrapper(localName = "createStudentResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.CreateStudentResponse")
    @Action(input = "http://WebServicePackage/StudentBeanWebService/createStudentRequest", output = "http://WebServicePackage/StudentBeanWebService/createStudentResponse")
    public Student createStudent(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param name
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "plusStudent", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.PlusStudent")
    @ResponseWrapper(localName = "plusStudentResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.PlusStudentResponse")
    @Action(input = "http://WebServicePackage/StudentBeanWebService/plusStudentRequest", output = "http://WebServicePackage/StudentBeanWebService/plusStudentResponse")
    public int plusStudent(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @return
     *     returns java.util.List<webservicepackage.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentList", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentList")
    @ResponseWrapper(localName = "getStudentListResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentListResponse")
    @Action(input = "http://WebServicePackage/StudentBeanWebService/getStudentListRequest", output = "http://WebServicePackage/StudentBeanWebService/getStudentListResponse")
    public List<Student> getStudentList();

    /**
     * 
     * @param studentList
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "setStudentList", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.SetStudentList")
    @Action(input = "http://WebServicePackage/StudentBeanWebService/setStudentList")
    public void setStudentList(
        @WebParam(name = "studentList", targetNamespace = "")
        List<Student> studentList);

}