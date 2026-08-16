package crudnew.web.spring_boot.spring_boot_rest.service;


import crudnew.web.spring_boot.spring_boot_rest.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void update(User user);

    void deleteById(Long id);
}