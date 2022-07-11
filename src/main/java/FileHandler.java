import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    public static void readFromFile()  {
        File file=new File("src/main/resources/AddressBook.txt");
        try {
            FileReader f=new FileReader(file);
            int i;
            while((i=f.read())!=-1)
                System.out.print((char)i);
            f.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static void writeintofile() {
        try {
            File file=new File("src/main/resources/AddressBook.txt");
            FileWriter f=new FileWriter(file);
            f.append(AddressBookService.listOfContacts.toString());
//			f.write(AddressBookService.listOfContacts.toString());
            f.close();
        }catch(Exception e) {

        }
    }
    public static void gsonWrite() {
        try {
            Gson gson = new Gson();
            File file = new File("src/main/resources/AddressBook.json");
            FileWriter fileWriter = new FileWriter(file);
            String jsonString = gson.toJson(AddressBookService.listOfContacts.toArray());
            System.out.println(jsonString);
            fileWriter.write(jsonString);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }    }

