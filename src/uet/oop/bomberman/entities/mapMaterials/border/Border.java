package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.StaticEntity;

public class Border  extends StaticEntity {
    public Border(double x, double y){
        super(x,y);
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
