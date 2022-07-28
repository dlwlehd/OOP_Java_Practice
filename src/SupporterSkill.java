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
        Recovery recovery = new Recovery();
        double healed = supporter.getTotalRecoveredHealth() * supporter.getProperty().getPropertyPower() * 0.1;

        supporter.getBodyInfo().decreaseHP(consumptionHP);
        supporter.getBodyInfo().decreaseMP(consumptionMP);

        for (Champion champ : champions) {
            champ.getBodyInfo().increaseHP((int) healed);
            recovery.doRecover(champ, (int) healed);
            supporter.increaseTotalRecoveredHealth((int) healed);
        }
    }
}
