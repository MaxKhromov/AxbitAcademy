package hw4.fileReader.domain;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Address {
    private String country;
    private String area;
    private String city;
    private String street;
    private String house;
    private String flat;

    public Address(String country, String area, String city, String street, String house, String flat) {
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public Address(List<String> addressAsRawList) {
        for (String s : addressAsRawList) {
            String[] colVal = s.split(":");
            colVal[0] = colVal[0].startsWith(" ") ? colVal[0].substring(1) : colVal[0];
            colVal[1] = colVal[1].startsWith(" ") ? colVal[1].substring(1) : colVal[1];
            switch (colVal[0].toLowerCase(Locale.ROOT)) {
                case "страна" -> this.country = colVal[1];
                case "субъект федерации" -> this.area = colVal[1];
                case "город" -> this.city = colVal[1];
                case "улица" -> this.street = colVal[1];
                case "дом" -> this.house = colVal[1];
                case "квартира" -> this.flat = colVal[1];
                default -> throw new RuntimeException("Cannot parse address from: " + addressAsRawList);
            }

        }
    }

//    public int sortBy(Address o) {
//
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(area, address.area) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house) && Objects.equals(flat, address.flat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, area, city, street, house, flat);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getCountry() {
        return country;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlat() {
        return flat;
    }
}
