package ro.jademy.contact;

import java.io.File;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

//        ContactList contactList = new ContactList(DataSource.createContacts(), DataSource.createGroups());
//        contactList.doMenu();
        File file = new File("src/main/java/ro/jademy/contact");
        System.out.println(Arrays.toString(file.list()));


        //-schimbat Clasa PHONE Number
        //-refactorizat in DataSource -in write/read
        //sters groupSet din contactList
        //mutat tot ce tine de backUp in contactList

    }
}
