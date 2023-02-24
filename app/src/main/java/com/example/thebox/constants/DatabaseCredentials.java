package com.example.thebox.constants;

public class DatabaseCredentials {

    private static final String jdbcURL = "jdbc:mysql://localhost:3306";

    private static final String user = "root";
    private static final String password = "3306";

    // Update driver string information here!
    private static final String driverString = "com.mysql.jdbc.Driver";


    public static String getJdbcURL() {
        return jdbcURL;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDriverString() {
        return driverString;
    }
}
