package ru.job4j.devops;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@Disabled
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CalcApplicationTests {

    @Test
    void contextLoads() {
        /*
        This test ensures that the Spring application context loads successfully
         */
    }

    @Test
    void mainMethodTest() {
        CalcApplication.main(new String[]{});
    }
}