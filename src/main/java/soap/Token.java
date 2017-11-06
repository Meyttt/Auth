package soap;

import generated.TokensEntity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Meyttt on 27.10.2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Token")
@XmlSeeAlso(UUID.class)
public class Token {
    public Token() {
    }
    @XmlElement(name = "uuid")
    @XmlJavaTypeAdapter(UUID_Adapter.class)
    UUID uuid;
    @XmlElement(name = "expiredDate")
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
