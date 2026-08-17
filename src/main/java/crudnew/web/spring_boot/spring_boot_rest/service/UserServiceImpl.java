package crudnew.web.spring_boot.spring_boot_rest.service;


import crudnew.web.spring_boot.spring_boot_rest.dao.UserDao;
import crudnew.web.spring_boot.spring_boot_rest.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }
}
