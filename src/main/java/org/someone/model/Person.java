package org.someone.model;

public class Person {
    private long id;
    private String name;
    private String lastName;
    private String bandName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
    
    @Override
    public String toString() {
        return String.format("{id: %d, First Name : %s, Last Name : %s, Band Name : %s}", id, name, lastName, bandName);
    }
}
