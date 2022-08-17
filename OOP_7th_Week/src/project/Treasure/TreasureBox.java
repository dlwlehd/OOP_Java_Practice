package project.Treasure;

import project.Ability.Hittable;
import project.Entity;
import project.Property.LifeProperty;
import project.Property.LocationProperty;

public class TreasureBox extends Entity implements Hittable {
    private int gold = 0;

    public TreasureBox(int uid, LifeProperty lifeProperty, LocationProperty locationProperty, int gold) {
        super(uid, lifeProperty, locationProperty);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return String.format("[Entity %d] [location (%d, %d)] [Life HP: %d MP: %d] [TreasureBox (gold: %d)]", getUid(), getLocationProperty().getX(), getLocationProperty().getY(), getLifeProperty().getCurrentHP(), getLifeProperty().getCurrentMP(), getGold());
    }
}
