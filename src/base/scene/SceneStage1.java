package base.scene;

import base.background.Background;
import base.GameObject;
import base.enemysummoner.EnemySummoner;
import base.player.Player;

public class SceneStage1 extends Scene {
    public GameObject background;
    public GameObject player;
    public EnemySummoner enemySummoner;

    @Override
    public void init() {
        this.background = GameObject.recycle(Background.class); //new Background()
        this.player = GameObject.recycle(Player.class); //new Player()
//        Enemy enemy = GameObject.recycle(Enemy.class); // new Enemy()
        this.enemySummoner = GameObject.recycle(EnemySummoner.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
