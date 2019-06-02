
package webservicepackage;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentWebService", targetNamespace = "http://WebServicePackage/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWebService {


    /**
     * 
     * @return
     *     returns java.util.List<webservicepackage.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentList", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentList")
    @ResponseWrapper(localName = "getStudentListResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.GetStudentListResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/getStudentListRequest", output = "http://WebServicePackage/StudentWebService/getStudentListResponse")
    public List<Student> getStudentList();

    /**
     * 
     * @return
     *     returns int
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "initList", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.InitList")
    @ResponseWrapper(localName = "initListResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.InitListResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/initListRequest", output = "http://WebServicePackage/StudentWebService/initListResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://WebServicePackage/StudentWebService/initList/Fault/Exception")
    })
    public int initList()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkPassword", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.CheckPassword")
    @ResponseWrapper(localName = "checkPasswordResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.CheckPasswordResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/checkPasswordRequest", output = "http://WebServicePackage/StudentWebService/checkPasswordResponse")
    public boolean checkPassword(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.AddStudentResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/addStudentRequest", output = "http://WebServicePackage/StudentWebService/addStudentResponse")
    public int addStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns webservicepackage.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "makeStudent", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.MakeStudent")
    @ResponseWrapper(localName = "makeStudentResponse", targetNamespace = "http://WebServicePackage/", className = "webservicepackage.MakeStudentResponse")
    @Action(input = "http://WebServicePackage/StudentWebService/makeStudentRequest", output = "http://WebServicePackage/StudentWebService/makeStudentResponse")
    public Student makeStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
