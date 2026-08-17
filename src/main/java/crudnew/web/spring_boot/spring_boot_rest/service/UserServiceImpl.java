package crudnew.web.spring_boot.spring_boot_rest.service;

import crudnew.web.spring_boot.spring_boot_rest.dao.UserDao;
import crudnew.web.spring_boot.spring_boot_rest.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);      // persist → INSERT
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);    // merge → UPDATE
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}