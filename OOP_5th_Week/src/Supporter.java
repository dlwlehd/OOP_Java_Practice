public class Supporter extends Champion {

    private SupporterSkill supporterSkill;
    private SupporterAutoAttack supporterAutoAttack;
    private int totalRecoveredHealth = 0;

    Supporter(Property property, BodyInfo bodyInfo, Moving moving, String name, String role, SupporterSkill supporterSkill, SupporterAutoAttack supporterAutoAttack) {
        super(property, bodyInfo, moving, name, role);
        this.supporterSkill = supporterSkill;
        this.supporterAutoAttack = supporterAutoAttack;
    }

    public void increaseTotalRecoveredHealth(int hp) {
        totalRecoveredHealth += hp;
    }

    public int getTotalRecoveredHealth() {
        return totalRecoveredHealth;
    }

    public SupporterSkill getSupporterSkill() {
        return supporterSkill;
    }

    public SupporterAutoAttack getSupporterAutoAttack() {
        return supporterAutoAttack;
    }
}
