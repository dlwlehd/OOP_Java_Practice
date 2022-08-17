package project.Property;

public class LifeProperty {
    private int maxHP;
    private int currentHP;
    private int maxMP;
    private int currentMP;

    public LifeProperty(int maxHP, int maxMP) {
        this.maxHP = maxHP;
        currentHP = maxHP;
        this.maxMP = maxMP;
        currentMP = maxMP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void damaged(int damage) {
        this.currentHP -= damage;
        if (this.currentHP < 0) this.currentHP = 0;
    }

    public void mpUse(int mp) {
        if (this.currentMP < mp) return;
        this.currentMP -= mp;
    }

    public void healed(int healed) {
        this.currentHP = Math.min(maxHP, this.currentHP + healed);
    }
}
