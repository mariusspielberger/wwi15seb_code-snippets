package com.mariusspielberger.study.p6.sw_arch.exercise.boundry;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class UserServiceServer {
  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(1099);

      Naming.bind("rmi://localhost:1099/UserService", new UserServiceBean());

      System.out.println("Server up and running.");
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (AlreadyBoundException e) {
      e.printStackTrace();
    }
  }
}
