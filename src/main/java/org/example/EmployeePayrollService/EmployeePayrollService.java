package org.example.EmployeePayrollService;


import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "@Vacky_007";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcurl, username, password);
            String sql1 = "UPDATE employee_payroll SET basic_pay ='3000000' WHERE Name ='Terisa Reddy'";
            //String sql2 = "SELECT SUM(salary) FROM employee_payroll WHERE gender = 'Male' GROUP BY gender";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            //PreparedStatement preparedStatement1=connection.prepareStatement(sql2);
            preparedStatement.execute(sql1);
            //preparedStatement1.execute(sql2);
            ResultSet resultSet = preparedStatement.executeQuery("SELECT SUM(basic_pay) FROM employee_payroll WHERE gender = 'Male' GROUP BY gender");
            System.out.println("\tbasic_pay");
            System.out.println("-------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(""));
            }
            connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}
