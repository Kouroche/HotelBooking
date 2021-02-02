package hotelbooking;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.Statement;

public class CustMethods {
    
    private static Scanner sc = new Scanner(System.in);
    private static Statement sqlStatement = null; //Statement skapar ett object men det är  inte instansierat än.
    
    
    public static void createAnAccount() throws SQLException{
        System.out.println("");
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
    
    public static void fileWriterWithUpdates() {
        //FileWriter med uppdateringar! Inte längre skriva över.
        try {
            FileWriter c = new FileWriter("customers.txt", true);
            BufferedWriter cBuff = new BufferedWriter(c);
            cBuff.write("Welcome to Java Class!");
            cBuff.newLine();
            cBuff.close();  
            c.close(); 
            System.out.println("\nFile BUFFERED file writer successfully written");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void fileReaderTest() {
        //FileReader-försök.
        System.out.println("");
        try {
            FileReader r = new FileReader("customers.txt");
            BufferedReader rBuff = new BufferedReader(r);
            int i;
            while ((i = rBuff.read()) != -1) {
                System.out.print((char) i);
            }
            rBuff.close();  
            r.close(); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
}
