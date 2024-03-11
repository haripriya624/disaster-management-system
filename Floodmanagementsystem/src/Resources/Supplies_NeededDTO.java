package Resources;

public class Supplies_NeededDTO {
    private int supplies_id;
    private String item_name;
    private int quantity_needed;
    private String status;
    private int disaster_id;
    public int getSupplies_id() {
        return supplies_id;
    }
    public void setSupplies_id(int supplies_id) {
        this.supplies_id = supplies_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public int getQuantity_needed() {
        return quantity_needed;
    }
    public void setQuantity_needed(int quantity_needed) {
        this.quantity_needed = quantity_needed;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getDisaster_id() {
        return disaster_id;
    }
    public void setDisaster_id(int disaster_id) {
        this.disaster_id = disaster_id;
    }
}
