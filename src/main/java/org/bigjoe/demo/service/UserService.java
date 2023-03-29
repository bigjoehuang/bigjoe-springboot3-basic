package org.bigjoe.demo.service;

import java.util.List;

import org.bigjoe.demo.entity.User;

public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Integer id);

    public User findUserById(Integer id);

    public List<User> findAll();
}