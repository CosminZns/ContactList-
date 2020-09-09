package ro.jademy.contact;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataSource {
    private static final String FILE_NAME = "contacts.csv";


    //public static Set<Contact> createContacts() {


    //        Contact contact = new Contact("Andreescu", "Andrei", "0723123456", "Family", "andrei@gmail.com", RandomStringUtils.randomAlphanumeric(8));
//        Contact contact1 = new Contact("Alexandrescu", "Mihai", "0723135456", "Work", "mihai@gmail.com", RandomStringUtils.randomAlphanumeric(8));
//        Contact contact2 = new Contact("Marinescu", "Vlad", "0723123890", "Friends", "vlad@gmail.com", RandomStringUtils.randomAlphanumeric(8));
//        Contact contact3 = new Contact("Basescu", "Traian", "0723123456", "Work", "traian@gmail.com", RandomStringUtils.randomAlphanumeric(8));
//        Contact contact4 = new Contact("Popa", "Carmen", "0728193156", "Work", "traian@gmail.com", RandomStringUtils.randomAlphanumeric(8));
//        Contact contact5 = new Contact("Lazar", "Andreea", "0723823459", "Friends", "traian@gmail.com", RandomStringUtils.randomAlphanumeric(8));;
//        Contact contact6 = new Contact("Vasile", "Andrei", "0753113460", "Family", "traian@gmail.com", RandomStringUtils.randomAlphanumeric(8));;
//        Set<Contact> contacts = new TreeSet<>();
//        contacts.add(contact);
//        contacts.add(contact1);
//        contacts.add(contact2);
//        contacts.add(contact3);
//        contacts.add(contact4);
//        contacts.add(contact5);
//        contacts.add(contact6);
//        return contacts;
//    }
//
//    public static Set<String> createGroups() {
//        Set<String> groupSet = new HashSet<>();
//        groupSet.add("Family");
//        groupSet.add("Work");
//        groupSet.add("Friends");
//        return groupSet;
//    }
    public static Set<Contact> createContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String header = reader.readLine();
            System.out.println(header);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(",");
                Contact contact = new Contact(
                        RandomStringUtils.randomAlphanumeric(8),
                        strings[0],
                        strings[1],
                        new PhoneNumber(Arrays.asList(strings[2].split("'")), strings[3]),
                        strings[4],
                        strings[5]);
                contacts.add(contact);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File " + FILE_NAME + " not found on disk");
        } catch (IOException ex) {
            System.out.println("Failed to read line from file");
        }
        return new TreeSet<>(contacts);
    }

}
