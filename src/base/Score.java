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
        this.increaseCounter = new FrameCounter(20);
    }

    @Override
    public void run() {
        if (this.increaseCounter.run()) {
        this.value++;
        this.increaseCounter.reset();
        }
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof EnemyExplosion) {
                this.value += 10;
            }
        }
        this.renderer = new TextRenderer("SCORE: " + value);
        super.run();
    }
}
