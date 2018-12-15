package base.enemysummoner;

import base.GameObject;
import base.action.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxRenderer;

import java.awt.*;

public class EnemySummonerPart extends GameObject implements Physics {
    BoxCollider boxCollider;
    Action action;

    public EnemySummonerPart() {
        this.boxCollider = new BoxCollider(this.anchor,this.position
                , 40, 100);
        this.renderer = new BoxRenderer(this.boxCollider
                , Color.WHITE, true);
        this.position.set(0, 0);

    }



    @Override
    public void run() {
        super.run();

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}

