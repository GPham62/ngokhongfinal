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
        this.boxCollider = new BoxCollider(this.anchor,this.position, 18, 20);
        this.position.set(200, 300);
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/items/peach.png"));
    }



    @Override
    public void run() {
        super.run();
    }
}
