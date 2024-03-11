package View;
import java.sql.Connection;


import Controllers.UserControl;
import Models.LocationDAO;
import Models.MissingpeopleDAO;
import Models.Resource_distributionDAO;
import Models.Supplies_neededDAO;
import Models.TransportationDAO;

import Models.VolunteersDAO;
import Models.loginDAO;
// import Resources.LocationDTO;
// import Resources.Missing_PeopleDTO;
import Util.Input;


public class VolunteerView extends Input{
    Connection con;
    public void toSignUpLogin() throws Exception{
        while(true){
            System.out.println("Welcome to Disaster Management System");
            System.out.println();
            System.out.println("1. User");
            System.out.println("2. Volunteer");
            System.out.println("3.exit");
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            if(choice==2){
                System.out.println("1.Login");
                System.out.println("2.SignUp");
                System.out.println("3.Exit");
                System.out.println("Enter your choice: ");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    boolean k=true;
                    System.out.println("Enter your Name");
                    String name=sc.next();
                    System.out.println("Enter your password");
                    String password=sc.next();
                    loginDAO ld=new loginDAO();
                    int r=ld.viewVolunteerId(name);
                    String pwd=ld.login(r);
                    if(pwd.equals(password))
                        System.out.println("Welcome "+name+" as Volunteer !!!");
                    UserView uv=new UserView();
                    uv.Details(r,k);
                }
                else if(ch==2)
                {
                    System.out.println("Enter your Name");
                    String name=sc.next();
                    System.out.println("Enter your Contact number");
                    String contact_no=sc.next();
                    System.out.println("Availability if yes 1 no 0");
                    int availability=sc.nextInt();
                    System.out.println("Enter your City");
                    String city=sc.next();
                    System.out.println("Enter your Area");
                    String area=sc.next();
                    System.out.println("Enter your password");
                    String password=sc.next();
                    LocationDAO lo=new LocationDAO();
                    int location_id=lo.viewLocationId(city, area);
                    int transport_id= 0;
                    VolunteersDAO va=new VolunteersDAO();
                    va.signUp(name,contact_no,availability,location_id,transport_id);
                    int vol=va.viewVolunteerId(contact_no);
                    loginDAO ll=new loginDAO();
                    ll.addSignUp(vol, password);
                    loginDAO ld=new loginDAO();
                    int r=ld.viewVolunteerId(name);
                    boolean k=true;  
                    while(k){
                    UserView uv=new UserView();
                    uv.Details(r,k); } 
                }
        
            }
        else if(choice==1){
            while(true){
            System.out.println("1. Add Missing People");
            System.out.println("2. Need of Supplies");
            System.out.println("3. View Supplies Distribution");
            System.out.println("4. View Transportation");
            System.out.println("5. Request for Transportation");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            int cho=sc.nextInt();
            if(cho==1){
                System.out.println("Enter your City");
                String city = sc.next();
                System.out.println("Enter your area");
                String area = sc.next();
                LocationDAO va=new LocationDAO();
                int b=va.viewLocationId(city, area);
                System.out.println(b);
                System.out.println("Enter the name");
                String name=sc.next();
                System.out.println("Enter the gender");
                String gender=sc.next();
                System.out.println("Enter the age");
                int age=sc.nextInt();
                MissingpeopleDAO v=new MissingpeopleDAO();
                v.addMissingPeople(b, name, gender, age);
            }
            else if(cho==2){
                System.out.println("Enter your City");
                String city=sc.next();
                System.out.println("Enter your Area");
                String area=sc.next();
                VolunteersDAO va=new VolunteersDAO();
                int a=va.viewDistributionId(city,area);
                System.out.println("Enter the item name");
                String item_name = sc.next();
                System.out.println("Enter the quantity needed");
                int quantity_needed = sc.nextInt();
                System.out.println("Enter the status");
                String status = sc.next();
                Supplies_neededDAO s=new Supplies_neededDAO();
                s.addSuppliesNeeded(a,item_name,quantity_needed,status);
            }
            else if(cho==3){
                System.out.println("Enter city and area");
                String city = sc.next();
                String area = sc.next();
                Resource_distributionDAO va=new Resource_distributionDAO();
                va.viewResourceDistribution(city,area);
            }
            else if(cho==4){
                TransportationDAO t=new TransportationDAO();
                t.viewTransportation();
            }
            else if(cho==5){
                TransportationDAO t=new TransportationDAO();
                t.viewTransportation();
                System.out.println("Enter the Transport id");
                int transport_id=sc.nextInt();
                VolunteersDAO va=new VolunteersDAO();
                int volunteer_id=va.viewVolunteerIdS(transport_id);
                t.requestTransportation(volunteer_id);
            }
            else{
                break;
            }
        }
        }
        else if(choice==3){
            break;
        }
    }
    }
    public void signUp() throws Exception
    {
       
        System.out.println("Enter name: ");
        String name=sc.next();
        
        
            System.out.println("Enter Contact number: ");
            int contact=sc.nextInt();
            System.out.println("Enter Availabilty: ");
            String availability=sc.next();
            System.out.println("Enter password: ");
            String password=sc.next();
            System.out.println("Enter Location: ");
            String location=sc.next();
            
            System.out.println("Enter your role:(User/Volunteer) ");
            String role=sc.next();
            
            
           
            UserControl us=new UserControl();
            int check=us.signUp(name,contact,availability,password,location,contact,role);
            if(check==1)
            {
                System.out.println("SignUp successful...");
            }
            else
            {
                System.out.println("SignUp failed...");
            }   
    }
}