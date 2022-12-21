package org.example.EmployeePayrollService;


import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "*******";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcurl, username, password);
            String sql1 = "UPDATE employee_payroll SET basic_pay ='3000000' WHERE Name ='Terisa Reddy'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.execute(sql1);
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM employee_payroll");
            System.out.println("EmployeeID\t\tName\t\tgender\t\tbasic_pay\tStartDate");
            System.out.println("-------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t\t"
                        + resultSet.getString(4) + "\t\t"
                        + resultSet.getString(5));
            }
            connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }
}
