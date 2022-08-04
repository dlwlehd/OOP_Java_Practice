public class Room {
    protected String name;
    protected double monthlyRent;
    protected double area;
    protected int option;
    protected String local;
    protected double sum;

    public Room(String name, double monthlyRent, double area, int option, String local) {
        this.name = name;
        this.monthlyRent = monthlyRent;
        this.area = area;
        this.option = option;
        this.local = local;
    }

    protected int monthlyRentScore() {
        if (this.monthlyRent < 40) return 4;
        if (this.monthlyRent < 60) return 3;
        return 2;
    }

    public double getSum() {
        return sum;
    }

    protected int areaScore() {
        if (this.area >= 25.5 && this.area < 35.6) return 1;
        else if (this.area >= 35.6 && this.area < 45.7) return 2;
        else if (this.area >= 45.7) return 3;
        return 0;
    }

    protected int optionScore() {
        return option;
    }

    protected int localScore() {
        if (this.local.equals("lala")) return 1;
        return 2;
    }

    protected String showRoomScoreInformation() {
        return "(" + name + ") room Score: " + sum;
    }

    @Override
    public String toString() {
        return "------------------------\n" + "Room: " + name + "\nMonthly Rent: " + monthlyRent + "\nArea: " + area + "\nOption: " + option + "\nlocal: " + local + "\n------------------------";
    }
}
