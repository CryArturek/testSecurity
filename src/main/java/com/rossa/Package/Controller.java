package com.rossa.Package;

import com.rossa.User;
import com.rossa.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/rest")
@RestController
@CrossOrigin
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/object")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Integer get(@Valid ApiObject api, HttpServletRequest request) {
        System.out.println("get" + api);
        return 3;
    }

    Integer i = 3;

    @PostMapping("/object")
    public void post(@Valid ApiObject apiObject) {
        UserExten user = new UserExten();
        user.setName(apiObject.name);

        userRepository.save(user);
        Iterable<User> all = userRepository.findAll();

        System.out.println("get");
    }

    @PutMapping("/object")
    public void put(@Valid @RequestBody ApiObject apiObject) {
//        System.out.println("put");
//        userRepository.save(new User(apiObject.name, "paa"));
//        Iterable<User> all = userRepository.findAll();
    }

    @DeleteMapping("/object")
    public void delete(ApiObject apiObject) {

        System.out.println("delete");
    }
}
