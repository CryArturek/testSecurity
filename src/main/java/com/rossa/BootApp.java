package com.rossa;

import com.rossa.security.StatelessAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class BootApp {


    @Autowired
    private ApplicationContext applicationContext;
    Component dupa;
    @Autowired
    BusinessService businessService;

//  @Autowired
//  TestAutowir testAutowir;
//
//  @Autowired
//  List<String> stringBean1;

//  @Autowired
//  public BootApp(@Qualifier("sprawdzamSobieBeana") Component dupa) {
//    this.applicationContext = applicationContext;
//    this.dupa = dupa;
//  }

    @PostConstruct
    public void checkBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//    BootApp someInt = new BootApp(new Component());
//    Integer someInt1 = someInt.dupa.getSomeIntProtec();
        for (int i = 0; i < 3; i++) {
//      this.businessService.scheduleFixedDelayTask();

        }

    }

    public static void main(String... args) {
        for (int i = 0; i < 3; i++) {
//      System.out.println(args[i]);

        }


        SpringApplication.run(BootApp.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/rest/**")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE")
//                        .allowedOrigins("*")
//                        .allowedHeaders("*");
//            }
//            // co znaczy exposedheaders
//        };
//    }
}
