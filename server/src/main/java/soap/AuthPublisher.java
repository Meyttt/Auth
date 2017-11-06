package soap;

import javax.xml.ws.Endpoint;

/**
 * Created by Meyttt on 01.11.2017.
 */
public class AuthPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/auth", new AuthImpl());
    }
}
