
package output;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuthImplService", targetNamespace = "http://soap/", wsdlLocation = "http://localhost:9999/ws/auth?wsdl")
public class AuthImplService
    extends Service
{

    private final static URL AUTHIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUTHIMPLSERVICE_EXCEPTION;
    private final static QName AUTHIMPLSERVICE_QNAME = new QName("http://soap/", "AuthImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9999/ws/auth?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUTHIMPLSERVICE_WSDL_LOCATION = url;
        AUTHIMPLSERVICE_EXCEPTION = e;
    }

    public AuthImplService() {
        super(__getWsdlLocation(), AUTHIMPLSERVICE_QNAME);
    }

    public AuthImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUTHIMPLSERVICE_QNAME, features);
    }

    public AuthImplService(URL wsdlLocation) {
        super(wsdlLocation, AUTHIMPLSERVICE_QNAME);
    }

    public AuthImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUTHIMPLSERVICE_QNAME, features);
    }

    public AuthImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuthImpl
     */
    @WebEndpoint(name = "AuthImplPort")
    public AuthImpl getAuthImplPort() {
        return super.getPort(new QName("http://soap/", "AuthImplPort"), AuthImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthImpl
     */
    @WebEndpoint(name = "AuthImplPort")
    public AuthImpl getAuthImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap/", "AuthImplPort"), AuthImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUTHIMPLSERVICE_EXCEPTION!= null) {
            throw AUTHIMPLSERVICE_EXCEPTION;
        }
        return AUTHIMPLSERVICE_WSDL_LOCATION;
    }

}
