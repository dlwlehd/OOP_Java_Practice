public class RooftopRoom extends Room {
    public RooftopRoom(String name, double monthlyRent, double area, int option, String local) {
        super(name, monthlyRent, area, option, local);
        sum = super.areaScore() * 1.5 + super.localScore() + super.monthlyRentScore() + super.optionScore();
    }

    @Override
    protected String showRoomScoreInformation() {
        return "(" + name + ") Rooftop Room Score: " + sum;
    }
}
