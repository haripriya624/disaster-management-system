package Controllers;
import java.sql.SQLException;

// import Models.loginDAO;
import Models.Resource_distributionDAO;
// import Models.VolunteersDAO;
//  import Models.VolunteersDAO;

// import Resources.VolunteersDTO;
//import Resources.orphanageDTO;
//  import Util.Cookie;
public class UserControl {

    public int signUp(String name, int contact, String availability, String password, String location, int contact2,
            String role) {
        
        throw new UnsupportedOperationException("Unimplemented method 'signUp'");
    }
    public void getreasource(String city,String area) {
        try {
            Resource_distributionDAO v = new Resource_distributionDAO();
            v.viewResourceDistribution(city, area);
        } catch (SQLException e) {
            System.out.println("Error in viewResourceDistribution: ");
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("Unexpected error in viewResourceDistribution: ");
        }
    }
}
