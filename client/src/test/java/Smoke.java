

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import output.Answer;
import output.AuthImpl;
import output.AuthImplService;

import java.util.Random;


/**
 * Created by Meyttt on 27.10.2017.
 */
public class Smoke {
    @Test
    public void testClient(){
        Logger logger = Logger.getLogger(Smoke.class);
        Random random = new Random();
        Long userId=Long.valueOf(random.nextLong());
        AuthImplService authImplService = new AuthImplService();
        AuthImpl authImpl = authImplService.getAuthImplPort();
        Answer answer=authImpl.makeToken(userId);

        Assert.assertTrue(answer.getError()==null);
        Assert.assertTrue(answer.getAccessToken()!=null);
        Assert.assertTrue(answer.getRefreshToken()!=null);
        logger.info("First access token:"+answer.getAccessToken().getUuid());
        logger.info("First refresh token:"+answer.getRefreshToken().getUuid());
        Answer authAnswer=authImpl.auth(answer.getAccessToken().getUuid().toString());
        Assert.assertTrue(authAnswer.getError()==null);
        Assert.assertTrue(authAnswer.getAccessToken()!=null);
        Assert.assertTrue(authAnswer.getRefreshToken()!=null);
        logger.info("Second access token:"+authAnswer.getAccessToken().getUuid());
        logger.info("Second refresh token:"+authAnswer.getRefreshToken().getUuid());
        Answer refreshAnswer=authImpl.refresh(authAnswer.getRefreshToken().getUuid().toString());
        Assert.assertTrue(refreshAnswer.getError()==null);
        Assert.assertTrue(refreshAnswer.getAccessToken()!=null);
        Assert.assertTrue(refreshAnswer.getRefreshToken()!=null);
        logger.info("Third access token:"+refreshAnswer.getAccessToken().getUuid());
        logger.info("Third refresh token:"+refreshAnswer.getRefreshToken().getUuid());
        Answer logoutAnswer = authImpl.logout(userId);
        Assert.assertTrue(logoutAnswer.getError()==null);
        Assert.assertTrue(logoutAnswer.getAccessToken()==null);
        Assert.assertTrue(logoutAnswer.getRefreshToken()==null);


    }
}
