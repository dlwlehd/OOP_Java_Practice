import java.util.Scanner;

public class Account {
    private int id;
    private String password;
    private int deposit = 0;

    Account(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean passwordCheck(String str) {
        return this.password.equals(str);
    }

    public boolean idCheck(int num) {
        return num == this.id;
    }

    public static int findIdx(Account[] accounts, int id) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].id == id) return i;
        }
        return -1;
    }

    public static int login(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        int id;
        String password;
        System.out.println("Who are you? Input your account ID.");
        System.out.print("input: ");
        id = sc.nextInt();
        int accountIdx = Account.findIdx(accounts, id), drinkIdx = 0;

        if (accountIdx == -1) {
            System.out.println("Can't find id!");
            return -1;
        }

        System.out.println("Input the password");
        System.out.print("input: ");
        password = sc.next();

        if (!accounts[accountIdx].passwordCheck(password)) {
            System.out.println("Wrong password!");
            return -1;
        }

        return accountIdx;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getId() {
        return id;
    }

    public void buy(Drink drink) {
        drink.capacityChange(-1);
        this.deposit -= drink.getPrice();
        System.out.println("You bought " + drink.getName() + ". Now, you have " + this.deposit + " won.");
        System.out.println(drink.getName() + " now has " + drink.getCapacity() + " left in stock.");
    }

    void depositChange(int money) {
        this.deposit += money;
    }
}
