package com.rsa.spider.Pojo;

public class StudentPojo {

    private String Name;
    private double Lat;
    private double lng;

    public StudentPojo(String name, double lat, double lng) {
        Name = name;
        Lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
