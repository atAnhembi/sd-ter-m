package robos;

import area.Area;

public abstract class Robot {
    private int posX, posY;
    private Area area;

    public Robot(int posX, int posY, Area area) {
        if (isValidPosX(posX)) {
            this.posX = posX;
        }
        this.posY = posY;
        this.area = area;
    }

    public int getPosX() {
        return posX;
    }

    public boolean isValidPosX(int posX) {
        return (posX >= 0 && posX <= area.getMaxX());
    }

    public void setPosX(int posX) {
        if (isValidPosX(posX)) {
            this.posX = posX;
        }
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Area getArea() {
        return area;
    }

    public abstract boolean moverNorte(int deslocamento);

    public abstract boolean moverSul(int deslocamento);

    public abstract boolean moverLeste(int deslocamento);

    public abstract boolean moverOeste(int deslocamento);

}