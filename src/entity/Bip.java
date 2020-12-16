package entity;

import com.sun.org.apache.xerces.internal.util.Status;

public class Bip {
    private Status type;
    private boolean active;
    private int height;

    public Status getType() {
        return type;
    }

    public void setType(Status type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
