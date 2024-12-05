package testDataClasses;

public class UserData {
    private final String username;

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String password;
    private String confirmPassword;
    private final String phone;
    private final String email;
    private final String country;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zip;


    public UserData(String username, String firstName, String middleName, String lastName, String password, String phone, String email, String country, String streetAddress, String city, String state, String zip) {
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Constructor for the builder
    private UserData(UserDataBuilder builder) {
        this.username = builder.username;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.confirmPassword = builder.confirmPassword;
        this.phone = builder.phone;
        this.email = builder.email;
        this.country = builder.country;
        this.streetAddress = builder.streetAddress;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {return city;}
    public String getState() {return state;}
    public String getStreetAddress() {return streetAddress;}
    public String getZip() {return zip;}


    // Static inner class for the Builder
    public static class UserDataBuilder {
        private String streetAddress;
        private String username;
        private String firstName;
        private String middleName;
        private String lastName;
        private String password;
        private String confirmPassword;
        private String phone;
        private String email;
        private String country;
        private String city;
        private String state;
        private String zip;

        public UserDataBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDataBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDataBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public UserDataBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDataBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDataBuilder setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public UserDataBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserDataBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDataBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public UserDataBuilder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public UserDataBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public UserDataBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public UserDataBuilder setZip(String zip) {
            this.zip = zip;
            return this;
        }

        public UserData build() {
            return new UserData(this);
        }
    }

}
