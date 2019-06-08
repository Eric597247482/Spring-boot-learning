package com.zte.springbootweb.web;

import com.zte.springbootweb.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {
    @RequestMapping(name="/getUser",method = RequestMethod.POST)
    public User getUser() {
        User user = new User();
        user.setName("eric");
        user.setAge(3);
        user.setPass("123123");

        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPass("neo123");
        users.add(user1);

        User user2 = new User();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPass("123456");

        users.add(user2);

        return users;

    }
}
