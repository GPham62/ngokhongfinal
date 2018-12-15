package base.scene.menuscene;

import base.GameObject;
import base.events.KeyEventPress;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;

public class BackgroundMenuScene extends GameObject {
    public BackgroundMenuScene() {
        this.renderer = new SingleImageRenderer("assets/images/background/menuBackground.png");

        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
