package robos;

import area.Area;

public class RoboSimples extends Robot {

    public RoboSimples(int posX, int posY, Area area) {
        super(posX, posY, area);
    }

    @Override
    public boolean moverNorte(int deslocamento) {
        if(getPosY() - deslocamento >= 0){
            setPosY(deslocamento);
            return true;
        }
        return false;
    }

    @Override
    public boolean moverSul(int deslocamento) {
        return false;
    }

    @Override
    public boolean moverLeste(int deslocamento) {
        return false;
    }

    @Override
    public boolean moverOeste(int deslocamento) {
        return false;
    }
    
}
