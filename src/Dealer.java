public class Dealer extends Champion {

    private int totalInflictionDamage = 0;
    private DealerSkill dealerSkill;
    private DealerAutoAttack dealerAutoAttack;

    Dealer(Property property, BodyInfo bodyInfo, Moving moving, String name, String role, DealerSkill dealerSkill, DealerAutoAttack dealerAutoAttack) {
        super(property, bodyInfo, moving, name, role);
        this.dealerSkill = dealerSkill;
        this.dealerAutoAttack = dealerAutoAttack;
    }

    public int getTotalInflictionDamage() {
        return totalInflictionDamage;
    }

    public DealerSkill getDealerSkill() {
        return dealerSkill;
    }

    public DealerAutoAttack getDealerAutoAttack() {
        return dealerAutoAttack;
    }

    public void increaseTotalInflictionDamage(int damage) {
        totalInflictionDamage += damage;
    }
}
