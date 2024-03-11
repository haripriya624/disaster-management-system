package Resources;

public class TransportationDTO {
    private int transport_id;
    private String mode;
    private String drivername;
    private String contact_no;
    private int volunteer_id;
    public int getTransport_id() {
        return transport_id;
    }
    public void setTransport_id(int transport_id) {
        this.transport_id = transport_id;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getDrivername() {
        return drivername;
    }
    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }
    public String getContact_no() {
        return contact_no;
    }
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
    public int getVolunteer_id() {
        return volunteer_id;
    }
    public void setVolunteer_id(int volunteer_id) {
        this.volunteer_id = volunteer_id;
    }
}