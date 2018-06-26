package com.mariusspielberger.study.p6.sw_arch.exercise.boundry;

import com.mariusspielberger.study.p6.sw_arch.exercise.entity.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserService extends Remote {
  User findUserById(int id) throws RemoteException;
  User findUserByUsername(String userName) throws RemoteException;

  List<User> getAllUsers() throws RemoteException;

  User createUser(User user) throws RemoteException;
  User updateUser(User user) throws RemoteException;
  User deleteUser(User user) throws RemoteException;
}
