
package output;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the output package. 
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

    private final static QName _Refresh_QNAME = new QName("http://soap/", "refresh");
    private final static QName _LogoutResponse_QNAME = new QName("http://soap/", "logoutResponse");
    private final static QName _AuthResponse_QNAME = new QName("http://soap/", "authResponse");
    private final static QName _Logout_QNAME = new QName("http://soap/", "logout");
    private final static QName _RefreshResponse_QNAME = new QName("http://soap/", "refreshResponse");
    private final static QName _MakeTokenResponse_QNAME = new QName("http://soap/", "makeTokenResponse");
    private final static QName _MakeToken_QNAME = new QName("http://soap/", "makeToken");
    private final static QName _Auth_QNAME = new QName("http://soap/", "auth");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: output
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MakeTokenResponse }
     * 
     */
    public MakeTokenResponse createMakeTokenResponse() {
        return new MakeTokenResponse();
    }

    /**
     * Create an instance of {@link RefreshResponse }
     * 
     */
    public RefreshResponse createRefreshResponse() {
        return new RefreshResponse();
    }

    /**
     * Create an instance of {@link AuthResponse }
     * 
     */
    public AuthResponse createAuthResponse() {
        return new AuthResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link Auth }
     * 
     */
    public Auth createAuth() {
        return new Auth();
    }

    /**
     * Create an instance of {@link MakeToken }
     * 
     */
    public MakeToken createMakeToken() {
        return new MakeToken();
    }

    /**
     * Create an instance of {@link Refresh }
     * 
     */
    public Refresh createRefresh() {
        return new Refresh();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new Answer();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Refresh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "refresh")
    public JAXBElement<Refresh> createRefresh(Refresh value) {
        return new JAXBElement<Refresh>(_Refresh_QNAME, Refresh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "authResponse")
    public JAXBElement<AuthResponse> createAuthResponse(AuthResponse value) {
        return new JAXBElement<AuthResponse>(_AuthResponse_QNAME, AuthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefreshResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "refreshResponse")
    public JAXBElement<RefreshResponse> createRefreshResponse(RefreshResponse value) {
        return new JAXBElement<RefreshResponse>(_RefreshResponse_QNAME, RefreshResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "makeTokenResponse")
    public JAXBElement<MakeTokenResponse> createMakeTokenResponse(MakeTokenResponse value) {
        return new JAXBElement<MakeTokenResponse>(_MakeTokenResponse_QNAME, MakeTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "makeToken")
    public JAXBElement<MakeToken> createMakeToken(MakeToken value) {
        return new JAXBElement<MakeToken>(_MakeToken_QNAME, MakeToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap/", name = "auth")
    public JAXBElement<Auth> createAuth(Auth value) {
        return new JAXBElement<Auth>(_Auth_QNAME, Auth.class, null, value);
    }

}
