package com.pxz.provider.controller;

import com.pxz.provider.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @ClassName TempController
 * @Package com.pxz.consumer.controller
 * @Author 潘形忠
 * @Date 2019/5/20 12:52
 */
@RestController
public class UserController {



    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        final User us = new User(id);
        return us;
    }
}
