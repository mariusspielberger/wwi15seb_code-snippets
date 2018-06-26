package com.mariusspielberger.study.p6.sw_arch.exercise.boundry;


import com.mariusspielberger.study.p6.sw_arch.exercise.control.UserControl;
import com.mariusspielberger.study.p6.sw_arch.exercise.control.UserControlImpl;
import com.mariusspielberger.study.p6.sw_arch.exercise.entity.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UserServiceBean extends UnicastRemoteObject implements UserService {
  private UserControl control = new UserControlImpl();

  protected UserServiceBean() throws RemoteException {
    super();
  }

  public User findUserById(int id) {
    return control.findUserById(id);
  }

  public User findUserByUsername(String userName) {
    return control.findUserByUsername(userName);
  }

  public List<User> getAllUsers() {
    return control.getAllUsers();
  }

  public User createUser(User user) {
    return control.createUser(user);
  }

  public User updateUser(User user) {
    return control.updateUser(user);
  }

  public User deleteUser(User user) {
    return control.deleteUser(user);
  }
}
