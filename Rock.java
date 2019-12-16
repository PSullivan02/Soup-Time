package souptime;

import java.awt.*;
import javax.swing.*;

public class Rock {
    private int x, y, width, height, vx, vy;
    private final int SPEED = 6;
    Image img;
    private boolean alive = true;
    private ImageIcon rock;
    private Rectangle bounds;
    public Rock(int x, int y){
        this.x = x;
        this.y = y;
        this.vx = SPEED;
        this.vy = 0;
        this.width = 18;
        this.height = 20;
        this.rock = new ImageIcon(getClass().getResource("rock.png"));
    }
    public void update(){
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }
    public int getX(){
        return x;
    }
    public void die(){
        this.alive = false;
        this.vx = 0;
        this.vy = 0;
    }
    public boolean isAlive(){
        return alive;
    }
    public int getY(){
        return y;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void draw(Graphics g){
        g.drawImage(img, this.x, this.y, this.width, this.height, null);
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
    }
}
