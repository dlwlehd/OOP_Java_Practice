import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Property propertyDealer = new Property("Magic", 20);
        Property propertySupporter = new Property("Recovery", 20);
        BodyInfo dealerBodyInfo = new BodyInfo(800, 600);
        BodyInfo supporterBodyInfo = new BodyInfo(600, 500);
        Moving dealerMoving = new Moving(new int[]{0, 0}, 5);
        Moving supporterMoving = new Moving(new int[]{0, 0}, 3);
        DealerAutoAttack dealerAutoAttack = new DealerAutoAttack(40, 20);
        SupporterAutoAttack supporterAutoAttack = new SupporterAutoAttack(30, 15);
        DealerSkill dealerSkill = new DealerSkill(40, 35);
        SupporterSkill supporterSkill = new SupporterSkill(45, 40);
        Dealer jinx = new Dealer(propertyDealer, dealerBodyInfo, dealerMoving, "jinx", "Dealer", dealerSkill, dealerAutoAttack);
        Supporter soraka = new Supporter(propertySupporter, supporterBodyInfo, supporterMoving, "soraka", "supporter", supporterSkill, supporterAutoAttack);
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
