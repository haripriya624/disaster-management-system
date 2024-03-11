package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class TransportationDAO {
    // public void viewTransportation() throws SQLException {
    //     String newQuery = "SELECT * FROM transportation WHERE availability=?";
    //     int availability=1;
    //     Connection connection = Connect.getConnection();
        
    //     try (PreparedStatement preparedStatement = connection.prepareStatement(newQuery);
    //          ResultSet secondResultSet = preparedStatement.executeQuery()) {
            
    //         // Display transportation details
    //         System.out.println("Transportation Details:");
    //         while (secondResultSet.next()) {
    //             int transport_id= secondResultSet.getInt("transport_id");
    //             String mode = secondResultSet.getString("mode");
    //             String driverName = secondResultSet.getString("drivername");
    //             String contactNo = secondResultSet.getString("contact_no");
    
    //             System.out.println("Transport id: "+transport_id);
    //             System.out.println("Mode: " + mode);
    //             System.out.println("Driver Name: " + driverName);
    //             System.out.println("Contact No: " + contactNo);
    //             System.out.println("------------------------------");
    //         }
    //     }
    // }
    public void viewTransportation() throws SQLException {
        String selectQuery = "SELECT * FROM transportation WHERE availability=?";
        int availability = 1;
        
        Connection connection = Connect.getConnection();
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, availability);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Display transportation details
                System.out.println("Transportation Details:");
    
                while (resultSet.next()) {
                    int transportId = resultSet.getInt("transport_id");
                    String mode = resultSet.getString("mode");
                    String driverName = resultSet.getString("drivername");
                    String contactNo = resultSet.getString("contact_no");
    
                    System.out.println("Transport id: " + transportId);
                    System.out.println("Mode: " + mode);
                    System.out.println("Driver Name: " + driverName);
                    System.out.println("Contact No: " + contactNo);
                    System.out.println("------------------------------");
                }
            }
        } finally {
            // Close resources in the finally block to ensure proper cleanup
            if (connection != null) {
                connection.close();
            }
        }
        // Additional error handling can be added here if needed
    }
    

    // public void requestTransportation(int volunteer_id) throws SQLException{
    //     String newQuery = "SELECT name FROM volunteers WHERE volunteer_id=? AND availabilty=?";
    //     String updateQuery = "UPDATE volunteers SET availability=? WHERE volunteer_id=?";
    //    Connection connection=Connect.getConnection();
    //                 int availability=1;
    //                 try (PreparedStatement preparedStatement = connection.prepareStatement(newQuery);PreparedStatement updateStatement = connection.prepareStatement(updateQuery))  {
    //                     // Set parameter for the second query
    //                     preparedStatement.setInt(1, volunteer_id);
    //                     preparedStatement.setInt(2, availability);
    
    //                     // Execute the second query
    //                     try (ResultSet secondResultSet = preparedStatement.executeQuery()) {
    
    //                         // Display resource distribution information
    //                         System.out.println("Resource Distribution Information:");
    //                         while (secondResultSet.next()) {
    //                             String Volunteer_Name = secondResultSet.getString("name");

    
    //                             System.out.println("Mr " + Volunteer_Name+" will be coming shortly");
    //                             System.out.println("------------------------------");
    //             int updatedAvailability = 0;
    //             updateStatement.setInt(1, updatedAvailability);
    //             updateStatement.setInt(2, volunteer_id);

    //             // Execute the UPDATE query
    //             // int rowsUpdated = updateStatement.executeUpdate();
    //             // if (rowsUpdated > 0) {
    //             //     System.out.println("Availability updated to 0 for volunteer: ");
    //             // } else {
    //             //     System.out.println("Failed to update availability for volunteer: ");
    //             // }
    //                         }
    //                     }
    //                 } 
    // }
    public void requestTransportation(int transport_id) throws SQLException {
        String selectVolunteerQuery = "SELECT name FROM volunteers WHERE transport_id=?";
        String updateTransportationQuery = "UPDATE transportation SET availability=? WHERE transport_id=?";
        Connection connection = Connect.getConnection();
    
        try (PreparedStatement selectVolunteerStatement = connection.prepareStatement(selectVolunteerQuery);
             PreparedStatement updateTransportationStatement = connection.prepareStatement(updateTransportationQuery)) {
    
            // Retrieve volunteer name using volunteer_id
            selectVolunteerStatement.setInt(1, transport_id);
            try (ResultSet volunteerResultSet = selectVolunteerStatement.executeQuery()) {
                if (volunteerResultSet.next()) {
                    String volunteerName = volunteerResultSet.getString("name");
    
                    // Display volunteer information
                    System.out.println("Volunteer Information:");
                    System.out.println("Name: " + volunteerName);
                    System.out.println("------------------------------");
    
                    // Set parameters for the UPDATE query in the transportation table
                    int updatedAvailability = 0;
                    updateTransportationStatement.setInt(1, updatedAvailability);
                    updateTransportationStatement.setInt(2, transport_id);
    
                    // Execute the UPDATE query in the transportation table
                    int rowsUpdated = updateTransportationStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Availability updated to 0 for transport id: " + transport_id);
                    } else {
                        System.out.println("Failed to update availability for transport id: " + transport_id);
                    }
                } else {
                    System.out.println("Volunteer not found for volunteer_id: " + transport_id);
                }
            }
        } finally {
            // Close resources in the finally block to ensure proper cleanup
            if (connection != null) {
                connection.close();
            }
        }
        // Additional error handling can be added here if needed
    }
    
    
    public void addTransportation(String mode,String drivername,String contact_no,int volunteer_id){
        try {
            // Prepare a SQL query to insert data into supplies_needed table
            String insertQuery = "INSERT INTO transportation (mode, drivername, contact_no, volunteer_id) VALUES (?, ?, ?, ?)";
            try (Connection connection = Connect.getConnection();
                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                // Set parameters for the insert query
                insertStatement.setString(1, mode);
                insertStatement.setString(2, drivername);
                insertStatement.setString(3, contact_no);
                insertStatement.setInt(4, volunteer_id);
    
                // Execute the insert query
                int rowsAffected = insertStatement.executeUpdate();
    
                if (rowsAffected > 0) {
                    System.out.println("Transportation added successfully.");
                } else {
                    System.out.println("Failed to add tarnsportation.");
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
