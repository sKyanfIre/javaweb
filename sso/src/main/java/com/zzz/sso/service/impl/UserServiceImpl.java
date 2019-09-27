package com.zzz.sso.service.impl;

import com.zzz.sso.bean.User;
import com.zzz.sso.dao.UserDao;
import com.zzz.sso.def.Constants;
import com.zzz.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zzz
 * @description
 * @date 2019/9/27
 */
@Service
@EnableTransactionManagement
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(String username, String password) {
        User user = new User();
        user.setIsValid(Constants.VALID);
        user.setUsername(username);
        user.setPassword(password);

        return null;
    }

    @Override
    public boolean createUser(String username, String password) {
        return false;
    }
}
