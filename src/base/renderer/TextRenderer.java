package base.renderer;

import base.GameObject;

import java.awt.*;

public class TextRenderer extends Renderer {

    String text;
    public TextRenderer(String text) {
        this.text = text;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.setFont(new Font(null,Font.BOLD,30));
        g.setColor(Color.MAGENTA);
        g.drawString(this.text, (int)master.position.x, (int)master.position.y);
    }
}
