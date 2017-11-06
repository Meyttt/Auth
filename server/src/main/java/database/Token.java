package database;

import generated.TokensEntity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Meyttt on 27.10.2017.
 */
public class Token {
    UUID uuid;
    Date expiredDate;

    public Token(UUID uuid, Date expiredDate) {
        this.uuid = uuid;
        this.expiredDate = expiredDate;
    }

    public Token(TokensEntity tokensEntity) {
        this.expiredDate = tokensEntity.getExpiredDate();
        this.uuid = tokensEntity.getValue();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }
}
