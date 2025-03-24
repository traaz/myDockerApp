package com.example.demoProject.webApi;


import com.example.demoProject.Business.UserService;
import com.example.demoProject.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUserController(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable  int id){
        return userService.getUserById(id);
    }

    @PostMapping()
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
 /*   @GetMapping("/getlastid")
    public int getLastId() {
        return userService.getLastId();
    }*/

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id,@RequestBody User user){
        userService.updateUser(id,user);
    }
}
