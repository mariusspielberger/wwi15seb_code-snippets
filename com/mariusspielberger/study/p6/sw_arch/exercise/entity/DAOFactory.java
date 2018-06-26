package com.mariusspielberger.study.p6.sw_arch.exercise.entity;

public class DAOFactory {

  private DataSourceType dataSourceType = DataSource.getDataSourceType();

  private static final DAOFactory INSTANCE = new DAOFactory();

  private DAOFactory() {
  }

  public static DAOFactory getInstance() {
    return DAOFactory.INSTANCE;
  }

  public UserDAO getUserDao() {
    if (this.dataSourceType.equals(DataSourceType.H2)) {
      return new UserH2DAO();
    } else {
      throw new IllegalArgumentException("The given user type is not supported.");
    }
  }
}
