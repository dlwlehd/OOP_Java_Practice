import java.util.Scanner;

public class SimpleApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] name = new String[3];
        int[] price = new int[3];
        int deposit;

        name[0] = "americano";
        name[1] = "cafeLatte";
        name[2] = "espresso";
        price[0] = 1100;
        price[1] = 1800;
        price[2] = 1200;

        System.out.println("--------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(name[i] + ": " + price[i]);
        }
        System.out.println("--------------------");

        System.out.println("Please make your deposit (type the amount)");
        deposit = sc.nextInt();
        
        while(true) {
            System.out.println("Select a drink you want (type the drink name)");
            String drink = sc.next();
            if (drink.equals(name[0])|| drink.equals(name[1]) || drink.equals(name[2])) {
                if (drink.equals(name[0])) {
                    if (deposit < price[0]) {
                        System.out.println("You don't have enough money.");
                        break;
                    }
                    deposit -= price[0];
                    System.out.println("Your choice is " + name[0] + ". The remaining amount is " + deposit + " won.");
                }

                if (drink.equals(name[1])) {
                    if (deposit < price[1]) {
                        System.out.println("You don't have enough money.");
                        break;
                    }
                    deposit -= price[1];
                    System.out.println("Your choice is " + name[1] + ". The remaining amount is " + deposit + " won.");
                }

                if (drink.equals(name[2])) {
                    if (deposit < price[2]) {
                        System.out.println("You don't have enough money.");
                        break;
                    }
                    deposit -= price[2];
                    System.out.println("Your choice is " + name[2] + ". The remaining amount is " + deposit + " won.");
                }
            } else {
                System.out.println("Incorrect Input. Please type a drink name again.");
                continue;
            }

            System.out.println("If you want to select another, type 'yes.' Otherwise, type 'no.'");
            String flag = sc.next();

            if (flag.equals("no")) break;
            if (flag.equals("yes") && deposit < 1100) {
                System.out.println("You don't have enough money.");
                break;
            }
        }
        System.out.println("The change is " + deposit + ".");
        System.out.println("Thank you! Have a nice day~");
    }
}
