abstract public class Champion {
    private Property Property;
    private BodyInfo BodyInfo;
    private Moving Moving;
    private String name;
    private String role;

    public Champion(Property property, BodyInfo bodyInfo, Moving moving, String name, String role) {
        this.Property = property;
        this.BodyInfo = bodyInfo;
        this.Moving = moving;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Moving getMoving() {
        return Moving;
    }

    public BodyInfo getBodyInfo() {
        return BodyInfo;
    }

    public Property getProperty() {
        return Property;
    }

    public void printChampionInfo(Champion champion) {
        System.out.printf("[%6s] | Role : %-10s | HP (%3d/%3d) | MP (%3d/%3d) | Location (%d, %d) | ", name, role, getBodyInfo().getCurrentHP(), getBodyInfo().getMaxHP(), getBodyInfo().getCurrentMP(), getBodyInfo().getMaxMP(), getMoving().getLocation()[0], getMoving().getLocation()[1]);
    }
}
