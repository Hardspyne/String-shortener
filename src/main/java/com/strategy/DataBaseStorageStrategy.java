package com.strategy;

import com.ExceptionHandler;
import com.Shortener;
import com.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseStorageStrategy implements StorageStrategy {
    private Connection connection;
    private static final String SELECT_ID_QUERY = "select * from strings where string = ?";
    private static final String SELECT_VALUE_QUERY = "select * from strings where id = ?";

    public DataBaseStorageStrategy() {
        connection = DbUtil.getDbConnection();
    }

    @Override
    public boolean containsKey(Long key) {
        try {
            ResultSet resultSet = executeSelectValueQuery(key);
            if (resultSet != null) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        try {
            ResultSet resultSet = executeSelectIdQuery(value);
            if (resultSet != null) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        String putQuery = "insert into strings values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(putQuery);
            preparedStatement.setLong(1, key);
            preparedStatement.setString(2, value);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
    }

    @Override
    public Long getKey(String value) {
        try {
            ResultSet resultSet = executeSelectIdQuery(value);
            if (resultSet != null && resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        try {
            ResultSet resultSet = executeSelectValueQuery(key);
            if (resultSet != null && resultSet.next()) {
                return resultSet.getString(2);
            }
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    private ResultSet executeSelectIdQuery(String value) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_QUERY);
            preparedStatement.setString(1, value);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    private ResultSet executeSelectValueQuery(Long key) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VALUE_QUERY);
            preparedStatement.setLong(1, key);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public long getLastID() {
        String getMaxIdQuery = "SELECT max(id) FROM strings";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getMaxIdQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
