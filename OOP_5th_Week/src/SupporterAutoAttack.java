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
        Attack attack = new Attack();
        Recovery recovery = new Recovery();
        double healed = autoAttackPower * supporter.getProperty().getPropertyPower() * 0.01;

        attack.doAttack(supporter, autoAttackPower);
        supporter.getBodyInfo().decreaseHP(this.consumptionHP);

        recovery.doRecover(champion, (int) healed);
        supporter.getBodyInfo().increaseHP((int) healed);
        supporter.increaseTotalRecoveredHealth((int) healed);
    }
}
