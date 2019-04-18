package com.webapp.lay.mor.dao;

import java.util.List;
import com.webapp.lay.mor.entity.User;

public interface IUserDao {
    boolean add(User user);
    boolean delete(Integer id);
    boolean update(User user);
    List<User> find(User user);
    User findByLoginName(String loginName);
    User findById(Integer id);
    List<User> findWithPage(User user,int page,int pageSize);
}
