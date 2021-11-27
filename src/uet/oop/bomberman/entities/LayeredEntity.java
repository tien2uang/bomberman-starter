package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class LayeredEntity extends Entity {
    private ArrayList<Entity> arrayEntities;

    public LayeredEntity(double x, double y, ArrayList<Entity>entities) {
        super(x, y);
        this.arrayEntities = entities;
    }

    @Override
    public void update() {
        if(arrayEntities.get(0).getStatus()==VALID) {
            arrayEntities.get(0).update();
        }else{
            arrayEntities.remove(0);
            System.out.println(arrayEntities.size());
        }
        
    }

    @Override
    public void render(GraphicsContext gc) {
        if(arrayEntities.size()>=2){
            arrayEntities.get(1).render(gc);
        }
        arrayEntities.get(0).render(gc);
    }

    @Override
    public double getLayerPower() {
        return arrayEntities.get(0).getLayerPower();
    }
}
