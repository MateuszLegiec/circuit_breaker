package pl.legit.producer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.legit.openapi.rest.api.UserApiDelegate;
import pl.legit.openapi.rest.model.User;

@Service
public class CustomUserApiDelegate implements UserApiDelegate {

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Controller");
        user.setLastName("Data");
        System.out.println(user.toString());
        return ResponseEntity.ok(user);
    }
}
