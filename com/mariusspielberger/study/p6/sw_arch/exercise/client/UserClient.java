package com.mariusspielberger.study.p6.sw_arch.exercise.client;

import com.mariusspielberger.study.p6.sw_arch.exercise.boundry.UserService;
import com.mariusspielberger.study.p6.sw_arch.exercise.entity.User;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class UserClient {
  public static void main(String[] args) {
    try {
      UserService userService = (UserService) Naming.lookup("rmi://localhost:1099/UserService");

      // -------------------------------------------------------------------------------------------
      // --- Get all ---
      System.out.println("-----> GET ALL <-----");

      List<User> users = userService.getAllUsers();

      for (User user : users) {
        System.out.println(user);
      }

      System.out.println("-----> END - GET ALL <-----");
      System.out.println();

      // -------------------------------------------------------------------------------------------
      // --- Read ---
      System.out.println("-----> READ <-----");

      System.out.println("=== First ===");
      User firstUser = userService.findUserById(1);
      System.out.println(firstUser);

      System.out.println("=== Second ===");
      User secondUser = userService.findUserById(2);
      System.out.println(secondUser);

      System.out.println("-----> END - READ <-----");
      System.out.println();

      // -------------------------------------------------------------------------------------------
      // --- Create ---
      System.out.println("-----> CREATE <-----");

      User newUser = new User(0, "mb", "top-secret", "Matthias", "Bohnen");
      userService.createUser(newUser);

      User insertedUser = userService.findUserByUsername("mb");
      System.out.println(insertedUser);

      System.out.println("-----> END - CREATE <-----");
      System.out.println();

      // -------------------------------------------------------------------------------------------
      // --- Update ---
      System.out.println("-----> UPDATE <-----");

      insertedUser.setPassword("top-top-secret");
      userService.updateUser(insertedUser);

      User updatedUser = userService.findUserByUsername("mb");
      System.out.println(updatedUser);

      System.out.println("-----> END - UPDATE <-----");
      System.out.println();

      // -------------------------------------------------------------------------------------------
      // --- Delete ---
      System.out.println("-----> DELETE <-----");
      userService.deleteUser(updatedUser);

      User deletedUser = userService.findUserByUsername("mb");
      System.out.println(deletedUser);

      System.out.println("-----> END - DELETE <-----");
    } catch (NotBoundException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
