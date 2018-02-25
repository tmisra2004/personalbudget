package com.tavishmisra.personalbudget.service;

import com.tavishmisra.personalbudget.models.User;

public interface UserService {

    public User findUser(String username);
    public void saveUser(User user);

}
