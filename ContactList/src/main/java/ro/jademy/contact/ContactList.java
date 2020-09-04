package ro.jademy.contact;

import java.util.Scanner;
import java.util.Set;

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
        int decision = sc.nextInt();
        switch (decision) {
            case 1:
                addConact();
                System.out.println(contacts);
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
                if (groupInput.equalsIgnoreCase(group)) {
                    check = true;
                } else {
                    check = false;
                }
            }
            if (check) {
                Contact contact = new Contact(firstName, lastName, number, groupInput, email);
                contacts.add(contact);
                System.out.println("You added " + contact.getFirstName() + "to your contacts");

            } else {
                System.out.println("Group " + groupInput + "created");
                groupSet.add(groupInput);
                Contact contact = new Contact(firstName, lastName, number, groupInput, email);
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
    private void search() {
        System.out.println("Please enter letter sequence");
        String pattern = sc.next();
        contacts.stream().filter(p->p.getLastName().contains(pattern)).forEach(System.out::println);

    }
}
