import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account[] accounts = {
                new Account(1234, "abcd"),
                new Account(1577, "eeee"),
                new Account(7777, "4k4k")
        };

        Drink[] drinks = {
                new Drink("americano", 1100),
                new Drink("cafeLatte", 1800),
                new Drink("espresso", 1200)
        };

        for (int i = 0; i < 3; i++) accounts[i].depositChange(2000);
        for (int i = 0; i < 3; i++) drinks[i].capacityChange(3);

        while (true) {
            initialPrint();
            int option = sc.nextInt();

            if (option == 1) {
                System.out.println("---MENU---");
                for (int i = 0; i < 3; i++) drinks[i].menuPrint();
                System.out.println("----------");

                int accountIdx = Account.login(accounts);
                if (accountIdx == -1) continue;

                System.out.println("Hello " + accounts[accountIdx].getId() + ". Please specify the name of a drink that you want to buy.");
                System.out.print("input: ");

                int drinkIdx = Drink.buyDrink(accounts, drinks, accountIdx);
                accounts[accountIdx].buy(drinks[drinkIdx]);
            }

            if (option == 2) {
                int money;
                int accountIdx = Account.login(accounts);

                System.out.println("Hello " + accounts[accountIdx].getId() + ". Please specify the amount that you want to deposit.");
                System.out.print("input: ");
                money = sc.nextInt();

                System.out.print("User " + accounts[accountIdx].getId() + " deposited money. " + accounts[accountIdx].getDeposit() + " won -> ");
                accounts[accountIdx].depositChange(money);
                System.out.println(accounts[accountIdx].getDeposit() + " won");
            }

            if (option == 3) {
                statusPrint(accounts, drinks);
            }

            if (option == 4) break;
        }
    }

    public static void initialPrint() {
        System.out.println("Input the number of a menu that you want to run.");
        System.out.println("1: buy a drink");
        System.out.println("2: deposit money");
        System.out.println("3: see the current state");
        System.out.println("4: program exit");
        System.out.print("input: ");
    }

    public static void statusPrint(Account[] accounts, Drink[] drinks) {
        System.out.println("----Current System State----");
        System.out.println("[users]");
        for (int i = 0; i < 3; i++) {
            System.out.println(accounts[i].getId() + " : " + accounts[i].getDeposit() + " won");
        }
        System.out.println("\n[drinks]");
        for (int i = 0; i < 3; i++) {
            System.out.println(drinks[i].getName() + " : " + drinks[i].getCapacity() + " stock(s)");
        }
        System.out.println("----------------------------");
    }
}
