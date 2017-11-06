package soap;

import soap.Token;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Meyttt on 27.10.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Answer")
public class Answer {
    @XmlElement(name = "accessToken")
    Token accessToken;
    @XmlElement(name = "refreshToken")
    Token refreshToken;
    @XmlElement(name = "error")
    String error;

    public Answer() {
    }

    public Token getAccessToken() {
        return accessToken;
    }

    public Token getRefreshToken() {
        return refreshToken;
    }

    public String getError() {
        return error;
    }

    public Answer(Token accessToken, Token refreshToken, String error) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.error = error;
    }

}

