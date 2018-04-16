package io.github.web.springtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringJupiterTest {

    @Autowired
    MyComponent myComponent;

    @Test
    void test() {
        String hello = myComponent.sayHello();
        assertEquals(hello, "Hello world");
    }

}
