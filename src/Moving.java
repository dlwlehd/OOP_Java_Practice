import java.util.Scanner;

public class Moving {
    private int[] location;
    private int maxMovingDistance;
    private int consumptionHP;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public Moving(int[] location, int maxMovingDistance) {
        this.location = location;
        this.maxMovingDistance = maxMovingDistance;
        consumptionHP = 10;
    }

    public int[] getLocation() {
        return location;
    }

    public void move(Champion champion, String direction, int distance) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (maxMovingDistance >= distance) {
                if (direction.equals("RIGHT")) {
                    location[0] += distance * dx[1];
                    location[1] += distance * dy[1];
                }

                if (direction.equals("LEFT")) {
                    location[0] += distance * dx[3];
                    location[1] += distance * dy[3];
                }

                if (direction.equals("UP")) {
                    location[0] += distance * dx[0];
                    location[1] += distance * dy[0];
                }

                if (direction.equals("DOWN")) {
                    location[0] += distance * dx[2];
                    location[1] += distance * dy[2];
                }

                champion.getBodyInfo().decreaseHP(distance * this.consumptionHP);
                System.out.printf("%s moved %d distance to the %s.\n\n", champion.getName(), distance, direction);
                break;
            }

            System.out.println("Moving Distance Exceeded. Please re-enter.");
            direction = sc.next();
            distance = sc.nextInt();
        }
    }

    public void print() {
        System.out.println(location[0] + " " + location[1]);
    }
}
