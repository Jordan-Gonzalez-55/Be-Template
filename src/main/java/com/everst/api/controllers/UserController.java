package com.everst.api.controllers;

import com.everst.api.enums.Hobbies;
import com.everst.api.enums.SexualOrientation;
import com.everst.api.exceptions.BadRequestExeption;
import com.everst.api.models.entity.User;
import com.everst.api.repository.UserRepository;
import com.everst.api.services.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/insert")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        List<User> usersReg = (List<User>) userRepository.findUsersByEmail(user.getEmail());
        if(!usersReg.isEmpty()){
            throw new BadRequestExeption(String.format("Alredy resgister!!"));
        }
        User userSaved =userDAO.insertUser(user);
        return new ResponseEntity<User>(userSaved,HttpStatus.CREATED);
    }

    @GetMapping("/sex/{sex}")
    public ResponseEntity<?> getUserBySex(@PathVariable SexualOrientation sex){
        List<User> usersFound = (List<User>) userDAO.usersBySex(sex);
        if(usersFound.isEmpty()){
            throw new BadRequestExeption(String.format("Not found!!"));
        }
        return new ResponseEntity<List<User>>(usersFound, HttpStatus.OK);
    }

    @GetMapping("/hobbie/{hobbie}")
    public ResponseEntity<?> getUserByHobbie(@PathVariable Hobbies hobbie ){
        List<User> usersFound = (List<User>) userDAO.usersByHobbie(hobbie);
        if(usersFound.isEmpty()){
            throw new BadRequestExeption(String.format("Not found!!"));
        }
        return new ResponseEntity<List<User>>(usersFound, HttpStatus.OK);
    }

}
