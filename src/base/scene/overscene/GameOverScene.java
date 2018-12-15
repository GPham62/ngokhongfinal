package base.scene.overscene;

import base.GameObject;
import base.scene.Scene;

public class GameOverScene extends Scene {
    @Override
    public void init() {
        GameObject cover = GameObject.recycle(CoverGameOverScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
