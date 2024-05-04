package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    public static Integer MaxId = 0;

    @Id
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private boolean gender;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(Integer userId, String name, String address, String phoneNumber, boolean gender) {
        super();
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", gender=" + gender + '}';
    }

    

}
