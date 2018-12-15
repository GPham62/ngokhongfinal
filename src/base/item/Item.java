package base.item;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;

import java.util.Random;

public class Item extends GameObject implements Physics {
    BoxCollider boxCollider;
    int randomX, randomY;
    Random rd;
    FrameCounter durationItem;

    public Item() {
        super();
        this.position.set(randomX, randomY);
        this.speed = 10;
        this.durationItem = new FrameCounter(3000);
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
        this.randomPosition();
        this.destroyAfterDuration();
    }

    private void move() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        Vector2D velocity = new Vector2D();
        if(toMouse.length() > 10) {
            velocity.set(toMouse.scaleThis(-1).setLength(speed)); // 3 ~ backgroundSpeed
        }
        this.velocity.set(velocity);
    }

    private void destroyAfterDuration() {
        if (this.isActive && this.durationItem.run()){
            this.destroy();
            this.durationItem.reset();
        }
    }

    private void randomPosition() {
        rd = new Random();
        randomX = rd.nextInt(100) + Settings.SCREEN_WIDTH / 2 + 100;
        randomY = rd.nextInt(100) + Settings.SCREEN_HEIGHT / 2 + 100;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
