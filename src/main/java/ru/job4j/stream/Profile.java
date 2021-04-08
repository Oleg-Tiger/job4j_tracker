package ru.job4j.stream;

import java.util.Objects;

public class Profile {
    private String name;
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Profile(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name)
                && Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
