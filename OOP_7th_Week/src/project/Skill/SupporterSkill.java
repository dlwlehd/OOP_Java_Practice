package project.Skill;

import project.Champ.Champion;
import project.Champ.Supporter;
import project.Entity;

public class SupporterSkill extends BaseSkill {
    public SupporterSkill() {
        super("allHeal", 100);
    }

    @Override
    public void activate(Entity activator, Entity[] skillTargetList) {
        if (!(activator instanceof Supporter)) {
            System.out.println("Wrong class.");
            return;
        }

        Supporter supporter = (Supporter) activator;
        double healed = supporter.getTotalRecoveredHealth() * supporter.getRecoveryPower() * 0.1;
        if (supporter.getLifeProperty().getCurrentMP() < this.getRequiredMPForActivation()) {
            System.out.println("Not enough MP.");
            return;
        }

        if (activator.getLifeProperty().getCurrentHP() == 0) {
            System.out.println("Dead entity can't use skill.");
            return;
        }

        for (Entity entity : skillTargetList) {
            if (!(entity instanceof Champion)) {
                System.out.println("invalidated.");
                return;
            }
        }

        for (Entity entity : skillTargetList) {
            entity.getLifeProperty().healed((int) healed);
        }
    }
}
