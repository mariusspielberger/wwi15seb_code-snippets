package com.mariusspielberger.study.p6.sw_arch.exercise.entity;

import java.io.Serializable;

public class User implements Serializable {
  private int id;

  private String userName;
  private String password;

  private String firstName;
  private String lastName;

  public User(int id, String userName, String password, String firstName, String lastName) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "=> USER: id=" + this.id + " / username=" + this.userName + " / password=" + this.password +
           " / firstName=" + this.firstName + " / lastName=" + this.lastName ;
  }
}
