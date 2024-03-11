package Resources;

public class VolunteersDTO {
    private int volunteer_id;
    private String name;
    private String contact_no;
    private String availability;
    private int location_id;
    private int transport_id;
    public int getVolunteer_id() {
        return volunteer_id;
    }
    public void setVolunteer_id(int volunteer_id) {
        this.volunteer_id = volunteer_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContact_no() {
        return contact_no;
    }
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
    public String getAvailability() {
        return availability;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public int getLocation_id() {
        return location_id;
    }
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    public int getTransport_id() {
        return transport_id;
    }
    public void setTransport_id(int transport_id) {
        this.transport_id = transport_id;
    }
}
