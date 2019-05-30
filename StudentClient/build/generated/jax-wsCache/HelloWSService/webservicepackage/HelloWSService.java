
package webservicepackage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloWSService", targetNamespace = "http://WebServicePackage/", wsdlLocation = "http://localhost:8080/StudentServer/HelloWSService?wsdl")
public class HelloWSService
    extends Service
{

    private final static URL HELLOWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOWSSERVICE_EXCEPTION;
    private final static QName HELLOWSSERVICE_QNAME = new QName("http://WebServicePackage/", "HelloWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/StudentServer/HelloWSService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOWSSERVICE_WSDL_LOCATION = url;
        HELLOWSSERVICE_EXCEPTION = e;
    }

    public HelloWSService() {
        super(__getWsdlLocation(), HELLOWSSERVICE_QNAME);
    }

    public HelloWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOWSSERVICE_QNAME, features);
    }

    public HelloWSService(URL wsdlLocation) {
        super(wsdlLocation, HELLOWSSERVICE_QNAME);
    }

    public HelloWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOWSSERVICE_QNAME, features);
    }

    public HelloWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSPort")
    public HelloWS getHelloWSPort() {
        return super.getPort(new QName("http://WebServicePackage/", "HelloWSPort"), HelloWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSPort")
    public HelloWS getHelloWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebServicePackage/", "HelloWSPort"), HelloWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOWSSERVICE_EXCEPTION!= null) {
            throw HELLOWSSERVICE_EXCEPTION;
        }
        return HELLOWSSERVICE_WSDL_LOCATION;
    }

}
