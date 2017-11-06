package soap;

import soap.Answer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.UUID;

/**
 * Created by Meyttt on 01.11.2017.
 */
@WebService(endpointInterface = "soap.Auth")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface Auth {
    @WebMethod public Answer makeToken(@WebParam(name = "userId") Long userId);
    @WebMethod public Answer refresh(@WebParam(name = "refreshToken") UUID refreshUUID);
    @WebMethod public Answer auth(@WebParam(name = "uuid") UUID uuid);
    @WebMethod public Answer logout(@WebParam(name = "userId") Long userId);

}
