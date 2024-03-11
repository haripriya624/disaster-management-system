import java.sql.SQLException;
import Models.Connect;
import View.VolunteerView;

public class App extends Connect{
    public static void main(String[] args) throws Exception {
        try{
            Connect.getConnection();
            System.out.println("Connected");
        }
        catch(SQLException err){
            System.out.println("Database Connectiom error");
            System.out.println(err);
            return;
        }

        VolunteerView H=new VolunteerView();
        H.toSignUpLogin();
    }
}
