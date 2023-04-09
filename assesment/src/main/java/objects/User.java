package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Address address;
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
    private int __v;
    public User(){}


    public User(Address address, int id, String email, String username, String password, Name name, String phone, int __v) {
        this.address = address;
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.__v = __v;
    }

    public double distanceKm(User user)
    {
        int R = 6371; // Radius of the earth
        double lat1=Double.parseDouble(address.getGeolocation().getLat());
        double lat2=Double.parseDouble(user.getAddress().getGeolocation().getLat());
        double lon1=Double.parseDouble(address.getGeolocation().getLng());
        double lon2=Double.parseDouble(user.getAddress().getGeolocation().getLng());

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return  R * c;
    }
    public String getIdAndName(){
        return id+" "+name;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Name getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int get__v() {
        return __v;
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", phone='" + phone + '\'' +
                ", __v=" + __v +
                '}';
    }

    public String getIdentity()
    {
        return id+" "+name;
    }

    public String getNameString()
    {
        return name.toString();
    }
}

class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;

    public Address(){}

    public Address(Geolocation geolocation, String city, String street, int number, String zipcode) {
        this.geolocation = geolocation;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "geolocation=" + geolocation +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
class Geolocation{
    private String lat;

    @JsonProperty("long")
    private String lng;

    public Geolocation(){}

    public Geolocation(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Geolocation{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}

class Name{

    private String firstname;
    private String lastname;
    public Name(){}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String toString()
    {
        return firstname+" "+lastname;
    }
}
