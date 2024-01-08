package org.selenium.pom.objects;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String countryName;
    private String addressLineOne;
    private String city;
    private String stateName;
    private String postCode;
    private String email;

    public BillingAddress(){}

    public BillingAddress(String firstName,String lastName,String countryName,String addressLineOne,String city,
                          String stateName,String postCode,String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryName = countryName;
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.stateName = stateName;
        this.postCode = postCode;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public BillingAddress setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public BillingAddress setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }







}
