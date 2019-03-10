package de.mola.jira.spielwiese.model.entity;


import net.java.ao.Entity;
import net.java.ao.schema.Table;

@Table("Address")
public interface Address extends Entity {

    String getIdentifier();
    void setIdentifier(String identifier);

    String getStreet();
    void setStreet(String street);

    String getHouseNumber();
    void setHouseNumber(String houseNumber);

    String getZip();
    void setZip(String zip);

    String getCity();
    void setCity(String city);

    String getState();
    void setState(String state);

    String getCountry();
    void setCountry(String country);

    Person getPerson();
    void setPerson(Person person);

    Company getCompany();
    void setCompany(Company company);
}
