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
        answer=authOperator.refresh(answer.getRefreshToken().getUuid());
        Assert.assertTrue(answer.getError()==null);
        answer=authOperator.auth(answer.getAccessToken().getUuid());
        Assert.assertTrue(answer.getError()==null);
        answer=authOperator.logout(userId);
        Assert.assertTrue(answer.getError()==null);



    }
}
