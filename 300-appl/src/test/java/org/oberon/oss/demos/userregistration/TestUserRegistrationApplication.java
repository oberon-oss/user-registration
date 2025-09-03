package eu.oberon.oss.demos.userregistration;

import eu.oberon.oss.demos.reg.appl.UserRegistrationApplication;
import org.springframework.boot.SpringApplication;

public class TestUserRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.from(UserRegistrationApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
