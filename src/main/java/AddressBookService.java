import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;

public class AddressBookService {

    static Scanner sc=new Scanner(System.in);
    public static ArrayList<Contacts> listOfContacts;
    public static HashMap<String,List<Contacts>> hashAddressBook=new HashMap<>();
    public static HashMap<String, String> dictforcity=new HashMap<>();
    public static HashMap<String, String> dictforstate=new HashMap<>();
    public static ArrayList<Contacts> findAddressBook(String name){
        for(Entry<String, List<Contacts>> iterator:hashAddressBook.entrySet()) {
            if(iterator.getKey().equals(name)) {
                return (ArrayList<Contacts>) iterator.getValue();
            }
        }

        return null;
    }
    public static String addAddressBook(){
        System.out.println("Please Enter the Address book name");
        String addressBookName=sc.next();
        if(findAddressBook(addressBookName)!=null) {
            System.out.println("this book exists");
            System.out.println(hashAddressBook.get(addressBookName));
            return null;
        }
        return addressBookName;

    }
    public static int findContactAddress(ArrayList<Contacts> arrayList) {
        System.out.println("Enter the name");
        String editname=sc.next();
        for(Contacts contact:arrayList) {
            if(editname.compareToIgnoreCase(contact.getFirst_name())==0){
                return arrayList.indexOf(contact);
            }
        }
        return 0;
    }
    public static void addContacts(String bookName) {
        System.out.println("Please enter your first name :");
        String first_name = sc.next();
        System.out.println("Please enter your last name :");
        String last_name = sc.next();
        sc.nextLine();
        System.out.println("Please enter your Address :");
        String Address = sc.nextLine();
        System.out.println("Please enter your city :");
        String city = sc.next();
        System.out.println("Please enter your state :");
        String state = sc.next();
        System.out.println("enter the zip");
        int zip=sc.nextInt();
        System.out.println("Please enter your phone number :");
        long phone_number = sc.nextLong();
        System.out.println("Please enter your email id :");
        String email = sc.next();
        Contacts contact=new Contacts(first_name,last_name,Address,city,state,zip,phone_number,email);
        if(findAddressBook(bookName)!=null) {
            hashAddressBook.get(bookName).add(contact);
            return;
        }
        listOfContacts =new ArrayList<Contacts>();
        listOfContacts.add(contact);
//	    listOfContacts.add(new Contacts(first_name,last_name,Address,city,state,zip,phone_number,email));
        hashAddressBook.put(bookName, listOfContacts);
    }

    public static void delete() {
        System.out.println("Enter the address book you want to edit");
        String deleteBook=sc.next();
        ArrayList<Contacts> list=findAddressBook(deleteBook);
        if(list.isEmpty()) {
            System.out.println("this address book is empty");
            return;
        }
        else if(list==null) {
            System.out.println("This address book desenot exist");
            return;
        }
        int ans=findContactAddress(list);
        if(ans==0) {
            System.out.println("Address not found");
            return;
        }System.out.println("Deleted the Scussefully");
        list.remove(ans);
    }
    public static void edit() {
        System.out.println("Enter the address book you want to edit");
        String editBook=sc.next();
        ArrayList<Contacts> list=findAddressBook(editBook);
        if(list.isEmpty()) {
            System.out.println("this address book is empty");
            return;
        }
        else if(list==null) {
            System.out.println("This address book not exist");
            return;
        }
        int ans=findContactAddress(list);
        if(ans==0) {
            System.out.println("Address not found");
            return;
        }System.out.println("found the contact");
        list.remove(ans);
        addContacts(editBook);
    }
    @FunctionalInterface
    interface InterCheckDuplicate{
        boolean checkDuplicate(String First_name,String Last_name);
    }
    public static boolean duplicate(String bookName,String First_name,String Last_name) {
        if(hashAddressBook.get(bookName)==null) {
            return true;
        }
        ArrayList<Contacts> list=(ArrayList<Contacts>) hashAddressBook.get(bookName);
        HashMap<String, String> name=new HashMap<>();
        for(Contacts contact:listOfContacts) {
            name.put(contact.getFirst_name(),contact.getLast_name());

        }
        InterCheckDuplicate checkduplicates=((first_name,last_name)->{
            if(first_name.equals(name)&&last_name.equals(name)) {
                return false;
            }
            return true;
        });
        Boolean toDuplicates = name.entrySet().stream().anyMatch(names->checkduplicates.checkDuplicate(names.getKey(),names.getValue()));
        return toDuplicates;

    }
    public static void viewCity(String city) {
        dictforcity.entrySet().stream().filter(a->a.getValue().equals(city)).forEach(a->System.out.println(a));
        long countCity=dictforcity.entrySet().stream().map(a->a.getValue().equals(city)).count();
        System.out.println("City count by person"+countCity);
    }
    public static void viewState(String state) {
        dictforstate.entrySet().stream().filter(a->a.getValue().equals(state)).forEach(a->System.out.println(a));
        long countstate=dictforstate.entrySet().stream().map(a->a.getValue().equals(state)).count();
        System.out.println("count state by person"+countstate);
    }
    public static void sortAlphabatically() {
        System.out.println("Enter the name of adddress book");
        String name=sc.next();
        if(hashAddressBook.get(name).isEmpty()) {
            System.out.println("Book is empty");
            return;
        }
        hashAddressBook.get(name).stream().sorted((c1,c2)->c1.getFirst_name().compareToIgnoreCase(c2.getFirst_name())).forEach(c->System.out.println(c));
    }
    public static void sortByCity()
    {
        System.out.println("Sorted by city names:");
        hashAddressBook.values().forEach((n)->{
            n.stream().sorted((c1,c2) -> {
                return c1.getCity().compareToIgnoreCase(c2.getCity());
            }).forEach(n1-> System.out.println(n1));
        });
    }


    public static void display() {
        System.out.println("Enter the name of the address book you want see");
        String name=sc.next();
        if(hashAddressBook.get(name).isEmpty()) {
            System.out.println("this is emty");
            return;
        }
        System.out.println(hashAddressBook.get(name));

    }

}
