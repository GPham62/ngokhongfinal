package base.scene;

import base.Score;
import base.background.Background;
import base.GameObject;
import base.enemysummoner.EnemySummoner;
import base.item.HoLo;
import base.item.Peach;
import base.physics.BoxCollider;
import base.player.Player;

public class SceneStage1 extends Scene {
    public GameObject background;
    public GameObject player;
    public EnemySummoner enemySummoner;
    public Score score;
    public Peach peach;
    public HoLo hoLo;

    @Override
    public void init() {
        this.background = GameObject.recycle(Background.class); //new Background()
        this.player = GameObject.recycle(Player.class); //new Player()
        this.enemySummoner = GameObject.recycle(EnemySummoner.class);
        this.score = GameObject.recycle(Score.class);
        this.peach = GameObject.recycle(Peach.class);
        this.hoLo = GameObject.recycle(HoLo.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
