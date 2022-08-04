public class OneRoom extends Room {
    public OneRoom(String name, double monthlyRent, double area, int option, String local) {
        super(name, monthlyRent, area, option, local);
        sum = super.areaScore() + super.localScore() + super.monthlyRentScore() * 1.5 + super.optionScore();
    }

    @Override
    protected String showRoomScoreInformation() {
        return "(" + name + ") OneRoom Score: " + sum;
    }
}
