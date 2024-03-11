package Resources;

public class Resource_DistributionDTO {
    private int resource_id;
    private String item_name;
    private int quantity;
    private String distribution_date;
    private int transport_id;
    private int volunteer_id;
    private int disaster_id;
    public int getResource_id() {
        return resource_id;
    }
    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDistribution_date() {
        return distribution_date;
    }
    public void setDistribution_date(String distribution_date) {
        this.distribution_date = distribution_date;
    }
    public int getTransport_id() {
        return transport_id;
    }
    public void setTransport_id(int transport_id) {
        this.transport_id = transport_id;
    }
    public int getVolunteer_id() {
        return volunteer_id;
    }
    public void setVolunteer_id(int volunteer_id) {
        this.volunteer_id = volunteer_id;
    }
    public int getDisaster_id() {
        return disaster_id;
    }
    public void setDisaster_id(int disaster_id) {
        this.disaster_id = disaster_id;
    }
}
