package ro.jademy.contact;

public class Main {
    public static void main(String[] args) {

        ContactList contactList = new ContactList(DataSource.createContacts(), DataSource.createGroups());
        contactList.doMenu();
        //exceptions to add
        //change to phone Object
    }
}
