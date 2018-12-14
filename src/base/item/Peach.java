package base.item;

import base.GameObject;
import base.Score;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Peach extends Item {

    public Peach() {
        super();
        this.boxCollider = new BoxCollider(this.position, 18, 20);
        this.speed = 10;
        this.position.set(200, 300);
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/items/peach.png"));
    }

    private void move() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        Vector2D velocity = new Vector2D();
        if(toMouse.length() > 10) {
            velocity.set(toMouse.scaleThis(-1).setLength(speed)); // 3 ~ backgroundSpeed
        }
        this.velocity.set(velocity);
    }

    @Override
    public void run() {
        super.run();
        this.move();
    }
}
