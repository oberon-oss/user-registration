package eu.oberon.oss.demos.reg.services;

import eu.oberon.oss.demos.reg.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean isValid(User user) {
        return user != null;
    }
}
