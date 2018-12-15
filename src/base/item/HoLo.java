package base.item;

import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HoLo extends Item {

    public HoLo() {
        super();
        this.boxCollider = new BoxCollider(this.anchor,this.position, 45, 45);
        this.position.set(300, 300);
//        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/items/holo.png"));
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/items/holo - Copy.png"));
        images.add(SpriteUtils.loadImage("assets/images/items/holo2 - Copy.png"));
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
