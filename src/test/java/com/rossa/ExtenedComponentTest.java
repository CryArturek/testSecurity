package com.rossa;


import com.rossa.Package.Controller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ExtenedComponentTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Controller controller;

//    @Autowired
//    BusinessService businessService;

    public ExtenedComponentTest() {

    }

    @Before
    public void bef() {
        User user = new User();
        user.setName("dupa");
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));
    }

    @Test
    public void getSomeExtra() {
        System.out.println("test");
        Optional<User> byId = userRepository.findById(2L);
        String[] beanDefinitionNames = this.applicationContext.getBeanDefinitionNames();

    }
}
