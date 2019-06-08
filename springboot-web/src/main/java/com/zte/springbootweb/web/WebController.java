package com.zte.springbootweb.web;

import com.zte.springbootweb.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping(name="/getUser",method = RequestMethod.POST)
    public User getUser() {
        User user = new User();
        user.setName("小羽");
        user.setAge(3);
        user.setPass("123123");

        return user;
    }

    public List<User> getUsers() {

    }
}
