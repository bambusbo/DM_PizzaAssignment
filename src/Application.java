import java.util.Scanner;

/**
 * An application to manage orders for a pizzeria
 *<p>
 * https://github.com/bambusbo/DM_PizzaAssignment
 *
 * @author  Morten Kristensen, Tester: Vanda
 * @version 1.0
 * @since   07/10/2020
 *
 *
 */

public class Application {
    //Setup static variables so we can access them in all methods
        //The customer inputs
    static int inputNo = 0;
    static String toppingOption;

        //The user friendly strings
    static String selectedPizza = "";
    static String selectedSize = "";
    static String selectedToppings = "";

        //The price
    static double pizzaPrice = 0;

    // Setup all pizzas as static strings, and setup a price variable as a double for each.
    static String margherita = "1. Margherita: Tomato, Cheese"; static double margheritaPrice = 55;
    static String hawaii = "2. Hawaii: Tomato, Cheese, Ham, Pineapple"; static double hawaiiPrice = 60;
    static String atlanta = "3. Atlanta: Tomato, Cheese, Ham, Bacon"; static double atlantaPrice = 55;
    static String virginia = "4. Virginia: Tomato, Cheese, Ham, Bacon, Pineapple"; static double virginiaPrice = 60;
    static String chickenSupreme = "5. Chicken Supreme: Chicken, Mushrooms, Onion"; static double chickenSupremePrice = 60;
    static String meatFeast = "6. Meat Feast: Tomato, Cheese, Pepperoni, Ham, Beef, Chicken"; static double meatFeastPrice = 55;
    static String veggie = "7. Veggie: Tomato, Cheese, Spinach, Sweetcorn, Peppers, Mushrooms"; static double veggiePrice = 65;
    static String theGoat = "8. The G.O.A.T: Tomato, Cheese, Caramelised Onions, Spinach, Balsamic Drizzle"; static double theGoatPrice = 85;
    static String pepperoniFeast = "9. Pepperoni Feast: Tomato, Cheese, Ham, Double Pepperoni"; static double pepperoniFeastPrice = 75;
    static String supreme = "10. Supreme: Tomato, Cheese, Chicken, Beef, Black Olives, Peppers, Red Onions"; static double supremePrice = 70;

    //List of all toppings
    static String cheeseTopping = "1. Cheese";
    static String chiliTopping = "2. Chili";
    static String baconTopping = "3. Bacon";
    static String tunaTopping = "4. Tuna";
    static String lettuceTopping = "5. Lettuce";

    //Setup a spacing for the menu as a string, which we can reuse
    static String spacing = "%-80s %s \n";

    //Setup a static scanner
    static Scanner in = new Scanner(System.in);

    //Setup a boolean that will be used for repeating input prompts, in case an input is invalid
    static boolean again = true;




    public static void main(String[] args) {
        System.out.println("Welcome to Jan's Pizza!");
        System.out.println("Contrary to popular beliefs, our G.O.A.T pizza doesn't actually contain goat meat!");
        System.out.println("The prices listed are for standard sizes \n");
        System.out.println("Select a pizza from the list below by typing the associated number below \n");
        selectPizzaFromMenu();
        flushConsole();
        System.out.printf("You have chosen the following pizza:\n %s \n  \n", selectedPizza);
        System.out.printf("What size pizza do you want? \n");
        selectPizzaSize();
        flushConsole();
        System.out.printf("You have chosen the following pizza:\n %s \n The size is: %s \n The current price is %.2f DKK\n \n", selectedPizza, selectedSize, pizzaPrice);

        System.out.println("Do you wish to add any extra toppings? Maximum 3 \n Each topping costs 5,- DKK\n Type y for yes and n for no");

        //Ask if the customer wants topping
        toppingOption = in.next();
        if (toppingOption.equals("y")) {
            flushConsole();
            System.out.printf("You can choose the following toppings \n %s \n %s \n %s \n %s \n %s \n", cheeseTopping, chiliTopping, baconTopping, tunaTopping, lettuceTopping);
            selectPizzaToppings();
        }
        else{
            selectedToppings = "\t None";
        }
        flushConsole();
        printReceipt();
    }
    /** Method to read user input and make sure its an int */
    public static void readInput(){
        if(in.hasNextInt()){
            inputNo = in.nextInt();
        }
        else{
            in.next();
            inputNo = 0;      //We set this as 0, as all our switches has default cases that will catch 0
        }
    }

    /** Method to ask the customer which pizza they want */
    public static void selectPizzaFromMenu() {

        System.out.printf(spacing, "Pizza", "Price in DKK");

        System.out.printf(spacing, margherita, margheritaPrice);
        System.out.printf(spacing, hawaii, hawaiiPrice);
        System.out.printf(spacing, atlanta, atlantaPrice);
        System.out.printf(spacing, virginia, virginiaPrice);
        System.out.printf(spacing, chickenSupreme, chickenSupremePrice);
        System.out.printf(spacing, meatFeast, meatFeastPrice);
        System.out.printf(spacing, veggie, veggiePrice);
        System.out.printf(spacing, theGoat, theGoatPrice);
        System.out.printf(spacing, pepperoniFeast, pepperoniFeastPrice);
        System.out.printf(spacing, supreme, supremePrice);


        again = true;
        while(again){
            again = false;
            readInput();
            switch (inputNo) {              //Switch on input and assign the size and price accordingly
                case 1:
                    selectedPizza = margherita;
                    pizzaPrice = margheritaPrice;
                    break;
                case 2:
                    selectedPizza = hawaii;
                    pizzaPrice = hawaiiPrice;
                    break;
                case 3:
                    selectedPizza = atlanta;
                    pizzaPrice = atlantaPrice;
                    break;
                case 4:
                    selectedPizza = virginia;
                    pizzaPrice = virginiaPrice;
                    break;
                case 5:
                    selectedPizza = chickenSupreme;
                    pizzaPrice = chickenSupremePrice;
                    break;
                case 6:
                    selectedPizza = meatFeast;
                    pizzaPrice = meatFeastPrice;
                    break;
                case 7:
                    selectedPizza = veggie;
                    pizzaPrice = veggiePrice;
                    break;
                case 8:
                    selectedPizza = theGoat;
                    pizzaPrice = theGoatPrice;
                    break;
                case 9:
                    selectedPizza = pepperoniFeast;
                    pizzaPrice = pepperoniFeastPrice;
                    break;
                case 10:
                    selectedPizza = supreme;
                    pizzaPrice = supremePrice;
                    break;
                default:                      //Catch wrong inputs and make the while loop repeat
                    System.out.println("You have entered an invalid input, please try again \n");
                    again = true;
                    break;
            }
        }
    }
    /** Method to ask the customer which size they want */
    public static void selectPizzaSize() {
        //Print the size options
        System.out.printf(spacing, "1. Child Size", pizzaPrice * 0.75+"DKK");
        System.out.printf(spacing, "2. Standard Size", pizzaPrice+"DKK");
        System.out.printf(spacing, "3. Family Size", pizzaPrice * 1.5+"DKK");

        again = true;
        while(again){
            again = false;
            readInput();
            //Switch on input and assign the size and price accordingly
            switch (inputNo) {
                case 1:
                    selectedSize = "Child";
                    pizzaPrice = pizzaPrice * 0.75;
                    break;
                case 2:
                    selectedSize = "Medium";
                    break;
                case 3:
                    selectedSize = "Family";
                    pizzaPrice = pizzaPrice * 1.5;
                    break;
                default:                      //Catch wrong inputs and make the while loop repeat
                    System.out.println("You have entered an invalid input, please try again");
                    again = true;
                    break;
            }
        }
    }
    /** Method to ask the customer which toppings they want */
    public static void selectPizzaToppings() {
        for (int n = 0; n < 3; n++) {         //We choose to have a max of 3 toppings, so we use this for-loop
            System.out.println("Enter the topping number, and press enter after each. Type 0 when you are done");
            again = true;
            while (again){
                again = false;
                readInput();
                //Switch on input and assign the toppings accordingly
                switch (inputNo) {
                    case 0:
                        again = false;
                        break;
                    case 1:
                        selectedToppings += "\t" + cheeseTopping + "\n";
                        pizzaPrice = pizzaPrice + 5;
                        break;
                    case 2:
                        selectedToppings += "\t" +  chiliTopping + "\n";
                        pizzaPrice = pizzaPrice + 5;
                        break;
                    case 3:
                        selectedToppings += "\t" +  baconTopping + "\n";
                        pizzaPrice = pizzaPrice + 5;
                        break;
                    case 4:
                        selectedToppings += "\t" +  tunaTopping + "\n";
                        pizzaPrice = pizzaPrice + 5;
                        break;
                    case 5:
                        selectedToppings += "\t" +  lettuceTopping + "\n";
                        pizzaPrice = pizzaPrice + 5;
                        break;
                    default:                      //Catch wrong inputs and make the while loop repeat
                        System.out.println("You have entered an invalid input, please try again \n");
                        again = true;
                        break;
                }
            }
            System.out.printf("Current toppings:\n %s", selectedToppings);
        }

    }
    /** Method to print a receipt to the customer */
    public static void printReceipt() {
        System.out.printf("You have chosen the following pizza:\n %s \n The size is: %s \n With the following toppings \n %s \n The final price is %.2f DKK\n \n", selectedPizza, selectedSize, selectedToppings, pizzaPrice);
        System.out.println("Enjoy your meal!");
    }
    /** Method that makes space in the console when called, so it is easier for the customer to read */
    public static void flushConsole() {
        for (int i = 0; i < 40; ++i){
            System.out.println();
        }
    }
}



