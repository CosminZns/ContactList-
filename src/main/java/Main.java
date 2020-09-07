package ro.jademy.contact;

public class Main {
    public static void main(String[] args) {

        ContactList contactList = new ContactList(DataSource.createContacts(), DataSource.createGroups());
        contactList.doMenu();

        //problem with constructors
        //problem with BinarySearch


    }
}
