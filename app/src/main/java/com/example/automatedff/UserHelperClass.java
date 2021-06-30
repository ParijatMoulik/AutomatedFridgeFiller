package com.example.automatedff;

public class UserHelperClass {
    private String name,username,email, phone,password,type,location;
    //private Location location;
    public UserHelperClass() {
    }

    UserHelperClass(String name, String username, String email, String phone,
                    String password, String type,String location) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.type=type;
        this.location=location;

    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
//    public Location getLocation() {
//        return location;
//    }
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

//class Location{
//    private String loc_name,latitude,longitude;
//
//    public Location()
//    {
//
//    }
//    public Location(String loc_name, String latitude, String longitude) {
//        this.loc_name = loc_name;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }
//
//    public String getLoc_name() {
//        return loc_name;
//    }
//
//    public void setLoc_name(String loc_name) {
//        this.loc_name = loc_name;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//}


