package ro.jademy.contact;

import java.util.ArrayList;
import java.util.List;

public  class DataSource {



    public static List<Contact> returnContacs(){
//        Contact contact = new Contact("Andreescu", "Andrei", "0723123456", "Family", "andrei@gmail.com");
//        Contact contact1 = new Contact("Alexandrescu", "Mihai", "0723135456","Work", "mihai@gmail.com");
//        Contact contact2 = new Contact("Marinescu", "Vlad", "0723123890", "Friends", "vlad@gmail.com");
//        Contact contact3 = new Contact("Basescu", "Traian", "0723123456", "Work", "traian@gmail.com");
        Contact contact4 = new Contact("Popa", "Carmen", "0728193156");
        Contact contact5 = new Contact("Lazar", "Andreea", "0723823459");
        Contact contact6 = new Contact("Vasile", "Mihaela", "0753113469");
        List<Contact> contacts= new ArrayList<>();
//        contacts.add(contact);
//        contacts.add(contact1);
//        contacts.add(contact2);
//        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        contacts.add(contact6);
        return contacts;
    }
}
