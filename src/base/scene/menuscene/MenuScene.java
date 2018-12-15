package base.scene.menuscene;

import base.GameObject;
import base.scene.Scene;

public class MenuScene extends Scene {
    @Override
    public void init() {
        BackgroundMenuScene backgroundMenuScene = GameObject.recycle(BackgroundMenuScene.class);
        CoverMenuScene cover = GameObject.recycle(CoverMenuScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
