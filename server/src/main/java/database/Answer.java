package database;



/**
 * Created by Meyttt on 27.10.2017.
 */
public class Answer{
    Token accessToken;
    Token refreshToken;
    String error;


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

