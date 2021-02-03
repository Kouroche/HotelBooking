package hotelbooking;

import java.sql.SQLException;
import java.util.Scanner;

public class Menus {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void welcomeMessage() {
        
        System.out.println("**************************************");
        System.out.println("Welcome to Hotel Booking System!");
        System.out.println("**************************************\n");

    }
        
    public static void printStartMenu() {
        
        System.out.println("Choose from the Start menu.");
        System.out.println("1. Customer");
        System.out.println("2. Receptionist");
        System.out.println("0. Exit");

    }

    public static int userInputStartMenu() {
        boolean continueLoop = true;
        int userInput = 0;
        
        while (continueLoop) {
            try {
                userInput = Integer.parseInt(sc.nextLine());
                if (userInput >= 0 && userInput <= 2) {
                    continueLoop = false;
                } else {
                    System.out.println("Choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers");
            }
        }
        return userInput;
    }
    
    public static void switchStartMenu(int userInputStartMenu) throws SQLException {
        
        switch (userInputStartMenu) {
            case 1:
                runCustomerMenu();
                break;
            case 2:
                runReceptionistMenu();
                break;
            case 0:
                System.out.println("\nThank You for using the Hotel Booking System!");
                System.out.println("You will now exit the program\n");
                System.exit(0); //BORDE DET VARA EN BOOLEAN HÄR?
        }
    }
    
    public static void runHotelBooking() throws SQLException {
        int userInputStartMenu;
        
        printStartMenu();
        userInputStartMenu = userInputStartMenu();
        switchStartMenu(userInputStartMenu);
        
    }
    
    public static void printCustomerMenu() {
        
        
        System.out.println("What would you like to do?");
        System.out.println("1. Create an account");
        System.out.println("2. Update your account");
        System.out.println("3. Book a Room");
        System.out.println("4. Update your booking");
        System.out.println("5. Order food");
        System.out.println("6. Check out");
        System.out.println("0. Return to Start menu");

    }
    
    public static int userInput(int a, int b) {
        boolean continueLoop = true;
        int userInput = 0;
        
        while (continueLoop) {
            try {
                userInput = Integer.parseInt(sc.nextLine());
                if (userInput >= a && userInput <= b) {
                    continueLoop = false;
                } else {
                    System.out.println("Choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers");
            }
        }
        return userInput;
    }
    
    public static int userInputCustomerMenu() {
        boolean continueLoop = true;
        int userInput = 0;
        
        while (continueLoop) {
            try {
                userInput = Integer.parseInt(sc.nextLine());
                if (userInput >= 0 && userInput <= 6) {
                    continueLoop = false;
                } else {
                    System.out.println("Choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers");
            }
        }
        return userInput;
    }
   
    private static void switchCustomerMenu(int userInputCustomerMenu) throws SQLException {

            switch (userInputCustomerMenu) {
                case 1:
                    HotelBooking.createAnAccount();
                    break;
                case 2:
                    HotelBooking.updateCustomer();
                    break;
                case 3:
                    HotelBooking.showRooms();
                    HotelBooking.bookRoom();
                    //Method...
                    break;
                case 4:
                    //Method...
                    break;
                case 5:
                    OrderFood.printFoodMenu();
                    OrderFood.yourOrder();
                    
                    //int userInput = userInput(0, 6);
                    //OrderFood.switchFoodMenu(userInput);
                    break;
                case 6:
                    HotelBooking.checkOut();
                    break;
                case 0:
                    System.out.println("You will now return to the Start Menu\n");
                    runHotelBooking();
                    break;
            }
        
    }
    
    public static void runCustomerMenu() throws SQLException {
        int userInputCustomerMenu;
        boolean continueLoop = true;
        
        while (continueLoop) {
        printCustomerMenu();
        userInputCustomerMenu = userInputCustomerMenu();
        switchCustomerMenu(userInputCustomerMenu);
        }
        
    }

    public static void printReceptionistMenu() {
        
        System.out.println("\nWelcome Dear receptionist!");
        System.out.println("What would you like to do?");
        System.out.println("1. Register customer");
        System.out.println("2. Update customer");
        System.out.println("3. Delete customer");
        System.out.println("4. Search customer");
        System.out.println("5. Book room");
        System.out.println("6. Update booking");
        System.out.println("7. Delete booking");
        System.out.println("8. Order food");
        System.out.println("9. Billing / Check out");
        System.out.println("0. Return to Start menu");

    }
    
    public static int userInputReceptionistMenu() {
        boolean continueLoop = true;
        int userInput = 0;
        
        while (continueLoop) {
            try {
                userInput = Integer.parseInt(sc.nextLine());
                if (userInput >= 0 && userInput <= 9) {
                    continueLoop = false;
                } else {
                    System.out.println("Choose a number from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input only numbers");
            }
        }
        return userInput;
    }
    
    private static void switchReceptionistMenu(int userInputReceptionistMenu) throws SQLException {
        
            switch (userInputReceptionistMenu) {
                case 1:
                    //Method...
                    break;
                case 2:
                    //Method...
                    break;
                case 3:
                    //Method...
                    break;
                case 4:
                    //Method...
                    break;
                case 5:
                    //Method...
                    break;
                case 6:
                    //Method...
                    break;
                case 7:
                    //Method...
                    break;
                case 8:
                    //Method...
                    break;
                case 9:
                    //Method...
                    break;
                case 0:
                    System.out.println("You will now return to the Start Menu\n");
                    runHotelBooking();
                    break;
            }
    }
    
    public static void runReceptionistMenu() throws SQLException {
        int userInputReceptionistMenu;
        boolean continueLoop = true;

        while (continueLoop) {
        printReceptionistMenu();
        userInputReceptionistMenu = userInputReceptionistMenu();
        switchReceptionistMenu(userInputReceptionistMenu);
        }
    }
    
}
