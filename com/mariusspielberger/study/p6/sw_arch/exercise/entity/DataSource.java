package com.mariusspielberger.study.p6.sw_arch.exercise.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

  private static DataSourceType dataSourceType = DataSourceType.H2;

  private String dbUrl = "jdbc:h2:tcp://localhost/~/test";
  private String driver = "org.h2.Driver";
  private String username = "sa";
  private String password = "";

  private Connection conn;

  private static DataSource INSTANCE = new DataSource();

  private DataSource() {
    this.doConnection();
  }

  public static DataSource getInstance() {
    return DataSource.INSTANCE;
  }

  public static DataSourceType getDataSourceType() {
    return DataSource.dataSourceType;
  }

  public Connection getConnection() {
    return this.conn;
  }

  public void doConnection() {
    try {
      Class.forName(this.driver);

      this.conn = DriverManager.getConnection(this.dbUrl, this.username, this.password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
