package ro.jademy.contact;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class ContactList {

    private Set<Contact> contacts;
    private Set<String> groupSet;
    private Scanner sc = new Scanner(System.in);


    public ContactList(Set<Contact> contacts, Set<String> groupSet) {
        this.contacts = contacts;
        this.groupSet = groupSet;
    }

    public void doMenu() {
        showMenu();
        System.out.println("Please enter your option");
        try {
            int decision = sc.nextInt();
            switch (decision) {
                case 3:
                    addConact();
                    System.out.println(contacts);
                case 2:
                    searchContact();
                case 4:
                    deleteContact();
                    System.out.println(contacts);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input please try again");
        }
    }


    private void showMenu() {
        System.out.println("Contact List");
        System.out.println("1.Display Contacts");
        System.out.println("2.Search Contact");
        System.out.println("3.Add Contact");
        System.out.println("4.Delete Contact");
        System.out.println("5.Edit Contact");
    }

    private void addConact() {
        System.out.println("Input first name");
        String firstName = sc.next();
        System.out.println("Input last name");
        String lastName = sc.next();
        System.out.println("Input number");
        String number = sc.next();
        System.out.println("Do you want to add a group and email ? y/n ");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("y")) {
            System.out.println("Input email");
            String email = sc.next();
            //validate email method -> progres
            System.out.println("Input group");
            String groupInput = sc.next();
            boolean check = false;
            for (String group : groupSet) {
                check = groupInput.equalsIgnoreCase(group);
            }
            if (check) {
                Contact contact = new Contact(firstName, lastName, number, groupInput, email, RandomStringUtils.randomAlphanumeric(8)
                );
                contacts.add(contact);
                System.out.println("You added " + contact.getFirstName() + "to your contacts");

            } else {
                System.out.println("Group " + groupInput + "created");
                groupSet.add(groupInput);
                Contact contact = new Contact(firstName, lastName, number, groupInput, email,RandomStringUtils.randomAlphanumeric(8)
                );
                contacts.add(contact);
                System.out.println("You added " + contact.getFirstName() + "to your contacts");
            }

        } else {
            Contact contact = new Contact(firstName, lastName, number);
            contacts.add(contact);
            System.out.println("You added " + contact.getFirstName() + "to your contacts");
        }
    }


    private void searchContact() {
        System.out.println("Please enter the last name or a sequence to find the contact");
        String pattern = sc.next();
        contacts.stream().filter(p -> p.getLastName().contains(pattern)).forEach(System.out::println);
    }

    private void deleteContact() {
        System.out.println("What contact you want to delete?");
        System.out.println(contacts);
        searchContact();
        System.out.println("Input number");
        String id = sc.next();
        if (contacts.removeIf(contact -> contact.getId().equals(id))) {
            System.out.println("Removed successfully ");
        } else {
            System.out.println("Invalid id please try again");
            deleteContact();
        }
    }
}
