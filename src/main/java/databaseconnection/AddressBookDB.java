package databaseconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookDB implements IAddressBookDB{
    Connection connection = (new DBConnection()).getConnection() ;
    Statement statement;
    ResultSet resultSet;
    @Override
    public void getData() {
        String retrieveQuery = "select * from address_book_table;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(retrieveQuery);
            while(resultSet.next()){
                System.out.println("Address Book first_name: "+resultSet.getString("firstName"));
                System.out.println("Address Book last_name: "+resultSet.getString("lastname"));
                System.out.println("Address Book address: "+resultSet.getString("address"));
                System.out.println("Address Book city: "+resultSet.getString("city"));
                System.out.println("Address Book state: "+resultSet.getString("state"));
                System.out.println("Address Book zip: "+resultSet.getInt("zip"));
                System.out.println("Address Book phone_number: "+resultSet.getLong("phoneNumber"));
                System.out.println("Address Book email: "+resultSet.getString("email"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
