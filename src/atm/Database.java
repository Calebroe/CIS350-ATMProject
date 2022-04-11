package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import atm.DbUtil;
import atm.JDBCMySQLConnection;
import atm.User;

public class Database {
	public static void main(String[] args) {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the EmployeeID:");
        
        int userId;
        try {
            userId = Integer.parseInt(br.readLine());
            Database database = new Database();
            User user = database.getUserId(userId);
            System.out.println(user);           
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
 
    public User getUserId(int userId)  {      
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
         
        User user = null;
        String query = "SELECT * FROM employee WHERE emp_id=" + userId;
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
                user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("user_pin"), rs.getInt("user_id"), rs.getDate("user_dob"));
//                user.setUserId(rs.getInt("emp_id"));
//                user.setFirstName(rs.getString("emp_name"));
//                user.setDob(rs.getDate("dob"));
//                user.setLastName(rs.getDouble("salary"));
//                user.setUserId((rs.getInt("dept_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}