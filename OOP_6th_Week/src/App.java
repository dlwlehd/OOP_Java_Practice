import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String selected = "";
        double min = 0;
        ArrayList<Room> rooms = new ArrayList<>();

        while (true) {
            int type = sc.nextInt();

            if (type == 1) {
                String name = sc.next();
                double monthlyRent = sc.nextDouble();
                double area = sc.nextDouble();
                int option = sc.nextInt();
                String local = sc.next();
                OneRoom created = new OneRoom(name, monthlyRent, area, option, local);
                rooms.add(created);
                if (created.getSum() >= min) {
                    min = created.getSum();
                    selected = created.name;
                }
            } else if (type == 2) {
                String name = sc.next();
                double monthlyRent = sc.nextDouble();
                double area = sc.nextDouble();
                int option = sc.nextInt();
                String local = sc.next();
                OfficetelRoom created = new OfficetelRoom(name, monthlyRent, area, option, local);
                rooms.add(created);
                if (created.getSum() >= min) {
                    min = created.getSum();
                    selected = created.name;
                }
            } else if (type == 3) {
                String name = sc.next();
                double monthlyRent = sc.nextDouble();
                double area = sc.nextDouble();
                int option = sc.nextInt();
                String local = sc.next();
                RooftopRoom created = new RooftopRoom(name, monthlyRent, area, option, local);
                rooms.add(created);
                if (created.getSum() >= min) {
                    min = created.getSum();
                    selected = created.name;
                }
            } else break;
        }

        for (Room x : rooms) {
            System.out.println(x);
            System.out.println(x.showRoomScoreInformation());
        }
        System.out.println("\n\n\n여러 옵션을 고민한 결과 " + selected + "가 선정되었습니다.");
    }
}
