package ro.jademy.contact;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Contact contact = new Contact("Andreescu", "Andrei", "0723123456", "Family", "andrei@gmail.com", RandomStringUtils.randomAlphanumeric(8)
        );
        Contact contact1 = new Contact("Alexandrescu", "Mihai", "0723135456", "Work", "mihai@gmail.com", RandomStringUtils.randomAlphanumeric(8)
        );
        Contact contact2 = new Contact("Marinescu", "Vlad", "0723123890", "Friends", "vlad@gmail.com", RandomStringUtils.randomAlphanumeric(8)
        );
        Contact contact3 = new Contact("Basescu", "Traian", "0723123456", "Work", "traian@gmail.com",RandomStringUtils.randomAlphanumeric(8)
        );
        Contact contact4 = new Contact("Popa", "Carmen", "0728193156", "Work", "traian@gmail.com", RandomStringUtils.randomAlphanumeric(8)
        );
        Contact contact5 = new Contact("Lazar", "Andreea", "0723823459", "Friends", "traian@gmail.com",RandomStringUtils.randomAlphanumeric(8)
        );
        //     Contact contact6 = new Contact("Vasile", "Andrei", "0753113469");
        Contact contact7 = new Contact("Andrei", "Andrei", "0753113460", "Family", "traian@gmail.com", RandomStringUtils.randomAlphanumeric(8)
        );

        Set<Contact> contacts = new TreeSet<>((o1, o2) -> {
            int comp = 0;
            comp = o1.getLastName().compareTo(o2.getLastName());
            if (comp == 0) {
                comp = o1.getFirstName().compareTo(o2.getFirstName());
                if (comp == 0) {
                    return o1.getNumber().compareTo(o2.getNumber());
                }
            }
            return comp;
        });
        contacts.add(contact);
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        contacts.add(contact7);
        Set<String> groupSet = new HashSet<>();
        groupSet.add("Family");
        groupSet.add("Work");
        groupSet.add("Friends");
        System.out.println(contacts);
        ContactList contactList = new ContactList(contacts, groupSet);
        contactList.doMenu();

    }
}
