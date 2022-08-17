package project.Skill;

import project.Ability.Hittable;
import project.Champ.Dealer;
import project.Entity;

public class DealerSkill extends BaseSkill {
    public DealerSkill() {
        super("moreAttack!!!", 50);
    }

    @Override
    public void activate(Entity activator, Entity[] skillTargetList) {
        if (!(activator instanceof Dealer)) {
            System.out.println("Wrong class.");
            return;
        }

        if (skillTargetList.length != 1 || !(skillTargetList[0] instanceof Hittable)) {
            System.out.println("invalidated.");
        }

        Dealer dealer = (Dealer) activator;
        double damage = dealer.getTotalInflictionDamage() * dealer.getAdditionalAttackMultiplier();

        if (dealer.getLifeProperty().getCurrentMP() < this.getRequiredMPForActivation()) {
            System.out.println("Not enough MP.");
            return;
        }

        if (skillTargetList[0].getLifeProperty().getCurrentHP() == 0) {
            System.out.println("Dead entity can't use skill.");
            return;
        }

        dealer.getLifeProperty().mpUse(getRequiredMPForActivation());
        skillTargetList[0].getLifeProperty().damaged((int) damage);

        if (skillTargetList[0].getLifeProperty().getCurrentHP() == 0) {
            dealer.ifDead(dealer, skillTargetList[0]);
        }
    }
}
