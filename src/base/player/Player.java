package base.player;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.enemy.EnemyExplosion;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.*;
import base.scene.GameOverScene;
import base.scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    double angle;
    Action action;
    int hp;
    boolean immune;
    FrameCounter immuneCouter;
    BoxCollider boxCollider;
    FrameCounter smokeCounter;

    public Player() {
        super();
//        this.createRenderer();
//        this.renderer= new SingleImageRenderer(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
//        this.renderer = new RotateRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        this.createRenderer();
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
        this.hp = 3000;
        this.immuneCouter = new FrameCounter(30);
        this.immune = false;
        this.boxCollider = new BoxCollider(this.anchor,this.position, 60, 80);
        this.angle = 0;
        this.smokeCounter = new FrameCounter(10);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/c0.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new RotateRenderer(images, 10);
    }

    public void takeDamage(int damage) {
//        if(this.immune)
//            return;
        this.hp -= damage;
        if(this.hp <= 0) {
            this.hp = 0;
            this.destroy();
        }
//        else {
//            this.immune = true;
//            this.immuneCouter.reset();
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
        if (this.hp == 0) {
            SceneManager.signNewScene(new GameOverScene());
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.velocity.set(3, 0);
        this.immune = false;
        this.immuneCouter.reset();
        this.hp = 3;
    }

    @Override
    public void run() {
        this.move(); //change velocity
        super.run(); //this.position.addThis(this.velocity)
        this.createSmoke();
    }

    private void createSmoke() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        toMouse.setLength(50).scaleThis(-1);
        if (this.smokeCounter.run()){
            SmokeEffect smokeEffect = GameObject.recycle(SmokeEffect.class);
            smokeEffect.position.set(this.position).addThis(toMouse);
            this.smokeCounter.reset();
        }
    }


    private void move() {
//        int vx = 0;
//        int vy = 0;
//        if(KeyEventPress.isUpPress) {
//            angle -= 5;
//        }
//        if(KeyEventPress.isDownPress) {
//            angle += 5;
//        }
//        if(KeyEventPress.isLeftPress) {
//            vx -= 5;
//        }
//        if(KeyEventPress.isRightPress) {
//            vx += 5;
//        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
