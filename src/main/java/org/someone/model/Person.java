package org.someone.model;

public class Person {
    private long id;
    private String name;
	 private String lastName;

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
    
    @Override
    public String toString() {
        return String.format("{id: %d, First Name : %s, Last Name : %s}", id, name, lastName);
    }
}
