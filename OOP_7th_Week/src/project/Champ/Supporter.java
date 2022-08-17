package project.Champ;

import project.Ability.Hittable;
import project.Ability.SkillActivatable;
import project.Entity;
import project.Property.LifeProperty;
import project.Property.LocationProperty;
import project.Skill.SupporterSkill;
import project.Treasure.ThickTreasureBox;
import project.Treasure.TreasureBox;

public class Supporter extends Champion implements SkillActivatable {
    private int totalRecoveredHealth = 0;
    private int recoveryPower;
    private int attackPower;
    private SupporterSkill supporterSkill;

    public Supporter(int uid, LifeProperty lifeProperty, LocationProperty locationProperty, String name, String role, int recoveryPower, int attackPower, SupporterSkill supporterSkill) {
        super(uid, lifeProperty, locationProperty, name, role);
        this.recoveryPower = recoveryPower;
        this.attackPower = attackPower;
        this.totalRecoveredHealth = 0;
        this.supporterSkill = supporterSkill;
    }

    public SupporterSkill getSupporterSkill() {
        return supporterSkill;
    }

    @Override
    public void attack(Entity defender) {
        if (!(defender instanceof Hittable)) {
            System.out.println("invalidated.");
            return;
        }

        if (this.getLifeProperty().getCurrentHP() == 0) {
            System.out.println("Dead Entity can't attack.");
            return;
        }

        if (defender.getLifeProperty().getCurrentHP() == 0) {
            System.out.println("already dead.");
            return;
        }

        if (defender instanceof ThickTreasureBox) {
            int finalDamage = attackPower - ((ThickTreasureBox) defender).getDefensePower();
            if (finalDamage < 0) finalDamage = 0;
            defender.getLifeProperty().damaged(finalDamage);

            if (defender.getLifeProperty().getCurrentHP() == 0) {
                this.setGold(this.getGold() + ((TreasureBox) defender).getGold());
                ((TreasureBox) defender).setGold(0);
            }

            double healed = recoveryPower + attackPower * 0.1;
            totalRecoveredHealth += (int) healed;

            this.getLifeProperty().healed((int) healed);
            return;
        }

        if (defender instanceof Champion || (defender instanceof TreasureBox)) {
            defender.getLifeProperty().damaged(attackPower);

            if (defender.getLifeProperty().getCurrentHP() == 0) {
                ifDead(this, defender);
            }

            double healed = recoveryPower + attackPower * 0.1;
            totalRecoveredHealth += (int) healed;

            this.getLifeProperty().healed((int) healed);
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

    @Override
    public String toString() {
        return String.format("[Entity %d] [location (%d, %d)] [Life HP: %d MP: %d] [Champion %s %s (gold: %d)] [Supporter (total recovered health: %d)]", getUid(), getLocationProperty().getX(), getLocationProperty().getY(), getLifeProperty().getCurrentHP(), getLifeProperty().getCurrentMP(), getName(), getRole(), getGold(), totalRecoveredHealth);
    }

    public int getTotalRecoveredHealth() {
        return totalRecoveredHealth;
    }

    public int getRecoveryPower() {
        return recoveryPower;
    }
}