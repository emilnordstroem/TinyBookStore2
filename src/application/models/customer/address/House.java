package application.models.customer.address;

public class House extends Address {
    private String gateCode;

    public House(String streetName, String buildingNo, int postalCode, String city, String country, String gateCode) {
        super(streetName, buildingNo, postalCode, city, country);
        if(gateCode == null){
            this.gateCode = "";
        } else {
            this.gateCode = gateCode;
        }
    }

    public String getGateCode() {
        return gateCode;
    }
}
