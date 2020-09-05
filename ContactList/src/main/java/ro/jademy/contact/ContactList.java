package ro.jademy.contact;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ContactList {

    private Set<Contact> contacts;
    private Set<String> groupSet;
    private Scanner sc = new Scanner(System.in);


    public ContactList( Set<Contact> contacts, Set<String> groupSet ) {
        this.contacts = contacts;
        this.groupSet = groupSet;
    }

    public void doMenu() {
        showMenu();
        System.out.println("Please enter your option");
        int decision = sc.nextInt();
        switch (decision) {
            case 1:
                showContacts();
                doMenu();
                break;
            case 2:
                binarySearchContact();
                //searchContact();
                doMenu();
                break;
            case 3:
                addContact();
                System.out.println(contacts);
                doMenu();
                break;
            case 4:
                deleteContact();
                doMenu();
                break;
            case 5:
                editContact();
                doMenu();
                break;
            default:
                System.out.println("Invalid command. Please enter your option again");
                doMenu();
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

    private void addContact() {
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
            //validate email method -> progress
            System.out.println("Input group");
            String groupInput = sc.next();
            boolean check = false;
            for (String group : groupSet) {
                check = groupInput.equalsIgnoreCase(group);
            }
            if (check) {
                Contact contact = new Contact(firstName, lastName, number, groupInput, email, RandomStringUtils.randomAlphanumeric(8));
                contacts.add(contact);
                System.out.println("You added " + contact.getFirstName() + "to your contacts");

            } else {
                System.out.println("Group " + groupInput + "created");
                groupSet.add(groupInput);
                Contact contact = new Contact(firstName, lastName, number, groupInput, email, RandomStringUtils.randomAlphanumeric(8));
                contacts.add(contact);
                System.out.println("You added " + contact.getFirstName() + "to your contacts");
            }

        } else {
            Contact contact = new Contact(firstName, lastName, number);
            contacts.add(contact);
            System.out.println("You added " + contact.getFirstName() + "to your contacts");
        }
    }

    //add group
    private void searchContact() {
        System.out.println("Please enter letter sequence");
        String pattern = sc.next();
        contacts.stream().filter(p -> p.getLastName().contains(pattern)).forEach(System.out::println);

    }
    private void binarySearchContact() {
        System.out.println("choose the ID of the contact you want to change");
        String option = sc.next();
        Contact editedContact = contacts.stream().filter(contact -> contact.getId().equals(option))
                .findAny().get();
        List<Contact> contactList = new ArrayList<>(contacts);
        System.out.println(contactList);
        System.out.println(contactList.get(Collections.binarySearch(contactList,editedContact)));

    }

    private void showContacts() {
        System.out.println(getContactHeader());
        int i = 0;
        for (Contact contact : contacts) {
            String padding = i < 9 ? " " : "";
            System.out.println(padding + (i + 1) + ". " + contact);
            i++;
        }
    }

    private String getContactHeader() {
        return StringUtils.center("  ID", 12, " ") +
                StringUtils.center("  FIRST NAME", 20, " ") +
                StringUtils.center("  LAST NAME", 16, " ") +
                StringUtils.center(" PHONE NUMBER", 16, ' ') +
                StringUtils.center("GROUP", 12, ' ') +
                StringUtils.center("    EMAIL ADDRESS   ", 20, ' ');

    }

    private void editContact() {
        showContacts();
        System.out.println("choose the ID of the contact you want to change");
        String option = sc.next();
        System.out.println("Contact to be edited");
        Contact editedContact = contacts.stream().filter(contact -> contact.getId().equals(option))
                .findAny().get();
        System.out.println(editedContact);
        changeContact(editedContact);
    }

    private void changeContact( Contact editedContact ) {
        System.out.println("Please enter the field you want to change");
        System.out.println("1.First Name");
        System.out.println("2.Last Name");
        System.out.println("3.Phone number");
        System.out.println("4.Group");
        System.out.println("5.Email address");
        System.out.println("6.Change all information");
        int option = sc.nextInt();
        String edited = null;
        switch (option) {
            case 1:
                System.out.println("Enter new First Name");
                edited = sc.next();
                editedContact.setFirstName(edited);
                System.out.println("Contact first name changed to: " + edited);
                break;
            case 2:
                System.out.println("Enter new Last Name");
                edited = sc.next();
                editedContact.setLastName(edited);
                System.out.println("Contact last name changed to: " + edited);
                break;
            case 3:
                System.out.println("Enter new phone number");
                edited = sc.next();
                editedContact.setNumber(edited);
                System.out.println("Contact phone number changed to: " + edited);
                break;
            case 4:
                System.out.println("Enter new group");
                edited = sc.next();
                addGroup(editedContact, edited);
                System.out.println("Contact group changed to: " + edited);
                break;
            case 5:
                System.out.println("Enter new email");
                edited = sc.next();
                editedContact.setEmail(edited);
                System.out.println("Contact email changed to: " + edited);
                break;
            default:
                System.out.println("Enter new First Name");
                edited = sc.next();
                editedContact.setFirstName(edited);
                System.out.println("Enter new Last Name");
                edited = sc.next();
                editedContact.setLastName(edited);
                System.out.println("Enter new phone number");
                edited = sc.next();
                editedContact.setNumber(edited);
                System.out.println("Enter new group");
                edited = sc.next();
                addGroup(editedContact, edited);
                System.out.println("Enter new email");
                edited = sc.next();
                editedContact.setEmail(edited);
                System.out.println(editedContact);
                break;
        }
    }

    private void addGroup( Contact editedContact, String groupInput ) {
        boolean check = false;
        for (String group : groupSet) {
            if (groupInput.equalsIgnoreCase(group)) {
                check = true;
            } else {
                check = false;
            }
        }
        if (check) {
            editedContact.setGroup(groupInput);
        } else {
            groupSet.add(groupInput);
            editedContact.setGroup(groupInput);
            System.out.println("New group " + groupInput + " created");
        }
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
