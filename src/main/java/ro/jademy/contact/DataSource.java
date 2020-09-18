package ro.jademy.contact;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.*;

public class DataSource {
    private static Scanner sc = new Scanner(System.in);
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

    public static Set<Contact> readContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
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

    public static void saveContacts(Set<Contact> contacts, String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            contacts.forEach(contact -> {
                try {
                    bufferedWriter.write(contact.getLastName() + "," + contact.getFirstName() + "," + contact.getNumber().getNumbers() + "," +
                            contact.getNumber().getSuffix() + "," + contact.getGroup() + "," + contact.getEmail() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Failed to write line in file");
            e.printStackTrace();
        }
    }

    public static void showOptions() {
        System.out.println("1.Create a Back Up File");
        System.out.println("2.Load Back Up File/Copy");
        //2.Creat director-salvat backUp files acolo
                          //-listat array de files ->copiat selected File in contacts.csv

        System.out.println("3.View Back Up File details");

    }

    //Scoatere parametrii cand ii mut in ContactList (Set<Contact> am deja acces ), String name/pathName voi face o variabila globala
    public static void backUpMenu() {
        showOptions();
        int decison = sc.nextInt();
        switch (decison) {
            case 1:
                //createBackUp();
                break;
            case 2:
                //Pentru a citi backUp file apelam readContacts cu alt parametru de file Name
                //System.out.println(readContacts());
                break;
            case 3:
                // getBackUpFileDetails();
                break;
        }
    }

    public static void getBackUpFileDetails(String name) {
        File file = new File(name);

        if (file.exists()) {
            System.out.println("The path of your back up file is " + file.getAbsolutePath());
            System.out.println("The name of your file is  " + file.getName());
            System.out.println("Last time the file was modifed was: " + file.lastModified());
        } else {
            System.out.println("You don't have a back up file created");
        }
    }

    public static void createBackUp(String namePath, Set<Contact> contacts) {
        //defaut backUp+date
        //custom backUp+scanner
        System.out.println("Do you want to enter a custom name ?");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("y")) {
            System.out.println("Please enter a path");
            decision = sc.next();
            //aici verificare de path pentru variabila decison -> probabil un try/catch
            createFile(decision, contacts);
        } else {
            createFile(namePath, contacts);
        }
    }

    public static void createFile(String namePath, Set<Contact> contacts) {
        File file = new File(namePath);
        try {
            if (file.createNewFile()) {
                saveContacts(contacts, namePath);
                System.out.println("You created a backUp file");
            } else {
                System.out.println("You already have a backUp file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


