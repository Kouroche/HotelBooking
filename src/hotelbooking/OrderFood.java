package hotelbooking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderFood {
    
    private static Scanner sc = new Scanner(System.in);
    private static List<String> foodItems = new ArrayList<>();
    private static List<Integer> foodPrice = new ArrayList<>();
    
    public static void printFoodMenu() {
        
        System.out.println("Please choose from the Menu:");
        System.out.println("1. Hamburger\t\t 110 kr");
        System.out.println("2. Pasta Bolognese\t 150 kr");
        System.out.println("3. Orange juice\t\t 20 kr");
        System.out.println("4. Beer\t\t\t 50 kr");
        System.out.println("0. Return to Customer Menu");
        
    }
    
    public static void yourOrder() throws SQLException {
        boolean continueLoop = true;

        while (continueLoop) {
            int userInput = Menus.userInput(0, 4);

            switch (userInput) {
                case 1:
                    String hamburger = "Hamburger";
                    foodItems.add(hamburger);
                    System.out.println(foodItems);
                    int priceH = 110;
                    foodPrice.add(priceH);
                    System.out.println(foodPrice);
                    break;
                case 2:
                    String pasta = "Pasta Bolognese";
                    foodItems.add(pasta);
                    System.out.println(foodItems);
                    int priceP = 150;
                    foodPrice.add(priceP);
                    System.out.println(foodPrice);
                    break;
                case 3:
                    String juice = "Orange juice";
                    foodItems.add(juice);
                    System.out.println(foodItems);
                    int priceJ = 20;
                    foodPrice.add(priceJ);
                    System.out.println(foodPrice);
                    break;
                case 4:
                    String beer = "Beer";
                    foodItems.add(beer);
                    System.out.println(foodItems);
                    int priceB = 50;
                    foodPrice.add(priceB);
                    System.out.println(foodPrice);
                    break;
                case 0:
                    System.out.println("You will now return to the Customer Menu\n");
                    Menus.runCustomerMenu();
                    break;
            }
            boolean continueLoop2 = true;
            do {
                System.out.println("Do you want to order something more? y/n");
                String yesOrNo = sc.nextLine();
                if (yesOrNo.equals("y")) {
                    System.out.println("What else do want to order?");
                    continueLoop2 = false;
                } else if (yesOrNo.equals("n")) {
                    System.out.println("You have ordered:");
                    System.out.println(foodItems);
                    System.out.println("Total cost for your order:");
                    long sum = foodPrice.stream()
                            .mapToInt(Integer::valueOf)
                            .sum();
                    System.out.println(sum + " kr");
                    continueLoop2 = false;
                    continueLoop = false;
                } else {
                    System.out.println("You must choose y/n. Try again.");
                } 
            } while (continueLoop2);

        }

    }

}
