package com.feima;

import com.feima.server.service.FeimaUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthApplicationTests {

    @Autowired
    FeimaUserService feimaUserService;
    @Test
    public void contextLoads() {
        String secret = new BCryptPasswordEncoder().encode("secret");
        System.out.println(secret);
    }
}
