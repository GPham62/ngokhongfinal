package base.item;

import base.FrameCounter;
import base.GameObject;
import base.enemy.EnemyHomingBullet;

public class ItemSummoner extends GameObject {
    FrameCounter durationNew;
    public ItemSummoner(){
        super();
        this.durationNew = new FrameCounter(10);
    }

    @Override
    public void run() {
        super.run();
        Item item = null;
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive && gameObject instanceof Item){
                item = (Item) gameObject;
                break;
            }
        }
        if (item == null) {
            if (this.durationNew.run()) {
                Peach p = GameObject.recycle(Peach.class);
                this.durationNew.reset();
            }
        }
    }
}
