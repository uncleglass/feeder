package pl.uncleglass.feeder.backend.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.security.HashService;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final HashService hashService;

    public UserService(UserRepository userRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.hashService = hashService;
    }

    public User createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        User userToAdd = new User(user.getUsername(), encodedSalt, hashedPassword);
        return userRepository.save(userToAdd);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public UUID getAuthenticatedUsersId(Authentication authentication) {
        return getUser(authentication.getName()).getId();
    }
}
