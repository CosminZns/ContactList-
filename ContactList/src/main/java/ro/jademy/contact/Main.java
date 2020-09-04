package ro.jademy.contact;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Contact contact = new Contact("Andreescu", "Mihai", "0723123456", Group.FAMILY, "andrei@gmail.com");
        Contact contact1 = new Contact("Andreescu", "Andrei", "0723135456", Group.FRIENDS, "mihai@gmail.com");
        Contact contact2 = new Contact("Marinescu", "Vlad", "0723123890", Group.FAMILY, "vlad@gmail.com");
        Contact contact3 = new Contact("Basescu", "Traian", "0723123456", Group.WORK, "traian@gmail.com");
        Contact contact4 = new Contact("Popa", "Carmen", "0728193156");
        Contact contact5 = new Contact("Lazar", "Andreea", "0723823459");
        Contact contact6 = new Contact("Vasile", "Mihaela", "0753113469");
        Contact contact7 = new Contact("Vasile", "Mihaela", "0753113468");

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
        contacts.add(contact6);
        contacts.add(contact7);
        System.out.println(contacts);
    }
}
