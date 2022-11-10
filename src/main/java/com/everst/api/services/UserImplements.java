package com.everst.api.services;

import com.everst.api.enums.Hobbies;
import com.everst.api.enums.SexualOrientation;
import com.everst.api.models.entity.User;
import com.everst.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserImplements implements UserDAO{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User insertUser(User user) {

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Iterable<User> usersBySex(SexualOrientation sex) {
        return userRepository.findUsersBySex(sex);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> usersByHobbie(Hobbies hobbie) {
        return userRepository.findUsersByHobbies(hobbie);
    }
}
