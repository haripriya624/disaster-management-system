package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class MissingpeopleDAO {
    public void addMissingPeople(int b,String name,String gender,int age){
        try {

            // Prepare a SQL query to insert data into supplies_needed table
            String insertQuery = "INSERT INTO missing_people (name, gender, age, location_id) VALUES (?, ?, ?, ?)";
            try (Connection connection = Connect.getConnection();
                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                // Set parameters for the insert query
                insertStatement.setString(1, name);
                insertStatement.setString(2, gender);
                insertStatement.setInt(3, age);
                insertStatement.setInt(4, b);
    
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
    public void viewMissingPeople(int location_id) throws SQLException{
       String newQuery = "SELECT * FROM missing_people WHERE location_id=?";
       Connection connection=Connect.getConnection();
                    try (PreparedStatement preparedStatement = connection.prepareStatement(newQuery)) {
                        // Set parameter for the second query
                        preparedStatement.setInt(1, location_id);
    
                        // Execute the second query
                        try (ResultSet secondResultSet = preparedStatement.executeQuery()) {
    
                            // Display resource distribution information
                            System.out.println("Resource Distribution Information:");
                            while (secondResultSet.next()) {
                                String resourceName = secondResultSet.getString("name");
                                String distribution_date = secondResultSet.getString("gender");
                                int quantity = secondResultSet.getInt("age");
    
                                System.out.println("Name: " + resourceName);
                                System.out.println("Gender: " + quantity);
                                System.out.println("Age: " + distribution_date);
                                System.out.println("------------------------------");
                            }
                        }
                    } 
    }
}
