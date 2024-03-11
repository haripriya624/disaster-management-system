package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Resource_distributionDAO {
    public void addResourceDistribution(String item_name,int quantity,String distribution_date,int volunteer_id){
         try {
            int transport_id=0;
            int disasiter_id=1;
            // Prepare a SQL query to insert data into supplies_needed table
            String insertQuery = "INSERT INTO resource_distribution (item_name, quantity, distribution_date,transport_id, volunteer_id,disasiter_id) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection connection = Connect.getConnection();
                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                // Set parameters for the insert query
                insertStatement.setString(1, item_name);
                insertStatement.setInt(2, quantity);
                insertStatement.setString(3, distribution_date);
                insertStatement.setInt(4, transport_id);
                insertStatement.setInt(5, volunteer_id);
                insertStatement.setInt(6, disasiter_id);
    
                // Execute the insert query
                int rowsAffected = insertStatement.executeUpdate();
    
                if (rowsAffected > 0) {
                    System.out.println("Resource Distribution added successfully.");
                } else {
                    System.out.println("Failed to add resource distribution.");
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
    public void viewResourceDistribution(String city,String area) throws SQLException {
        String selectQuery = "SELECT disaster_id FROM dis WHERE location_id IN (SELECT location_id FROM location WHERE city = ? AND area = ?)";
    
        try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setString(1, city);
            selectStatement.setString(2, area);
    
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    int disasterId = firstResultSet.getInt("disaster_id");
    
                    // Prepare a SQL query to select resource distribution based on disaster_id
                    String newQuery = "SELECT * FROM resource_distribution WHERE disasiter_id=?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(newQuery)) {
                        // Set parameter for the second query
                        preparedStatement.setInt(1, disasterId);
    
                        // Execute the second query
                        try (ResultSet secondResultSet = preparedStatement.executeQuery()) {
    
                            // Display resource distribution information
                            System.out.println("Resource Distribution Information:");
                            while (secondResultSet.next()) {
                                int distributionId = secondResultSet.getInt("resource_id");
                                String resourceName = secondResultSet.getString("item_name");
                                int quantity = secondResultSet.getInt("quantity");
                                String distribution_date = secondResultSet.getString("distribution_date");
    
                                System.out.println("Distribution ID: " + distributionId);
                                System.out.println("Resource Name: " + resourceName);
                                System.out.println("Quantity: " + quantity);
                                System.out.println("Distribution date: " + distribution_date);
                                System.out.println("------------------------------");
                            }
                        }
                    }
    
                } else {
                    System.out.println("No matching records found");
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
}
