package application.models.customer.address;

public class House extends Address {
    private String gateCode;

    public House(String streetName, String buildingNo, int postalCode, String country, String gateCode) {
        super(streetName, buildingNo, postalCode, country);
        this.gateCode = gateCode;
    }

    public String getGateCode() {
        return gateCode;
    }
}
