package generated;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Meyttt on 27.10.2017.
 */
@Entity
@Table(name = "tokens", schema = "public", catalog = "auth")
public class TokensEntity {
    private Long id;
    private UUID value;
    private Timestamp expiredDate;
   /* private Collection<SessionsEntity> sessionsById;
    private Collection<SessionsEntity> sessionsById_0;*/

    public TokensEntity(Date date) {
        this.expiredDate=new Timestamp(date.getTime());
    }

    public TokensEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value", nullable = false, insertable = false, updatable = false)
    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    @Basic
    @Column(name = "expired_date", nullable = true)
    public Timestamp getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Timestamp expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokensEntity that = (TokensEntity) o;

        if (id != that.id) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (expiredDate != null ? !expiredDate.equals(that.expiredDate) : that.expiredDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (expiredDate != null ? expiredDate.hashCode() : 0);
        return result;
    }

   /* @OneToMany(mappedBy = "tokensByAccessToken")
    public Collection<SessionsEntity> getSessionsById() {
        return sessionsById;
    }

    public void setSessionsById(Collection<SessionsEntity> sessionsById) {
        this.sessionsById = sessionsById;
    }

    @OneToMany(mappedBy = "tokensByRefreshToken")
    public Collection<SessionsEntity> getSessionsById_0() {
        return sessionsById_0;
    }

    public void setSessionsById_0(Collection<SessionsEntity> sessionsById_0) {
        this.sessionsById_0 = sessionsById_0;
    }
*/
}
