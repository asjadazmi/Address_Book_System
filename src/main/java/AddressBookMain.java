import databaseconnection.AddressBookDB;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to addressBook ");

        Scanner sc=new Scanner(System.in);
        AddressBookDB addressBookDB = new AddressBookDB();
        System.out.println();
        while(true) {
            System.out.println(" Enter the choice:\n 1. Add Address Book\n 2. Add contacts\n 3. Display contacts\n 4. "
                    + "Edit contact\n 5. Delete Contact\n 6. View by city\n"
                    + " 7.view by state\n 8.sort Alphabetically\n 9 sorted by city\n 10 file write\n 11. file read\n" +
                    "12. write in json\n 13 retrieving all the data from sql\n 15 updating using jdbc");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    AddressBookService.addAddressBook();
                    break;
                case 2:
                    System.out.println("Enter the address book name");
                    String addressBook=sc.next();
                    AddressBookService.addContacts(addressBook);
                    break;
                case 3:
                    AddressBookService.display();
                    break;
                case 4:
                    AddressBookService.edit();
                case 5:
                    AddressBookService.delete();
                    break;
                case 6:
                    System.out.println("Enter the city");
                    String city=sc.next();
                    AddressBookService.viewCity(city);
                case 7:
                    System.out.println("Enter the state");
                    String State=sc.next();
                    AddressBookService.viewState(State);
                case 8:
                    AddressBookService.sortAlphabatically();
                case 9:
                    AddressBookService.sortByCity();
                case 10:
                    FileHandler.writeintofile();
                case 11:
                    FileHandler.readFromFile();
                case 12:
                    FileHandler.gsonWrite();
                case 13:
                    addressBookDB.getData();
                case 14:
                    System.out.println("Enter the address book name");
                    String name = sc.next();
                    System.out.println("Enter the first name");
                    String first_name = sc.next();
                    System.out.println("Enter the updated address");
                    String address = sc.nextLine();
                    addressBookDB.updateData("address",address,name,first_name);
                    break;
                default:
                    System.out.println("Enter valid choice");
            }

        }
    }
}
