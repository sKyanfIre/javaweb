package com.zzz.sso.dao;

import com.zzz.sso.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author zzz
 * @description
 * @date 2019/9/27
 */
@Repository
public interface UserDao {
   User selectUser(User user);
}
