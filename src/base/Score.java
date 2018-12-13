package base;

import base.enemy.EnemyExplosion;
import base.game.Settings;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import base.renderer.TextRenderer;
import tklibs.SpriteUtils;

public class Score extends GameObject {
    int value;
    FrameCounter increaseCounter;
    public Score(){
        super();
        this.value = 0;
        this.position.set( Settings.SCREEN_WIDTH - 350, 30);
        this.renderer = new TextRenderer("SCORE: " + value);
        this.increaseCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        Player player = null;
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player)
                player = (Player) gameObject;
            break;
        }
        if (player != null)
        if (player.isActive && this.increaseCounter.run()) {
        this.value++;
        this.increaseCounter.reset();
        }
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof EnemyExplosion) {
                this.value += 5;
                break;
            }
        }
        this.renderer = new TextRenderer("SCORE: " + value);
        super.run();
    }

    @Override
    public void reset() {
        this.value = 0;
        super.reset();
    }
}
