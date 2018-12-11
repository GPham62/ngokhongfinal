package base.renderer;

import base.GameObject;
import base.events.MouseEventMotion;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RotateRenderer extends Renderer {

    BufferedImage image;
    double angle;
    AffineTransform transform;
    AffineTransform emptyTransform;

    public RotateRenderer(BufferedImage image) {
//        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        this.image = image;
        this.angle = 0;
        this.transform = new AffineTransform();
        this.emptyTransform = new AffineTransform();
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Graphics2D g2D = (Graphics2D) g;
        this.syncTransform(master);
        g2D.drawImage(this.image, this.transform, null);
    }

    public void syncTransform(GameObject master) {
        this.transform.setTransform(this.emptyTransform);

        double x = master.position.x - image.getWidth() * master.anchor.x;
        double y = master.position.y - image.getHeight() * master.anchor.y;
        this.transform.translate(x, y);

        this.angle = master.position.angleTo(MouseEventMotion.mousePosition);
//        this.transform.setToRotation(this.angle, image.getWidth() / 2
//                , image.getHeight() / 2);
        this.transform.rotate(this.angle, image.getWidth() / 2
                , image.getHeight() / 2);
//        this.transform.rotate(this.angle);
    }
}
