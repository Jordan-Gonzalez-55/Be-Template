package com.everst.api.services;

import com.everst.api.enums.Hobbies;
import com.everst.api.enums.SexualOrientation;
import com.everst.api.models.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO {

    public User insertUser(User user);


    public Iterable<User> usersBySex(SexualOrientation sex);

    public Iterable<User> usersByHobbie(Hobbies hobbie);
}
