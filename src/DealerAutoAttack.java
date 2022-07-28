public class DealerAutoAttack extends AutoAttack {
    private int autoAttackPower;
    private int consumptionHP;
    private Attack attack;

    public DealerAutoAttack(int autoAttackPower, int consumptionHP) {
        this.autoAttackPower = autoAttackPower;
        this.consumptionHP = consumptionHP;
    }

    @Override
    public void doAutoAttack(Champion champion) {
        Dealer dealer = (Dealer) champion;
        double damage = autoAttackPower + autoAttackPower * champion.getProperty().getPropertyPower() * 0.01;
        System.out.println(champion.getName() + " attacked " + (int) damage + " HP.\n");
        dealer.increaseTotalInflictionDamage((int) damage);
        dealer.getBodyInfo().decreaseHP(this.consumptionHP);
    }
}