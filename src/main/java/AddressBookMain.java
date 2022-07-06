import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to addressBook ");
        FileHandler f=new FileHandler();
        Scanner sc=new Scanner(System.in);
        System.out.println();
        while(true) {
            System.out.println(" Enter the choice:\n 1. Add Address Book\n 2. Add contacts\n 3. Display contacts\n 4. "
                    + "Edit contact\n 5. Delete Contac\n 6. View by city\n"
                    + " 7.view by state\n 8.sort Alphabatically\n 9 sorted by city\n 10 file write\n 11. file read");
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
                    f.writeintofile();
                case 11:
                    f.readFromFile();
                default:
                    System.out.println("Enter valid choice");
            }

        }
    }
}
