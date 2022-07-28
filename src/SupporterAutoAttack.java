public class SupporterAutoAttack extends AutoAttack {
    private int autoAttackPower;
    private int consumptionHP;

    public SupporterAutoAttack(int autoAttackPower, int consumptionHP) {
        this.autoAttackPower = autoAttackPower;
        this.consumptionHP = consumptionHP;
    }

    @Override
    public void doAutoAttack(Champion champion) {
        Supporter supporter = (Supporter) champion;
        double healed = autoAttackPower * supporter.getProperty().getPropertyPower() * 0.01;
        supporter.getBodyInfo().decreaseHP(this.consumptionHP);
        supporter.getBodyInfo().increaseHP((int) healed);
        supporter.increaseTotalRecoveredHealth((int) healed);
    }
}
