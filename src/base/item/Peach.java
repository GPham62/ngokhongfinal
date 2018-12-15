package base.item;

import base.GameObject;
import base.Score;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;
import base.renderer.RotateRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Peach extends Item {

    public Peach() {
        super();
        this.boxCollider = new BoxCollider(this.anchor,this.position, 45, 45);
        this.position.set(200, 300);
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/items/Peach.png"));
//        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/items/holo.png"));
        images.add(SpriteUtils.loadImage("assets/images/items/holo2 .png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new AnimationRenderer(images, 10);
    }

    @Override
    public void run() {
        super.run();
    }
}
