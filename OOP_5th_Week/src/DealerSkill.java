public class DealerSkill extends Skill {
    private int consumptionHP;
    private int consumptionMP;

    public DealerSkill(int consumptionHP, int consumptionMP) {
        this.consumptionHP = consumptionHP;
        this.consumptionMP = consumptionMP;
    }

    @Override
    public void doSkill(Champion[] champions, Champion champion) {
        Dealer dealer = (Dealer) champion;
        Attack attack = new Attack();
        double damage = dealer.getTotalInflictionDamage() * dealer.getProperty().getPropertyPower() * 0.1;

        attack.doAttack(dealer, (int) damage);
        dealer.getBodyInfo().decreaseHP(consumptionHP);
        dealer.getBodyInfo().decreaseMP(consumptionMP);

        dealer.increaseTotalInflictionDamage((int) damage);
    }
}
