package entities;

public class UserEntity extends BaseEntity{

    String firstname;
    String lastname;
    String street;
    String city;
    String phone;
    String zipcode;
    String state;

    public UserEntity (String firstname, String lastname, String street, String city,
                       String phone, String zipcode, String state){
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.phone = phone;
        this.zipcode = zipcode;
        this.state = state;
    }

    public UserEntity() {}

    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() {return lastname;}
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
