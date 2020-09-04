package ro.jademy.contact;

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    private String lastName;
    private String firstName;
    private String number;
    private Group group;
    private String email;


    public Contact(String lastName, String firstName, String number) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.number = number;
    }

    public Contact(String lastName, String firstName, String number, Group group, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.number = number;
        this.group = group;
        this.email = email;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
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
                Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, number);
    }

    @Override
    public int compareTo(Contact o) {
        int comp = 0;
        comp = o.lastName.compareTo(lastName);
        if (comp == 0) {
            comp = o.firstName.compareTo(firstName);
            if (comp == 0) {
                return o.number.compareTo(number);
            }
        }
        return comp;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", number='" + number + '\'' +
                ", group=" + group +
                ", email='" + email + '\'' +
                '}';
    }
}
