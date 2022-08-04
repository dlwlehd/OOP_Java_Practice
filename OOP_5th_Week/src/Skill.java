abstract class Skill {
    private int consumptionHP;
    private int consumptionMP;

    abstract public void doSkill(Champion[] champions, Champion champion);
}
