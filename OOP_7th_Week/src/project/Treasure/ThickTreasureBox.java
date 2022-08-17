package project.Treasure;

import project.Ability.SkillActivatable;
import project.Property.LifeProperty;
import project.Property.LocationProperty;
import project.Skill.DoubledDefenseSkill;

public class ThickTreasureBox extends TreasureBox implements SkillActivatable {
    private int defensePower;
    private DoubledDefenseSkill doubledDefenseSkill;

    public ThickTreasureBox(int uid, LifeProperty lifeProperty, LocationProperty locationProperty, int gold, int defensePower, DoubledDefenseSkill doubledDefenseSkill) {
        super(uid, lifeProperty, locationProperty, gold);
        this.defensePower = defensePower;
        this.doubledDefenseSkill = doubledDefenseSkill;
    }

    public DoubledDefenseSkill getDoubledDefenseSkill() {
        return doubledDefenseSkill;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    @Override
    public String toString() {
        return String.format("[Entity %d] [location (%d, %d)] [Life HP: %d MP: %d] [TreasureBox (gold: %d)] [ThickTreasureBox (defense power: %d)]", getUid(), getLocationProperty().getX(), getLocationProperty().getY(), getLifeProperty().getCurrentHP(), getLifeProperty().getCurrentMP(), getGold(), defensePower);
    }
}
