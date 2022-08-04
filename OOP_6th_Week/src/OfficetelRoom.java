public class OfficetelRoom extends Room {
    public OfficetelRoom(String name, double monthlyRent, double area, int option, String local) {
        super(name, monthlyRent, area, option, local);
        sum = super.areaScore() + super.localScore() + super.monthlyRentScore() + super.optionScore() * 1.5;
    }

    @Override
    protected String showRoomScoreInformation() {
        return "(" + name + ") Officetel Room Score: " + sum;
    }
}
