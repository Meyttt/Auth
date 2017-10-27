package database;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import generated.SessionsEntity;
import generated.TokensEntity;

import static database.DBClient.*;

/**
 * Created by Meyttt on 27.10.2017.
 */
public class AuthOperator {
    public Answer makeToken(Long userId){
        Date date = new Date();
        TokensEntity accessToken= new TokensEntity(changeDateHour(date,1));
        saveOrUpd(accessToken);
        accessToken=DBClient.refresh(accessToken);
        System.out.println("Generated access token id: "+accessToken.getId());
        TokensEntity refreshToken= new TokensEntity(changeDate(date,4));
        saveOrUpd(refreshToken);
        refreshToken=DBClient.refresh(refreshToken);
        System.out.println("Generated refresh token id: "+refreshToken.getId());

        SessionsEntity sessionsEntity=new SessionsEntity(userId,accessToken,refreshToken);
        saveOrUpd(sessionsEntity);
        return new Answer(new Token(accessToken), new Token(refreshToken),null);
    }
    public Answer refresh(UUID refreshUUID){
        SessionsEntity sessionsEntity=getSessionByRefresh(refreshUUID);
        return generateAnswer(sessionsEntity);
    }
    public Answer auth(UUID uuid){
        SessionsEntity sessionsEntity=getSessionByAccess(uuid);
        return generateAnswer(sessionsEntity);
    }

    private Answer generateAnswer(SessionsEntity sessionsEntity){
        if (sessionsEntity!=null&&sessionsEntity.getUserId()!=null){
            Date date = new Date();
            TokensEntity oldRefr=sessionsEntity.getRefreshToken();
            TokensEntity olAcc=sessionsEntity.getAccessToken();
            TokensEntity accessToken= new TokensEntity(changeDateHour(date,1));
            saveOb(accessToken);
            accessToken=DBClient.refresh(accessToken);
            System.out.println("Generated access token id: "+accessToken.getId());
            TokensEntity refreshToken= new TokensEntity(changeDate(date,4));
            saveOb(refreshToken);
            refreshToken=DBClient.refresh(refreshToken);
            System.out.println("Generated refresh token id: "+refreshToken.getId());
            sessionsEntity.setAccessToken(accessToken);
            sessionsEntity.setRefreshToken(refreshToken);
            updateObject(sessionsEntity);
            delete(olAcc);
            delete(oldRefr);
            return new Answer(new Token(accessToken),new Token(refreshToken),null);
        }
        return new Answer(null,null,"Пользователь не найден.");
    }

    private SessionsEntity getSessionByUser(Long userId){
        return readByColumn("userId",userId,SessionsEntity.class);

    }
    public Answer logout(Long userId){
        SessionsEntity sessionsEntity= readByColumn("userId",userId,SessionsEntity.class);
        if (sessionsEntity!=null){
            delete(sessionsEntity);
        }
        return new Answer(null,null,null);

    }


    private void insertNewToken(UUID uuid){
        TokensEntity tokensEntity= new TokensEntity();
        tokensEntity.setValue(uuid);
        tokensEntity.setExpiredDate(getTimestamp(changeDate(new Date(),4)));
        saveOb(tokensEntity);
    }

    private void insertNewToken(){
        TokensEntity tokensEntity= new TokensEntity();
        tokensEntity.setExpiredDate(getTimestamp(changeDate(new Date(),4)));
        saveOb(tokensEntity);
    }
    private SessionsEntity getSessionByRefresh(UUID uuid){
        TokensEntity refreshToken = readByColumn("value",uuid,TokensEntity.class);
        return readByColumn("refreshToken",refreshToken,SessionsEntity.class);
    }
    private SessionsEntity getSessionByAccess(UUID uuid){
        TokensEntity accessToken = readByColumn("value",uuid,TokensEntity.class);
        return readByColumn("accessToken",accessToken,SessionsEntity.class);
    }

    private Timestamp getTimestamp(Date date){
        return new Timestamp(date.getTime());
    }
    private Date changeDate(Date date, int days){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(Calendar.DATE,days);
        return gregorianCalendar.getTime();
    }
    private Date changeDateHour(Date date, int hours){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(Calendar.HOUR,hours);
        return gregorianCalendar.getTime();
    }

    public static void main(String[] args) {
        AuthOperator authOperator= new AuthOperator();
        authOperator.makeToken(Long.valueOf(12));
    }


}



