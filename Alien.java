package souptime;

import java.awt.*;
import javax.swing.*;

public class Alien {
    
    private int height, width, x, y, vx, vy, hp;
    Image img;
    private Rectangle bounds, bounds2, body;
    private ImageIcon alien;
    public Alien(int cWidth, int cHeight){
        this.width = 50;
        this.vx = 0;
        this.body = new Rectangle(x, y, width, height);
        this.hp = 50;
        this.vy = 0;
        this.x = 100;
        this.y = 100;
        this.height = 50;
        this.alien = new ImageIcon(getClass().getResource("alien.png"));
        this.img = alien.getImage();
        this.bounds = new Rectangle(this.x, this.y, 50, 5);
        this.bounds2 = new Rectangle(this.x, this.y, this.hp, 5);
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
        g2d.fill(bounds);
        g.setColor(Color.GREEN);
        g2d.fill(bounds2);
    }
    public void update(){
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y - 10, 50, 5);
        this.bounds2 = new Rectangle(this.x, this.y - 10, this.hp, 5);
    }
    public void move(String direction){
        if(direction.equals("right")){
            vx = 2;
        }
        if(direction.equals("left")){
            vx = -2;
        }
        if(direction.equals("up")){
            vy = -2;
        }
        if(direction.equals("down")){
            vy = 2;
        }   
    }
    public Rectangle getBody(){
        return body;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
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
