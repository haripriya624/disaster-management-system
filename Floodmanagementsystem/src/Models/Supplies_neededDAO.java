package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Supplies_neededDAO {
    public void addSuppliesNeeded(int disasterId,String item_name,int quantity_needed,String status) {
    try {

        // Prepare a SQL query to insert data into supplies_needed table
        String insertQuery = "INSERT INTO supplies_needed (item_name, quantity_needed, status, disasiter_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = Connect.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

            // Set parameters for the insert query
            insertStatement.setString(1, item_name);
            insertStatement.setInt(2, quantity_needed);
            insertStatement.setString(3, status);
            insertStatement.setInt(4, disasterId);

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
