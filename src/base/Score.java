package base;

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
        this.position.set( Settings.SCREEN_WIDTH - 200, 100);
        this.renderer = new TextRenderer("SCORE: " + value);
        this.increaseCounter = new FrameCounter(20);
    }

    @Override
    public void run() {
        if (this.increaseCounter.run()) {
        this.value++;
        this.increaseCounter.reset();
        }
        this.renderer = new TextRenderer("SCORE: " + value);
        super.run();
    }
}
