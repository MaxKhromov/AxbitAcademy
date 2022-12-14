package hw4.fileReader.domain;

import java.util.ArrayList;
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
}
