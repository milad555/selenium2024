package testDataClasses;

public class CompanyData {

    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String suite;

    public CompanyData(String name, String streetAddress, String city, String state, String suite) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.suite = suite;
    }
   public CompanyData(){}

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getSuite() {
        return suite;
    }

    public void setName(String name) {
    this.name = name;
}

public String setStreetAddress(String streetAddress) {
   return streetAddress;
}

public String setCity(String city) {
    return city;
}

public void setState(String state) {
    state = state;
}

public void setSuite(String suite) {
    this.suite = suite;
}


}
