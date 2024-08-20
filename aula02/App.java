
import area.Area;
import robos.RoboSimples;
import robos.Robot;

public class App {
    public static void main(String[] args) {
        Area area = new Area(100, 100);
        Robot robo = new RoboSimples(10, 10, area);

        robo.moverNorte(5);

        System.out.println(robo.getPosX() + "," + robo.getPosY());
    }
}
