package com.test.ecommercesystem.Controller;

import com.test.ecommercesystem.model.User;
import com.test.ecommercesystem.repository.UserRepo;
import com.test.ecommercesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.ecommercesystem.emailer.EmailSenderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin (origins = "http://localhost:3000")

public class UserController {

    private UserRepo userRepo;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        emailSenderService.sendSimpleEmail(
                user.getEmail(),
                "Welcome To Excellent Store Inc.!\nFollow this link to confirm your email and start shopping: https://www.google.com/",
                "Email Confirmation Link"

        );
        return "New user has been added";
    }

    @PostMapping("/checkUser")
    public int checkUser(@RequestBody User user){
        List<User> userList = new ArrayList<>();

        userList = userService.getAllUsers();

        for(User u : userList){

            if(u.getUsername().equals(user.getUsername())){
                if(u.getPassword().equals(user.getPassword())){
                    return 1;
                }
            }
        }
        return -1;
    }

    @PostMapping("/checkCreateUser")
    public int checkCreateUser(@RequestBody User user){
        List<User> userList = new ArrayList<>();

        userList = userService.getAllUsers();

        for(User u : userList){

            if(u.getEmail().equals(user.getEmail())){
                return 2;
            }else if(u.getUsername().equals(user.getUsername())){
                return 3;
            }
        }
        return 1;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
