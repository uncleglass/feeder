package pl.uncleglass.feeder.backend.app.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User {

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
