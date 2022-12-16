package hw4.fileReader.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Addresses {
    private List<Address> addresses = new ArrayList<>();

    public Addresses() {
    }

    public Addresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "addresses=" + addresses +
                '}';
    }

    public void printAddresses() {
        for (Address address : this.addresses) {
            System.out.println(address.toString());
        }
    }

    public void sortBy(String sortParameter, String direction) {

        if (sortParameter.equals(AddressSortParamEnum.valueOf("FLAT").sortParam)) {
            sortWithDirection(direction, new AddressComparator.AddressComparatorByFlat());
        } else if (sortParameter.equals(AddressSortParamEnum.valueOf("HOUSE").sortParam)) {
            sortWithDirection(direction, new AddressComparator.AddressComparatorByHouse());
        } else {
            throw new RuntimeException("No such sort param: '" + sortParameter + "' Available: " + AddressSortParamEnum.valueOf("FLAT").sortParam + ", " + AddressSortParamEnum.valueOf("HOUSE").sortParam);
        }
    }

    private void sortWithDirection(String direction, Comparator<Address> comparing) {
        if (direction.equals(SortDirection.valueOf("ASC").direction)) {
            this.addresses.sort(comparing);
        } else if (direction.equals(SortDirection.valueOf("DESC").direction)) {
            this.addresses.sort(comparing.reversed());
        } else {
            throw new RuntimeException("No such sort direction '" + direction + "' Available: " + SortDirection.valueOf("ASC").direction + ", " + SortDirection.valueOf("DESC").direction);
        }
    }
}
