package base.item;

import base.FrameCounter;
import base.GameObject;
import base.Score;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.util.Random;

public class Peach extends Item {
    FrameCounter durationItem;
    int randomX, randomY;
    Random rd;
    public Peach() {
        super();

        randomPosition();

        this.boxCollider = new BoxCollider(this.anchor, this.position, 45, 45);
        this.speed = 10;
        this.position.set(randomX, randomY);
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/items/peach.png"));
        this.durationItem = new FrameCounter(30000);
    }

    private void randomPosition() {
        rd = new Random();
        randomX = rd.nextInt(500) + Settings.SCREEN_WIDTH / 2 + 200;
        randomY = rd.nextInt(500) + Settings.SCREEN_HEIGHT / 2 + 200;
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
    public void run() {
        super.run();
        this.move();
        this.destroyAfterDuration();

    }

    private void destroyAfterDuration() {
        if (this.isActive && this.durationItem.run()){
            this.destroy();
            this.durationItem.reset();
        }
    }
}
