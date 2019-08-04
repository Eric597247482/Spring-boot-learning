package com.zte.springbootweb.web;

import com.zte.springbootweb.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:"+user);
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list){
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }

    }

    @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    public User get (@PathVariable String name) {
        List<User> users = getUsers();
//        User user = new User();
//        for (int i =0; i < users.size(); i++) {
//            user = users.get(i);
//            if(user.getName().equals(name)) {
//                return user;
//            }
//        }

//        Optional<User> optional = users.stream().filter(
//                    user -> user.getName().equals(name)).findFirst();
        User user = users.stream().filter(user1 -> user1.getName().equals(name)).
                        findFirst().orElseGet(() -> new User());

        return user;
    }
}
