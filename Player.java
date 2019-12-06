package souptime;

import java.awt.*;
import javax.swing.*;

public class Player {
    private int height, width, x, y, vx, vy, hp;
    Image img;
    private Rectangle bounds, bounds2;
    private ImageIcon player;
    public Player(int cWidth, int cHeight){
        this.width = 50;
        this.vx = 0;
        this.hp = 126;
        this.vy = 0;
        this.x = 100;
        this.y = 100;
        this.height = 50;
        this.player = new ImageIcon(getClass().getResource("MainChar.gif"));
        this.img = player.getImage();
        this.bounds = new Rectangle(this.x, this.y, 63, 5);
        this.bounds2 = new Rectangle(this.x, this.y, this.hp / 2, 5);
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public Rectangle getBounds2(){
        return bounds2;
    }
    public void draw(Graphics g){
        g.setColor(Color.red);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.fill(bounds);
        g.setColor(Color.GREEN);
        g2d.fill(bounds2);
    }
    public void update(){
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y - 10, 50, 5);
        this.bounds2 = new Rectangle(this.x, this.y - 10, this.hp / 2, 5);
    }
    public void move(String direction){
        if(direction.equals("right")){
            vx = 3;
        }
        if(direction.equals("left")){
            vx = -3;
        }
        if(direction.equals("up")){
            vy = -3;
        }
        if(direction.equals("down")){
            vy = 3;
        }   
    }
    public void stop(){
        vx = 0;
        vy = 0;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
