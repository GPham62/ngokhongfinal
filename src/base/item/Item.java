package base.item;

import base.GameObject;
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
        this.hitPlayer();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
