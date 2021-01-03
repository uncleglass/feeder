package pl.uncleglass.feeder.backend.app.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String salt;
    private String password;

    public User(String username, String salt, String password) {
        this.username = username;
        this.salt = salt;
        this.password = password;
    }
}
