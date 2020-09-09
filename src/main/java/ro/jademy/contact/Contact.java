package ro.jademy.contact;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.Objects;

public class Contact implements Comparable<Contact> {


    private String id;
    private String lastName;
    private String firstName;
    private PhoneNumber number;
    private String group;
    private String email;


    public Contact(String lastName, String firstName, PhoneNumber number) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.number = number;
    }

    public Contact(String id, String lastName, String firstName, PhoneNumber number, String group, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.number = number;
        this.group = group;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    public void setNumber(PhoneNumber number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(lastName, contact.lastName) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(number, contact.number) &&
                Objects.equals(group, contact.group) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, number, group, email, id);
    }

    @Override
    public int compareTo(Contact o) {
        return Comparator.comparing(Contact::getLastName)
                .thenComparing(Contact::getFirstName).compare(this, o);

    }

    @Override
    public String toString() {
        return
                StringUtils.center(id, 12, " ") +
                        StringUtils.center(firstName, 16, " ") +
                        StringUtils.center(lastName, 16, " ") +
                        StringUtils.center(number.getNumbers().toString(), 16, ' ') +
                        StringUtils.center(group, 12, ' ') +
                        StringUtils.center(email, 20, ' ');
    }
}