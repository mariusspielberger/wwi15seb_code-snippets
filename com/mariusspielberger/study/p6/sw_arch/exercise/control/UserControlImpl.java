package com.mariusspielberger.study.p6.sw_arch.exercise.control;

import com.mariusspielberger.study.p6.sw_arch.exercise.entity.User;
import com.mariusspielberger.study.p6.sw_arch.exercise.entity.UserDAO;
import com.mariusspielberger.study.p6.sw_arch.exercise.entity.DAOFactory;
import java.util.List;

public class UserControlImpl implements UserControl {
  private UserDAO dao = DAOFactory.getInstance().getUserDao();

  public User findUserById(int id) {
    return dao.findUserById(id);
  }

  public User findUserByUsername(String userName) {
    return dao.findUserByUsername(userName);
  }

  public List<User> getAllUsers() {
    return dao.getAllUsers();
  }

  public User createUser(User user) {
    return dao.createUser(user);
  }

  public User updateUser(User user) {
    return dao.updateUser(user);
  }

  public User deleteUser(User user) {
    return dao.deleteUser(user);
  }
}
