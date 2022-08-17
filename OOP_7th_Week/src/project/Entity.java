package project;

import project.Champ.Champion;
import project.Property.LifeProperty;
import project.Property.LocationProperty;
import project.Treasure.TreasureBox;

public class Entity {
    private int uid;
    private LifeProperty lifeProperty;
    private LocationProperty locationProperty;

    public Entity(int uid, LifeProperty lifeProperty, LocationProperty locationProperty) {
        this.uid = uid;
        this.lifeProperty = lifeProperty;
        this.locationProperty = locationProperty;
    }

    public void ifDead(Champion attacker, Entity defender) {
        if (defender instanceof Champion) {
            attacker.setGold(attacker.getGold() + ((Champion) defender).getGold());
            ((Champion) defender).setGold(0);
        }

        if (defender instanceof TreasureBox) {
            attacker.setGold(attacker.getGold() + ((TreasureBox) defender).getGold());
            ((TreasureBox) defender).setGold(0);
        }
    }

    public int getUid() {
        return uid;
    }

    public LifeProperty getLifeProperty() {
        return lifeProperty;
    }

    public LocationProperty getLocationProperty() {
        return locationProperty;
    }
}