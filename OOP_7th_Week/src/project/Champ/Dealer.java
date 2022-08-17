package project.Champ;

import project.Ability.Hittable;
import project.Ability.SkillActivatable;
import project.Entity;
import project.Property.LifeProperty;
import project.Property.LocationProperty;
import project.Skill.DealerSkill;
import project.Treasure.ThickTreasureBox;
import project.Treasure.TreasureBox;

public class Dealer extends Champion implements SkillActivatable {
    private int totalInflictionDamage = 0;
    private int attackPower;
    private double additionalAttackMultiplier;
    private DealerSkill dealerSkill;

    public Dealer(int uid, LifeProperty lifeProperty, LocationProperty locationProperty, String name, String role, int attackPower, double additionalAttackMultiplier, DealerSkill dealerSkill) {
        super(uid, lifeProperty, locationProperty, name, role);
        this.attackPower = attackPower;
        this.additionalAttackMultiplier = additionalAttackMultiplier;
        this.totalInflictionDamage = 0;
        this.dealerSkill = dealerSkill;
    }

    public DealerSkill getDealerSkill() {
        return dealerSkill;
    }

    public double getAdditionalAttackMultiplier() {
        return additionalAttackMultiplier;
    }

    public int getTotalInflictionDamage() {
        return totalInflictionDamage;
    }

    @Override
    public String toString() {
        return String.format("[Entity %d] [location (%d, %d)] [Life HP: %d MP: %d] [Champion %s %s (gold: %d)] [Dealer (total infliction damage: %d)]", getUid(), getLocationProperty().getX(), getLocationProperty().getY(), getLifeProperty().getCurrentHP(), getLifeProperty().getCurrentMP(), getName(), getRole(), getGold(), totalInflictionDamage);
    }

    @Override
    public void attack(Entity defender) {
        if (!(defender instanceof Hittable)) {
            System.out.println("invalidated.");
            return;
        }

        double attackDamage = attackPower + attackPower * additionalAttackMultiplier;
        if (attackDamage < 0) attackDamage = 0;

        if (this.getLifeProperty().getCurrentHP() == 0) {
            System.out.println("Dead Entity can't attack.");
            return;
        }

        if (defender.getLifeProperty().getCurrentHP() == 0) {
            System.out.println("already dead.");
            return;
        }

        if (defender instanceof ThickTreasureBox) {
            int finalDamage = (int) attackDamage - ((ThickTreasureBox) defender).getDefensePower();
            if (finalDamage < 0) finalDamage = 0;

            defender.getLifeProperty().damaged(finalDamage);
            totalInflictionDamage += (int) attackDamage;

            if (defender.getLifeProperty().getCurrentHP() == 0) {
                ifDead(this, defender);
            }

            return;
        }

        if (defender instanceof Champion || (defender instanceof TreasureBox)) {
            defender.getLifeProperty().damaged((int) attackDamage);
            totalInflictionDamage += (int) attackDamage;

            if (defender.getLifeProperty().getCurrentHP() == 0) {
                ifDead(this, defender);
            }

            return;
        }

        System.out.println("invalidated.");
    }

    @Override
    public void move(int xDistance, int yDistance) {
        this.getLocationProperty().move(xDistance, yDistance);
    }

    @Override
    public void teleport(int x, int y) {
        this.getLocationProperty().deploy(x, y);
    }
}
