package com.zzz.sso.service;

import com.zzz.sso.bean.User;

public interface UserService {
    User getUser(String username,String password);
    boolean createUser(String username,String password);
}
