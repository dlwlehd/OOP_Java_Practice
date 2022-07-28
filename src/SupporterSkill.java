public class SupporterSkill extends Skill {
    private int consumptionHP;
    private int consumptionMP;

    public SupporterSkill(int consumptionHP, int consumptionMP) {
        this.consumptionHP = consumptionHP;
        this.consumptionMP = consumptionMP;
    }

    @Override
    public void doSkill(Champion[] champions, Champion champion) {
        Supporter supporter = (Supporter) champion;
        double healed = supporter.getTotalRecoveredHealth() * supporter.getProperty().getPropertyPower() * 0.1;

        supporter.getBodyInfo().decreaseHP(consumptionHP);
        supporter.getBodyInfo().decreaseMP(consumptionMP);

        for (Champion champ : champions) {
            champ.getBodyInfo().increaseHP((int) healed);
            System.out.println(champ.getName() + " recovered " + (int) healed + " HP.");
            supporter.increaseTotalRecoveredHealth((int) healed);
        }
    }
}
