package pl.legit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.legit.openapi.rest.api.UserApiController;
import pl.legit.openapi.rest.api.UserApiDelegate;

@Configuration
public class Controllers {
    @Autowired
    private UserApiDelegate userApiDelegate;

    @Bean
    public UserApiController userApiController(){
        return new UserApiController(userApiDelegate);
    }

}
