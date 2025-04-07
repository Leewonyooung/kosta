package dto;

public class Facility {
    String fac_id;
    String fac_type;
    String fac_type_name;
    String fac_nm;
    Integer price;
    String available_time;
    String etc;

    public Facility() {
    }

    public Facility(String fac_id, String fac_type, String fac_type_name, String fac_nm, Integer price, String available_time, String etc) {
        this.fac_id = fac_id;
        this.fac_type = fac_type;
        this.fac_type_name = fac_type_name;
        this.fac_nm = fac_nm;
        this.price = price;
        this.available_time = available_time;
        this.etc = etc;
    }

    public String getFac_id() {
        return fac_id;
    }

    public void setFac_id(String fac_id) {
        this.fac_id = fac_id;
    }

    public String getFac_type() {
        return fac_type;
    }

    public void setFac_type(String fac_type) {
        this.fac_type = fac_type;
    }

    public String getFac_type_name() {
        return fac_type_name;
    }

    public void setFac_type_name(String fac_type_name) {
        this.fac_type_name = fac_type_name;
    }

    public String getFac_nm() {
        return fac_nm;
    }

    public void setFac_nm(String fac_nm) {
        this.fac_nm = fac_nm;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAvailable_time() {
        return available_time;
    }

    public void setAvailable_time(String available_time) {
        this.available_time = available_time;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
