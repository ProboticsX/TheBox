package com.example.thebox.dao;

import com.example.thebox.DatabaseConnection;
import com.example.thebox.entity.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {

    public static String TABLENAME = "menu";
    public Connection connection;

    public List<Menu> getMenuForDisplay() throws SQLException {
        List<Menu> menuList = new ArrayList<>();
        connection = DatabaseConnection.createDatabaseConnection();
        String sqlQuery = "Select * from " + TABLENAME + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst())
                throw new SQLException("No data found");

            while(resultSet.next()) {
                Menu menu = new Menu();
                menu.setId(resultSet.getInt(1));
                menu.setFoodName(resultSet.getString(2));
                menu.setCuisine(resultSet.getString(3));
                menu.setCalories(resultSet.getInt(4));
                menu.setProviderId(resultSet.getInt(5));

                menuList.add(menu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DatabaseConnection.closeDatabaseConnection(connection);
        return menuList;
    }
}
