package base.background;

import base.GameObject;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundPart extends GameObject {
    public BackgroundPart() {
        super();
        BufferedImage image = SpriteUtils.loadImage(
                "assets/images/background/background-cloudy.png"
        );
        this.renderer = new SingleImageRenderer(image);
        this.anchor.set(0, 0);
    }
}
