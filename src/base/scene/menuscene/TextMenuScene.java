package base.scene.menuscene;

import base.GameObject;
import base.game.Settings;
import base.renderer.TextRenderer;

import java.awt.*;

public class TextMenuScene extends GameObject {
    public TextMenuScene(){
        this.renderer = new TextRenderer("Team 2 present");
        this.position.set(Settings.SCREEN_WIDTH/2 - 400, 200);
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font(null,Font.BOLD,100));
        g.setColor(Color.GREEN);
        super.render(g);
    }
}
