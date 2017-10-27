import database.Answer;
import database.Token;
import database.AuthOperator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;


/**
 * Created by Meyttt on 27.10.2017.
 */
public class Smoke {
    @Test
    public void fillCircle(){
        Random random = new Random();
        Long userId = random.nextLong();

        AuthOperator authOperator = new AuthOperator();
        Answer answer=authOperator.makeToken(userId);
        Assert.assertTrue(answer.getError()==null);

        Answer answer2=authOperator.refresh(answer.getRefreshToken().getUuid());
        Assert.assertTrue(answer2.getError()==null);
        Assert.assertNotEquals(answer.getAccessToken().getUuid(),answer2.getAccessToken().getUuid());
        Assert.assertNotEquals(answer.getRefreshToken().getUuid(),answer2.getRefreshToken().getUuid());

        Answer answer3=authOperator.auth(answer2.getAccessToken().getUuid());
        Assert.assertTrue(answer3.getError()==null);
        Assert.assertNotEquals(answer2.getAccessToken().getUuid(),answer3.getAccessToken().getUuid());
        Assert.assertNotEquals(answer2.getRefreshToken().getUuid(),answer3.getRefreshToken().getUuid());

        Answer answer4=authOperator.logout(userId);
        Assert.assertTrue(answer4.getError()==null);



    }
}
