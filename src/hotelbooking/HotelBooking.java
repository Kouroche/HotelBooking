package hotelbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelBooking {

    private static final String url = "jdbc:mysql://localhost:3306/hotel_booking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
                     private static final String password = "EGET PASSWORD";
    private static Statement sqlStatement = null; 
    private static Connection connection = null;
    private static boolean continueLoop = true;
    private static Scanner sc = new Scanner(System.in);
   
    public static void main(String[] args) throws Exception {

        connection = DriverManager.getConnection(url, user, password); 
        try {
            System.out.println("Anslutningen lyckades!");
            sqlStatement = connection.createStatement(); 
            Menus.welcomeMessage();
            Menus.runHotelBooking();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
            System.out.println("Closing Connection to Server");
        }

    }
    
    public static void updateCustomer() throws SQLException {
        
        System.out.println("Enter customer id:");
        int custId = sc.nextInt();
        sc.nextLine();
        
        System.out.print("What do you wish to update?");
        System.out.print("1. Name ");
        System.out.print("2. Phone number ");
        System.out.print("3. Both");
        System.out.print("0. Return to Customer Menu");
        
        int userInput = Menus.userInput(0, 3);

        switch (userInput) {
            case 1:
                System.out.println("Enter new name:");
                String name = sc.nextLine();
                sqlStatement.executeUpdate("UPDATE customer SET cust_name = '" + name + "' WHERE  cust_id = " + custId + ";");
                System.out.print("Name has been updated.\n");
                break;
            case 2:
                System.out.println("Enter new phoneNo");
                int phoneNo = sc.nextInt();
                sc.nextLine();
                sqlStatement.executeUpdate("UPDATE customer SET phoneNo = " + phoneNo + " WHERE  cust_id = " + custId + ";");
                System.out.print("PhoneNo has been updated.\n");
                break;
            case 3:
                System.out.println("Enter new name:");
                String nameBoth = sc.nextLine();
                sqlStatement.executeUpdate("UPDATE customer SET cust_name = '" + nameBoth + "' WHERE  cust_id = " + custId + ";");
                System.out.println("Enter new phoneNo");
                int phoneNoBoth = sc.nextInt();
                sc.nextLine();
                sqlStatement.executeUpdate("UPDATE customer SET phoneNo = " + phoneNoBoth + " WHERE  cust_id = " + custId + ";");
                System.out.print("Name and phoneNo has been updated.\n");
                break;
            case 0:
                System.out.println("You will now return to the Customer Menu");
                Menus.runCustomerMenu();
                break;
        }

    }

    public static void showRooms() throws SQLException {
        ResultSet result = sqlStatement.executeQuery("SELECT * FROM room;");
        // hämta antal kolumner
        int columnCount = result.getMetaData().getColumnCount();
        // hämta alla kolmnnamn
        String[] columnNames = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = result.getMetaData().getColumnName(i + 1);
        }

        // lägg kolumnnamn i string array
        for (String columnName : columnNames) {
            System.out.print(PadRight(columnName));
        }

        while (result.next()) {
            System.out.println();
            // hämta data för alla kolumner för den nuvarande raden
            for (String columnName : columnNames) {
                String value = result.getString(columnName);

                if (value == null) {
                    value = "null";
                }

                System.out.print(PadRight(value));
            }
        }

        System.out.println();

    }

    public static void bookRoom() throws SQLException {
        int roomchoice = 0;
        int customerId = 0;
        int roomId = 0;
        boolean continueLoop2 = true;

        System.out.println("Enter your Customer Number");
        while (continueLoop) {
            try {
                customerId = Integer.parseInt(sc.nextLine());
                if (customerId >= 1 && customerId <= 1000) {
                    continueLoop = false;
                } else {
                    System.out.println(" You can only choose 1-1000 ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers.");
            }
        }

        System.out.println("Choose a Room 'Enter the room number: '");
        while (continueLoop2) {
            try {
                roomchoice = Integer.parseInt(sc.nextLine());
                if (roomchoice >= 1 && roomchoice <= 8) {
                    continueLoop2 = false;
                } else {
                    System.out.println(" You can only choose 1-8 ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers.");
            }
        }

        System.out.println("You Choose room : " + roomchoice + "\n");
        ResultSet result = sqlStatement.executeQuery("SELECT room_id FROM room WHERE  room_id = " + roomchoice + ";");
        //ResultSet result = sqlStatement.executeQuery("SELECT * FROM " + tableName + ";");

        int columnCount = result.getMetaData().getColumnCount();
        String[] columnNames = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = result.getMetaData().getColumnName(i + 1);
        }

        while (result.next()) {
            System.out.println();

            for (String columnName : columnNames) {

                String value = result.getString(columnName);
                roomId = Integer.parseInt(value);
            }
        }

        sqlStatement.executeUpdate("UPDATE room SET room_available = 'no' WHERE  room_id = " + roomchoice + ";");
        sqlStatement.executeUpdate("INSERT INTO booking (cust_id, room_id)"
                + "VAlUES (" + customerId + ", " + roomId + ");");

        System.out.println("Your booking is confirmed\n");
        System.out.println("We look forward to have you as a guest \n");

    }

    public static void createAnAccount() throws SQLException {
        String name;
        int phoneNo = 0;
        boolean continueLoop = true;

        System.out.println("\nHow nice that you want to create an account!");
        System.out.println("Let's get started.");

        System.out.print("Please enter your full name:  ");
        name = sc.nextLine();

        System.out.print("Please enter your phone number:  ");
        while (continueLoop) {
            try {
                phoneNo = Integer.parseInt(sc.nextLine());
                if (phoneNo >= 000 && phoneNo <= 999) {
                    continueLoop = false;
                } else {
                    System.out.println("The phonenumber must have three digits.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers.");
            }
        }
        System.out.print("Testrad:" + name + " " + phoneNo + "\n");

        sqlStatement.executeUpdate("INSERT INTO customer (cust_name, phoneNo) VALUES('" + name + "', " + phoneNo + ");");
        System.out.print("Kunden är registrerad.\n");

        //Customer c1 = new Customer(name, phoneNo);
        //System.out.println(c1.toString());
//         Customer c1 = new Customer(name, phoneNo);
//       
//        try {
//           
//            FileOutputStream f = new FileOutputStream(new File("myCustomers.txt"));
//            ObjectOutputStream o = new ObjectOutputStream(f);
//           
//            o.writeObject(c1);
//           
//            o.close();
//            f.close();
//           
//            System.out.println("Du är nu registrerad som kund!");
//           
//        }
//           
//            catch (Exception e){
//                    System.out.println("File ot found");
//                    }
    }

    private static String PadRight(String string) {
        int totalStringLength = 18;
        int charsToPadd = totalStringLength - string.length();

        // incase the string is the same length or longer than our maximum lenght
        if (string.length() >= totalStringLength) {
            return string;
        }

        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < charsToPadd; i++) {
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

}
