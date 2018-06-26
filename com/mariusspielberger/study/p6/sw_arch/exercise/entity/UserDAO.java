package com.mariusspielberger.study.p6.sw_arch.exercise.entity;

import java.util.List;

public interface UserDAO {
  User findUserById(int id);
  User findUserByUsername(String userName);

  List<User> getAllUsers();

  User createUser(User user);
  User updateUser(User user);
  User deleteUser(User user);
}
