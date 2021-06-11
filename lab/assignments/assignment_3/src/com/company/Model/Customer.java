package com.company.Model;

public class Customer {
    private int customerID;
    private String lastName;
    private String firstName;
    private String afm;
    private String telephone;

    public Customer(int customerID, String lastName, String firstName, String afm, String telephone) {
        this.customerID = customerID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.afm = afm;
        this.telephone = telephone;
    }

    public Customer() {
    }

    public int getCustomer_id() {
        return customerID;
    }

    public void setCustomer_id(int customerID) {
        this.customerID = customerID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
