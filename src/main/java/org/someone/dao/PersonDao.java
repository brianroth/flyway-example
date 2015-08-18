package org.someone.dao;

import java.util.List;

import org.someone.model.Person;

public interface PersonDao {    
    List<Person> findAll();
    
    Person find(int id);
    
    int count();
    
    Person findByName(String name);
    
    Person findByLastName(String lastName);

    void insert(Person person);
    
    void delete(Person person);
}
