package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO {
    public int viewLocationId(String city,String area) throws SQLException{
        String selectQuery = "SELECT location_id FROM location WHERE city = ? AND area = ?";
        int locationId = -1;

        try (Connection connection = Connect.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
    
            // Set parameters for the query
            selectStatement.setString(1, city);
            selectStatement.setString(2, area);
    
            // Execute the first query
            try (ResultSet firstResultSet = selectStatement.executeQuery()) {
    
                // Check if there are any results
                if (firstResultSet.next()) {
                    locationId = firstResultSet.getInt("location_id");
                }
            }
        }
        // System.out.println(disasterId);
        return locationId;
    }
}
