package screenplay.model;

public class Address {
    private final String street;
    private final String city;
    private final String postCode;
    private final String country;
    private final String region;

    public Address(String street, String city, String postCode, String country, String region) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.region = region;
    }

    // Direcciones predefinidas
    public static Address mexicoCity() {
        return new Address("Calle Falsa 123", "Mexico City", "01000", "Mexico", "Mexico City");
    }

    public static Address usaNewYork() {
        return new Address("123 Broadway", "New York", "10001", "United States", "New York");
    }

    public static Address ukLondon() {
        return new Address("10 Downing Street", "London", "SW1A 2AA", "United Kingdom", "London");
    }

    // Getters
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostCode() { return postCode; }
    public String getCountry() { return country; }
    public String getRegion() { return region; }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", street, city, postCode, country);
    }
}
