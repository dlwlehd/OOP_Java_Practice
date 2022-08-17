package project.Property;

public class LocationProperty {
    int x, y;

    public LocationProperty(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deploy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int xDistance, int yDistance) {
        this.x += xDistance;
        this.y += yDistance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
