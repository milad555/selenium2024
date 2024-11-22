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



    public UserData(String username, String firstName, String middleName, String lastName, String password, String phone, String email, String country) {
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.country = country;

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

}
