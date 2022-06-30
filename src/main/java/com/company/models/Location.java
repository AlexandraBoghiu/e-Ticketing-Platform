package com.company.models;

public class Location {
    final private Integer id;
    static private Integer idLocation = 1;
    private String country;
    private String city;
    private String address;

    public Location(Integer id, String country, String city, String address) {
        idLocation++;
        this.id = id;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public static Integer getIdLocation() {
        return idLocation;
    }

    public static void setIdLocation(Integer idLocation) {
        Location.idLocation = idLocation;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
