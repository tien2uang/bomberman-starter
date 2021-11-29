package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.entities.Entity;
public class Border  extends Entity{
    public Border(double x, double y){
        super(x,y);
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
