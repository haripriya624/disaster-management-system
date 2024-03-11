package View;

import Models.LocationDAO;
import Models.MissingpeopleDAO;
import Models.Resource_distributionDAO;
import Models.TransportationDAO;
import Util.Input;
public class UserView extends Input{
    public void Details(int volunteer_id,boolean k) throws Exception{
    System.out.println("1. View Missing People");
    System.out.println("2. Add Resource Distribution");
    System.out.println("3. Add Transportation");
    System.out.println("4. Exit");
    System.out.println("Enter your Choice");
    int choice=sc.nextInt();
    if(choice==1){
        System.out.println("Enter your City");
        String city=sc.next();
        System.out.println("Enter your Area");
        String area=sc.next();
        LocationDAO d=new LocationDAO();
        int location_id=d.viewLocationId(city, area);
        MissingpeopleDAO md=new MissingpeopleDAO();
        md.viewMissingPeople(location_id);
    }
    else if(choice==2){
        System.out.println("Enter your itemname");
        String item_name=sc.next();
        System.out.println("Enter the quantity");
        int quantity=sc.nextInt();
        System.out.println("Enter the Distribution date");
        String distribution_date=sc.next();
        Resource_distributionDAO rd=new Resource_distributionDAO();
        rd.addResourceDistribution(item_name, quantity, distribution_date, volunteer_id);
    }
    else if(choice==3){
        System.out.println("Enter the mode of transport");
        String mode=sc.next();
        System.out.println("Enter the drivername");
        String driver_name=sc.next();
        System.out.println("Enter the contact_no");
        String contact_no=sc.next();
        TransportationDAO ta=new TransportationDAO();
        ta.addTransportation(mode, driver_name, contact_no, volunteer_id);
    }
    else if(choice==4){
        k=false;
        // break;
    }
    }
}
