package com.mariusspielberger.study.p6.sw_arch.exercise.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserH2DAO implements UserDAO {

  // At first, create the table USER with the following SQL command:
  // CREATE TABLE USER(ID bigint auto_increment, USERNAME varchar(255) UNIQUE, PASSWORD varchar(255), FIRSTNAME varchar(255), LASTNAME varchar(255))

  // Finally, add some test data sets:
  // INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES ('ms', 'change-me', 'Marius', 'Spielberger')
  // INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES ('ik', 'password', 'Ina', 'Kolbinger')
  // INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES ('mf', 's5kjgdkj5tdfkgmzkjwerlkgsjdfz', 'Martin', 'Faber')

  public User findUserById(int id) {
    String sql = "SELECT * FROM USER WHERE ID = ?";

    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet res = null;

    User user = null;

    try {
      conn = DataSource.getInstance().getConnection();
      stat = conn.prepareStatement(sql);
      stat.setInt(1, id);

      res = stat.executeQuery();

      while (res.next()) {
        int pId = res.getInt("ID");
        String userName = res.getString("USERNAME");
        String password = res.getString("PASSWORD");
        String firstName = res.getString("FIRSTNAME");
        String lastName = res.getString("LASTNAME");

        user = new User(pId, userName, password, firstName, lastName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stat.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
  }

  public User findUserByUsername(String aUserName) {
    String sql = "SELECT * FROM USER WHERE USERNAME = ?";

    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet res = null;

    User user = null;

    try {
      conn = DataSource.getInstance().getConnection();
      stat = conn.prepareStatement(sql);
      stat.setString(1, aUserName);

      res = stat.executeQuery();

      while (res.next()) {
        int pId = res.getInt("ID");
        String userName = res.getString("USERNAME");
        String password = res.getString("PASSWORD");
        String firstName = res.getString("FIRSTNAME");
        String lastName = res.getString("LASTNAME");

        user = new User(pId, userName, password, firstName, lastName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stat.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
  }

  public List<User> getAllUsers() {
    String sql = "SELECT * FROM USER";

    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet res = null;

    List<User> users = new ArrayList<User>();
    User user = null;

    try {
      conn = DataSource.getInstance().getConnection();
      stat = conn.prepareStatement(sql);

      res = stat.executeQuery();

      while (res.next()) {
        int pId = res.getInt("ID");
        String userName = res.getString("USERNAME");
        String password = res.getString("PASSWORD");
        String firstName = res.getString("FIRSTNAME");
        String lastName = res.getString("LASTNAME");

        user = new User(pId, userName, password, firstName, lastName);
        users.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stat.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return users;
  }

  public User createUser(User user) {
    String sql = "INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES (?, ?, ?, ?)";
    Connection conn = null;
    PreparedStatement stat = null;

    try {
      conn = DataSource.getInstance().getConnection();
      stat = conn.prepareStatement(sql);
      stat.setString(1, user.getUserName());
      stat.setString(2, user.getPassword());
      stat.setString(3, user.getFirstName());
      stat.setString(4, user.getLastName());

      stat.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stat.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
  }

  public User updateUser(User user) {
    String sql = "UPDATE USER SET USERNAME = ?, PASSWORD = ?, FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
    Connection conn = null;
    PreparedStatement stat = null;

    try {
      conn = DataSource.getInstance().getConnection();
      stat = conn.prepareStatement(sql);
      stat.setString(1, user.getUserName());
      stat.setString(2, user.getPassword());
      stat.setString(3, user.getFirstName());
      stat.setString(4, user.getLastName());
      stat.setInt(5, user.getId());

      stat.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stat.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
  }

  public User deleteUser(User user) {
    String sql = "DELETE FROM USER WHERE ID = ?";
    Connection conn = null;
    PreparedStatement stat = null;

    try {
      conn = DataSource.getInstance().getConnection();
      stat = conn.prepareStatement(sql);
      stat.setInt(1, user.getId());

      stat.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stat.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return user;
  }
}
