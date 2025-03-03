package application.models.customer.address;

public class Apartment extends Address {
    private int floor;
    private String apartmentNo;

    public Apartment(String streetName, String buildingNo, int postalCode, String city, String country, int floor, String apartmentNo) {
        super(streetName, buildingNo, postalCode, city, country);
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
