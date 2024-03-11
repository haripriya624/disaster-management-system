package Resources;

public class disDTO {
    private int disaster_id;
    private int location_id;
    private String disaster_type;
    public int getDisaster_id() {
        return disaster_id;
    }
    public void setDisaster_id(int disaster_id) {
        this.disaster_id = disaster_id;
    }
    public int getLocation_id() {
        return location_id;
    }
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    public String getDisaster_type() {
        return disaster_type;
    }
    public void setDisaster_type(String disaster_type) {
        this.disaster_type = disaster_type;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    private String date;
    private int status;
}
