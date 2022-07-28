public class BodyInfo {
    private int maxHP;
    private int currentHP;
    private int maxMP;
    private int currentMP;

    public BodyInfo(int maxHP, int maxMP) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMP = maxMP;
        this.currentMP = maxMP;
    }

    public void increaseHP(int hp) {
        this.currentHP = Math.min(maxHP, currentHP + hp);
    }

    public void decreaseHP(int hp) {
        this.currentHP -= hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void decreaseMP(int mp) {
        this.currentMP -= mp;
    }
}
