package io.cucumber.samples.dw.domain;

/**
 * Created by stlv for developerworks article
 */
public class Address {
    private long id;
    private String cardNum;
    private String region;
    private String country;
    private String state;
    private String city;
    private String street;
    private String extDetail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getExtDetail() {
        return extDetail;
    }

    public void setExtDetail(String extDetail) {
        this.extDetail = extDetail;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", extDetail='" + extDetail + '\'' +
                '}';
    }
}

