package org.stlyouthjobs.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "EMPLOYER_ADDRESS")
public class EmployerAddress {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=10, message = "Street number must have at least one number.")
    private Integer streetNumber;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String streetName;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String city;

    @NotNull
    @Size(max = 9, message = "This field is required.")
    private Integer zipCode;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String neighborhood;

    @ManyToMany(mappedBy =  "employerAddresses", cascade = PERSIST, fetch = EAGER)
    private Set<EmployerUser> employerUsers = new HashSet<>();

    public Set<EmployerUser> getEmployerUsers() {
        return employerUsers;
    }

    public void addEmployerUser(EmployerUser employerUser) {
        employerUsers.add(employerUser);
        employerUser.getEmployerAddress().add(this);
    }

    public EmployerAddress(Integer streetNumber, String streetName, String city, Integer zipCode, String neighborhood) {

        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
