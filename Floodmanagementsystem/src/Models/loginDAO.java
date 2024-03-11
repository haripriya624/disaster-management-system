package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class loginDAO {
    public int viewVolunteerId(String name) throws SQLException{
        String selectQuery = "SELECT volunteer_id from volunteers WHERE name = ?";
        int volunteer_id=-1;
         try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setString(1, name);
    
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    volunteer_id = firstResultSet.getInt("volunteer_id");
                }
            }
        }
        return volunteer_id;
    }
   public String login(int volunteer_id) throws SQLException{
    String selectQuery = "SELECT password FROM login WHERE volunteer_id= ?";
    String pwd="";
    try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setInt(1, volunteer_id);
    
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    pwd = firstResultSet.getString("password");
                }
            }
        }
    return pwd;

   }
   public void addSignUp(int volunteer_id,String password){
          try {

            // Prepare a SQL query to insert data into supplies_needed table
            String insertQuery = "INSERT INTO login (volunteer_id,password) VALUES (?, ?)";
            try (Connection connection = Connect.getConnection();
                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                // Set parameters for the insert query
                insertStatement.setInt(1, volunteer_id);
                insertStatement.setString(2, password);
    
                // Execute the insert query
                int rowsAffected = insertStatement.executeUpdate();
    
                if (rowsAffected > 0) {
                    System.out.println("Supplies needed added successfully.");
                } else {
                    System.out.println("Failed to add supplies needed.");
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions appropriately
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values.");
            // Consume invalid input to prevent an infinite loop
        } catch (Exception e) {
            e.printStackTrace(); // Handle other exceptions
        }
   }
    
}
