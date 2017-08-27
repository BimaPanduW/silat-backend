package com.bima.silat.services;

import com.bima.silat.services.entities.User;
import org.omg.CORBA.UserException;

import java.util.Collection;

public interface UserService {
    void addUser(User user);

    Collection<User> getUsers();

    User getUser(String id);

    User editUser(User user) throws UserException;
}
