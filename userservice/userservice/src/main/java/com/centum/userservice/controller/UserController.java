package com.centum.userservice.controller;



import com.centum.userservice.VO.ResponseTempleteVO;
import com.centum.userservice.model.User;
import com.centum.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
@Slf4j

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of Usercontroller");
        return userService.saveUser(user);
    }
    @GetMapping("/{userId}")
    public ResponseTempleteVO getUserWithMonthlySavings(@PathVariable("userId") Long userId){
        log.info("Inside getUserWithMonthlySavings method of UserController");
        return userService.getUserWithMonthlySavings(userId);
    }
}
