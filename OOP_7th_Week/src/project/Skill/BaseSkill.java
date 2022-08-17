package project.Skill;

import project.Champ.Champion;
import project.Entity;

public abstract class BaseSkill {
    private String skillName;
    private int requiredMPForActivation;

    public BaseSkill(String skillName, int requiredMPForActivation) {
        this.skillName = skillName;
        this.requiredMPForActivation = requiredMPForActivation;
    }

    public String getSkillName() {
        return skillName;
    }

    public abstract void activate(Entity activator, Entity[] skillTargetList);

    public int getRequiredMPForActivation() {
        return requiredMPForActivation;
    }
}
