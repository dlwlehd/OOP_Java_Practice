import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dealer jinx = new Dealer(
                new Property("Magic", 20),
                new BodyInfo(800, 600),
                new Moving(new int[]{0, 0}, 5),
                "jinx",
                "Dealer",
                new DealerSkill(40, 35),
                new DealerAutoAttack(40, 20)
        );

        Supporter soraka = new Supporter(
                new Property("Recovery", 20),
                new BodyInfo(600, 500),
                new Moving(new int[]{0, 0}, 3),
                "soraka",
                "Supporter",
                new SupporterSkill(45, 40),
                new SupporterAutoAttack(30, 15)
        );

        Champion[] champions = {jinx, soraka};

        System.out.println("Game start!\n");
        System.out.println("=========================================\n");

        while (true) {
            System.out.println("Select Champion 1. Jinx 2. Soraka 0. Quit the game");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 0) {
                System.out.println("Game is over\nSee you again!");
                break;
            }

            System.out.println("1. Moving 2. AutoAttack 3. Skill");
            int option2 = sc.nextInt();

            if (option2 == 1) {
                System.out.println("Enter the direction and distance of moving.");
                String direction = sc.next();
                int distance = sc.nextInt();

                if (option == 1) jinx.getMoving().move(jinx, direction, distance);
                else soraka.getMoving().move(soraka, direction, distance);
            }

            if (option2 == 2) {
                if (option == 1) jinx.getDealerAutoAttack().doAutoAttack(jinx);
                else soraka.getSupporterAutoAttack().doAutoAttack(soraka);
            }

            if (option2 == 3) {
                if (option == 1) jinx.getDealerSkill().doSkill(champions, jinx);
                else soraka.getSupporterSkill().doSkill(champions, soraka);
            }

            jinx.printChampionInfo(jinx);
            System.out.printf("inflicted damage : %d\n", jinx.getTotalInflictionDamage());
            soraka.printChampionInfo(soraka);
            System.out.printf("recovered health : %d\n", soraka.getTotalRecoveredHealth());
            System.out.println("\n=========================================\n");
        }
    }
}
