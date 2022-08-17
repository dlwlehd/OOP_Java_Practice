package project.Treasure;

import project.Ability.Movable;
import project.Property.LifeProperty;
import project.Property.LocationProperty;

public class MovingTreasureBox extends TreasureBox implements Movable {

    public MovingTreasureBox(int uid, LifeProperty lifeProperty, LocationProperty locationProperty, int gold) {
        super(uid, lifeProperty, locationProperty, gold);
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
        return String.format("[Entity %d] [location (%d, %d)] [Life HP: %d MP: %d] [TreasureBox (gold: %d)] [MovingTreasureBox]", getUid(), getLocationProperty().getX(), getLocationProperty().getY(), getLifeProperty().getCurrentHP(), getLifeProperty().getCurrentMP(), getGold());
    }
}
