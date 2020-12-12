package pl.legit.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.legit.openapi.client.api.UserApiClient;
import pl.legit.openapi.client.model.User;

@Component
@AllArgsConstructor
public class FeignScheduler {

    private final GetUserService getUserService;

    @Scheduled(fixedDelay = 1000)
    public void call(){
        System.out.println("-------------------------Start fetching-------------------------");
        ResponseEntity<User> userById = getUserService.getCallData();
        System.out.println(userById);
    }

}

@Service
@AllArgsConstructor
class GetUserService {

    private final UserApiClient userApiClient;

    @HystrixCommand(fallbackMethod = "getFallBackData")
    public ResponseEntity<User> getCallData(){
        return userApiClient.getUserById(1L);
    }

    public ResponseEntity<User> getFallBackData(){
        User user = new User();
        user.setId(1L);
        user.setFirstName("Fallback");
        user.setLastName("Data");
        return ResponseEntity.ok(user);
    }
}
