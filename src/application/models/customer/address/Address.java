package application.models.customer.address;

public abstract class Address {
    private final String streetName;
    private final String buildingNo;
    private final int postalCode;
    private final String city;
    private final String country;

    public Address(String streetName, String buildingNo, int postalCode, String city, String country) {
        if(streetName == null || buildingNo == null || city == null || country == null){
            throw new NullPointerException("null passed to address constructor");
        } else if (streetName.isBlank() || buildingNo.isBlank() || String.valueOf(postalCode).length() != 4
                || city.isBlank() || country.isBlank()) {
            throw new IllegalArgumentException("missing input field or illegal argument passed");
        }
        this.streetName = streetName;
        this.buildingNo = buildingNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
