package screenplay.model;

public class UserData {
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String address1;
    private String city;
    private String postCode;
    private String country;
    private String region;

    public UserData(String firstName, String lastName, String email, String telephone,
                    String address1, String city, String postCode, String country, String region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.address1 = address1;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.region = region;
    }

    // Builder pattern para crear usuarios de forma más limpia
    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String telephone;
        private String address1;
        private String city;
        private String postCode;
        private String country;
        private String region;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder withAddress(String address) {
            this.address1 = address;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public UserData build() {
            return new UserData(firstName, lastName, email, telephone, address1, 
                              city, postCode, country, region);
        }
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getAddress1() { return address1; }
    public String getCity() { return city; }
    public String getPostCode() { return postCode; }
    public String getCountry() { return country; }
    public String getRegion() { return region; }

    @Override
    public String toString() {
        return String.format("UserData{firstName='%s', lastName='%s', email='%s'}", 
                           firstName, lastName, email);
    }
}
