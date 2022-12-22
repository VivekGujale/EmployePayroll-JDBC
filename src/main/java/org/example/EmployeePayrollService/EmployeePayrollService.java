package org.example.EmployeePayrollService;


import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "*******";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            String sql1 = "SELECT SUM(basic_pay), AVG(basic_pay), MAX(basic_pay), MIN(basic_pay), COUNT(basic_pay) FROM employee_payroll WHERE gender = 'Male' GROUP BY gender";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.execute(sql1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("SUM : " + resultSet.getDouble("SUM(basic_pay)") + "\n" +
                        "AVG : " + resultSet.getDouble("AVG(basic_pay)") + "\n" +
                        "MAX : " + resultSet.getDouble("MAX(basic_pay)") + "\n" +
                        "MIN : " + resultSet.getDouble("MIN(basic_pay)") + "\n" +
                        "COUNT : " + resultSet.getString("COUNT(basic_pay)"));
            }
            connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}