package project.Skill;

import project.Entity;
import project.Treasure.ThickTreasureBox;

public class DoubledDefenseSkill extends BaseSkill {
    public DoubledDefenseSkill() {
        super("doubleDefense", 20);
    }

    @Override
    public void activate(Entity activator, Entity[] skillTargetList) {
        if (!(activator instanceof ThickTreasureBox)) {
            System.out.println("Wrong class.");
            return;
        }

        if (skillTargetList.length != 0) {
            System.out.println("invalidated.");
            return;
        }

        if (activator.getLifeProperty().getCurrentHP() == 0) {
            System.out.println("Dead entity can't use skill.");
            return;
        }

        if (activator.getLifeProperty().getCurrentMP() < this.getRequiredMPForActivation()) {
            System.out.println("Not enough MP.");
            return;
        }

        ThickTreasureBox thickTreasureBox = (ThickTreasureBox) activator;
        thickTreasureBox.setDefensePower(thickTreasureBox.getDefensePower() * 2);
    }
}
