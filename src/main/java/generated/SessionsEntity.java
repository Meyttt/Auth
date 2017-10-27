package generated;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by Meyttt on 27.10.2017.
 */
@Entity
@Table(name = "sessions", schema = "public", catalog = "auth")
public class SessionsEntity {
    private Long id;
    private Long userId;
    private TokensEntity accessToken;
    private TokensEntity refreshToken;
//    private TokensEntity tokensByAccessToken;
//    private TokensEntity tokensByRefreshToken;


    public SessionsEntity(Long userId, TokensEntity accessToken, TokensEntity refreshToken) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public SessionsEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false, unique = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_token")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public TokensEntity getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(TokensEntity accessToken) {
        this.accessToken = accessToken;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "refresh_token")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public TokensEntity getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(TokensEntity refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionsEntity that = (SessionsEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (refreshToken != null ? !refreshToken.equals(that.refreshToken) : that.refreshToken != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (refreshToken != null ? refreshToken.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "access_token", referencedColumnName = "id")
//    public TokensEntity getTokensByAccessToken() {
//        return tokensByAccessToken;
//    }
//
//    public void setTokensByAccessToken(TokensEntity tokensByAccessToken) {
//        this.tokensByAccessToken = tokensByAccessToken;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "refresh_token", referencedColumnName = "id")
//    public TokensEntity getTokensByRefreshToken() {
//        return tokensByRefreshToken;
//    }
//
//    public void setTokensByRefreshToken(TokensEntity tokensByRefreshToken) {
//        this.tokensByRefreshToken = tokensByRefreshToken;
//    }
}
