package base.scene.menuscene;

import base.GameObject;
import base.events.KeyEventPress;
import base.game.Settings;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CoverMenuScene extends GameObject {
    public CoverMenuScene() {
        this.createRenderer();
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/w0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/w1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/w2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/w1.png"));
        this.renderer = new AnimationRenderer(images);

    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
