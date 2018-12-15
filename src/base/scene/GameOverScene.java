package base.scene;

import base.CoverGameOverScene;
import base.GameObject;
import base.Score;

public class GameOverScene extends Scene {
    @Override
    public void init() {
        GameObject cover = GameObject.recycle(CoverGameOverScene.class);
        Score score = GameObject.recycle(Score.class);
        score.run();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
