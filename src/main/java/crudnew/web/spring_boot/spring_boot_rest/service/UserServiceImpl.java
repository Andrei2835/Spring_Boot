package crudnew.web.spring_boot.spring_boot_rest.service;


import crudnew.web.spring_boot.spring_boot_rest.dao.UserDao;
import crudnew.web.spring_boot.spring_boot_rest.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
//   @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
 //   @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id);
    }


    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Transactional
    @Override
    public void update(User user) {
        User existUser = userDao.findById(user.getId());
        existUser.setId(user.getId());
        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());
        existUser.setAge(user.getAge());
        userDao.update(existUser);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {

        userDao.deleteById(id);
    }
}
