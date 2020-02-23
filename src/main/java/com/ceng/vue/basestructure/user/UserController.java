package com.ceng.vue.basestructure.user;

import com.ceng.vue.basestructure.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ApiResponse.response(user);
    }

    @GetMapping("/")
    public ApiResponse getAllUser() {
        List<User> users = userService.getAll();
        users.add(User.builder().id("101").name("Cengizhan").surname("Ozcan").emailAddress("cengizhanozcan92@gmail.com").username("cengizhanozcan").build());

        return ApiResponse.response(users);
    }

    @PostMapping("/")
    public ApiResponse save(@RequestBody User user) {
        User response = userService.save(user);
        return ApiResponse.response(response);
    }
}
