package com.example.demoProject.Business;

import com.example.demoProject.Model.User;
import com.example.demoProject.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
       return  userRepository.getUsers();
    }
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }
    public void addUser(User user){
        userRepository.addUser(user);
    }
    public void deleteUser(int id){
        userRepository.deleteUser(id);
    }
 /*   public int getLastId(){
        return userRepository.getLastID();
    }*/
    public void updateUser(int id, User user){
        userRepository.updateUser(id, user);
    }

}
