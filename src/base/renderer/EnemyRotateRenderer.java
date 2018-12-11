package base.renderer;

import base.GameObject;
import base.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyRotateRenderer extends RotateRenderer {

    public EnemyRotateRenderer(BufferedImage image) {
        super(image);
    }

    @Override
    public void syncTransform(GameObject master) {
        super.syncTransform(master);
        Player player = null;
        for (GameObject gameObject : GameObject.gameObjects) {
            if(gameObject.isActive && gameObject instanceof Player) {
                player = (Player) gameObject;
                break;
            }
        }
        if(player != null) {
            this.angle = master.position.angleTo(player.position);
        }
    }

    @Override
    public void render(Graphics g, GameObject master) {
        super.render(g, master);
    }
}
