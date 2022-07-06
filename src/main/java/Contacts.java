public class Contacts {
    public static String first_name;
    public static String last_name;
    public static String Address;
    public static String city;
    public static String state;
    public static int zip;
    public static long phone_number;
    public static String email;

    public Contacts(String first_name, String last_name,String Address,String city,String state,int zip, long phone_number, String email) {
        this.first_name=first_name;
        this.last_name=last_name;
        this.Address=Address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phone_number=phone_number;
        this.email=email;

    }

    /**
     * @return the first_name
     */
    public static String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public static void setFirst_name(String first_name) {
        Contacts.first_name = first_name;
    }

    public static String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public static void setLast_name(String last_name) {
        Contacts.last_name = last_name;
    }


    /**
     * @return the city
     */
    public static String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public static void setCity(String city) {
        Contacts.city = city;
    }

    /**
     * @return the zip
     */
    public static int getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public static void setZip(int zip) {
        Contacts.zip = zip;
    }

    /**
     * @return the state
     */
    public static String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public static void setState(String state) {
        Contacts.state = state;
    }

    public String toString()
    {
        return " Address book contact details are as follows : \nFirst Name is :"+first_name+"\nLast Name is "+last_name+"\nAddress is :"+Address+"\nCity is "+city
                +"\nState is "+state+"\nZip"+zip+"\nPhone number  is "+phone_number+"\nEmail id is "+email;
    }


}
