package application.models.customer.address;

public class Apartment extends Address {
    private int floor;
    private String apartmentNo;

    public Apartment(String streetName, String buildingNo, int postalCode, String city, String country, int floor, String apartmentNo) {
        super(streetName, buildingNo, postalCode, city, country);
        if(apartmentNo == null){
            throw new NullPointerException("null passed to Apartment constructor");
        } else if(floor < -1 ){
            throw new IllegalArgumentException("floor cannot be under -1");
        }
        this.floor = floor;
        this.apartmentNo = apartmentNo;
    }

    public int getFloor() {
        return floor;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }
}
