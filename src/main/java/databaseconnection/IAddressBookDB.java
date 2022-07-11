package databaseconnection;

public interface IAddressBookDB {
    void getData();

    void updateData(String field,String setField,String address_book,String first_name);
}
