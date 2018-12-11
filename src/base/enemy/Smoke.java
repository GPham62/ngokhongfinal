package base.enemy;

import base.GameObject;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Smoke extends GameObject {
    public Smoke() {
        super();
        this.createAnimation();
    }

    private void createAnimation() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/bullets/blue.png",
                "assets/images/enemies/bullets/cyan.png"
        );
        this.renderer = new AnimationRenderer(images
                , 1, true);
    }
}
