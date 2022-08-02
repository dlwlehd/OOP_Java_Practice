import java.util.Scanner;

public class Drink {
    private String name;
    private int price;
    private int capacity = 0;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    Boolean checkName(String str) {
        return this.name.equals(str);
    }

    public static int findIdx(Drink[] drinks, String drink) {
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i].name.equals(drink)) return i;
        }
        return -1;
    }

    public static int buyDrink(Account[] accounts, Drink[] drinks, int accountIdx) {
        Scanner sc = new Scanner(System.in);
        String drink = sc.next();

        int drinkIdx = Drink.findIdx(drinks, drink);

        if (drinkIdx == -1) {
            System.out.println("Can't find drink!");
        }

        if (drinks[drinkIdx].isEmpty()) {
            System.out.println("Sold all!");
        }

        if (accounts[accountIdx].getDeposit() < drinks[drinkIdx].getPrice()) {
            System.out.println("Not enough money!");
        }

        return drinkIdx;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Boolean isEmpty() {
        if (this.capacity == 0) return true;
        return false;
    }

    void capacityChange(int num) {
        this.capacity += num;
    }

    void menuPrint() {
        System.out.println(this.name + " - " + this.price + " won");
    }
}
