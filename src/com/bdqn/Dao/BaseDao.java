package com.bdqn.Dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    private static Properties properties=null;
    static {
        properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconn() throws Exception {
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    public void closeALL(Connection conn, PreparedStatement pram, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (pram!=null){
                    try {
                        pram.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if (conn!=null){
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
    public ResultSet selall(String sql,Object...pram) throws Exception {
        Connection connection = getconn();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        for (int i=0;i<pram.length;i++){
            preparedStatement.setObject(i+1,pram[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        closeALL(connection,preparedStatement,null);
        return resultSet;
    }

    public int updatesql(String sql,Object...pram) throws Exception {
        Connection connection=getconn();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i=0;i<pram.length;i++){
            preparedStatement.setObject(i+1,pram[i]);
        }
        int i = preparedStatement.executeUpdate();
        return i;
    }


    public int insert(String sql,Object...pram) throws Exception {
        Connection connection = getconn();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        for (int i=0;i<pram.length;i++){
            preparedStatement.setObject(i+1,pram[i]);
        }
        int i = preparedStatement.executeUpdate();
        return i;
    }
}
