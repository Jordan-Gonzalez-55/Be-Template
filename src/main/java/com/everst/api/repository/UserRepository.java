package com.everst.api.repository;

import com.everst.api.enums.Hobbies;
import com.everst.api.enums.SexualOrientation;
import com.everst.api.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Iterable<User> findUsersByEmail(String email);
    //@Query("select u from User u where u.sex =?1")
    Iterable<User> findUsersBySex(SexualOrientation sex);
    Iterable<User> findUsersByHobbies(Hobbies hobbie);
}
