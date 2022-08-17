package project.Champ;

import project.Ability.Attackable;
import project.Entity;
import project.Ability.Hittable;
import project.Ability.Movable;
import project.Property.LifeProperty;
import project.Property.LocationProperty;
import project.Treasure.TreasureBox;

public abstract class Champion extends Entity implements Attackable, Hittable, Movable {
    private String name;
    private String role;
    private int gold = 0;

    public Champion(int uid, LifeProperty lifeProperty, LocationProperty locationProperty, String name, String role) {
        super(uid, lifeProperty, locationProperty);
        this.name = name;
        this.role = role;
        this.gold = 0;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getRole() {
        return role;
    }
}
