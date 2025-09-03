package eu.oberon.oss.demos.userregistration;

import org.junit.jupiter.api.Test;
import eu.oberon.oss.demos.reg.appl.UserRegistrationApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(classes = UserRegistrationApplication.class)
class UserRegistrationApplicationTests {

    @Test
    void contextLoads() {
    }

}
