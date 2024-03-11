package Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Resources.loginDTO;
import Resources.VolunteersDTO;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class VolunteersDAO extends Connect {
    private static VolunteersDAO instance;
    PreparedStatement getsignUp, getlogSign, isId;
    public VolunteersDAO() throws SQLException {
        // getsignUp = con.prepareStatement("INSERT INTO Volunteers(name,contact_no,availability,location_id,transport_id)Values(?,?,?,?,?)");
        // getlogSign = con.prepareStatement("INSERT INTO login(volunteer_id,Password)Values(?,?)");
        // isId = con.prepareStatement("select volunteer_id from Volunteers where Contact_no=?");

    }

    public static VolunteersDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new VolunteersDAO();
        }
        return instance;
    }

    public int getsignUp(VolunteersDTO dummy) throws SQLException {
        getsignUp.setString(1, dummy.getName());
        getsignUp.setString(3, dummy.getContact_no());
        getsignUp.setString(2, dummy.getAvailability());
        getsignUp.setInt(4, dummy.getLocation_id());
        getsignUp.setInt(5, dummy.getTransport_id());
        int rs = getsignUp.executeUpdate();

        return rs;

    }
    public int getId(int contact) throws SQLException {
        isId.setInt(1, contact);
        ResultSet rs = isId.executeQuery();
        int D = 0;
        if (rs.next()) {
            D = rs.getInt(1);
        }
        return D;

    }

    public int getsignUp2(loginDTO tummy, int id) throws SQLException {
        getlogSign.setInt(1, tummy.getVolunteer_id());
        getlogSign.setString(2, tummy.getPassword());
        getlogSign.setInt(3, id);
        int ps = getlogSign.executeUpdate();
        return ps;
    }
    
    public int viewDistributionId(String city, String area) throws SQLException {
        String selectQuery = "SELECT disaster_id FROM dis WHERE location_id IN (SELECT location_id FROM location WHERE city = ? AND area = ?)";
        
        int disasterId = -1;  // Default value in case no records are found
    
        try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setString(1, city);
            selectStatement.setString(2, area);
    
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    disasterId = firstResultSet.getInt("disaster_id");
                }
            }
        }
        // System.out.println(disasterId);
        return disasterId;
    }
    public int viewVolunteerIdS(int transport_id) throws SQLException{
        String selectQuery = "SELECT volunteer_id FROM volunteers WHERE transport_id= ?";
        
        int volunteerId = -1;  // Default value in case no records are found
    
        try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setInt(1, transport_id);
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    volunteerId = firstResultSet.getInt("volunteer_id");
                }
            }
        }
        // System.out.println(disasterId);
        return volunteerId;
    }

    public int viewVolunteerId(String contact_no) throws SQLException{
        String selectQuery = "SELECT volunteer_id FROM volunteers WHERE contact_no= ?";
        
        int volunteerId = -1;  // Default value in case no records are found
    
        try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setString(1, contact_no);
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    volunteerId = firstResultSet.getInt("volunteer_id");
                }
            }
        }
        // System.out.println(disasterId);
        return volunteerId;
    }
    public void signUp(String name,String contact_no,int availability,int location_id,int transport_id){
        try {

            // Prepare a SQL query to insert data into supplies_needed table
            String insertQuery = "INSERT INTO volunteers (name, contact_no, availabilty, location_id, transport_id) VALUES (?, ?, ?, ?, ?)";
            try (Connection connection = Connect.getConnection();
                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
    
                // Set parameters for the insert query
                insertStatement.setString(1, name);
                insertStatement.setString(2, contact_no);
                insertStatement.setInt(3, availability);
                insertStatement.setInt(4, location_id);
                insertStatement.setInt(5, transport_id);
    
                // Execute the insert query
                int rowsAffected = insertStatement.executeUpdate();
    
                if (rowsAffected > 0) {
                    System.out.println("Signed Up Succesfully");
                } else {
                    System.out.println("Signup Failed");
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
