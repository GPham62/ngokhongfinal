package base.item;

import base.GameObject;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;

public class Item extends GameObject implements Physics {
    BoxCollider boxCollider;
    public Item() {
        super();
    }

    public void hitPlayer() {
        Player player = null;
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Player)
                player = (Player) gameObject;
        }
        if (player != null && this.getBoxCollider().intersects(player.getBoxCollider())){
            this.destroy();
        }
    }
    @Override
    public void run() {
        super.run();
        this.move();
        this.hitPlayer();
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
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
