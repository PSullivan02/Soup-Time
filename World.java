package souptime;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ConcurrentModificationException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class World extends JPanel{
    private Timer timer;
    private Player p;
    private Alien a;
    private ArrayList<Rock> rocks = new ArrayList<>();
    
    public World(){
        super();
        p = new Player(800, 600);
        a = new Alien(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/144);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        g.drawImage(p.img, p.getX(), p.getY(), null);
        p.draw(g);
        g.drawImage(a.img, a.getX(), a.getY(), null);
        a.draw(g);
        for (Rock rock : rocks){
                if(rock == null || !rock.isAlive())
                    continue;
                rock.draw(g);
                g.drawImage(rock.img, rock.getX(), rock.getY(), null);
        }
    }
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            p.update();
            a.update();
            for(Rock rock : rocks){
                rock.update();
            }
            repaint();
        }
    }
    public void checkCollisions(){
        if (p.getBody().intersects(a.getBody())){
            p.loseHealth();
        }
        //if(Rock.getBounds().intersects(a.getBody())){
            
        //}
    }
    public void enemyMovement(){
        if((p.getX() + p.getWidth()) - a.getX() < 0){
            a.move("left");
        }
        if(p.getX() - a.getWidth() > 0){
            a.move("right");
        }
        if(p.getY() - a.getHeight() > 0){
            a.move("up");
        }
        if(p.getHeight() - a.getY() < 0){
            a.move("down");
        }
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p.move("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            p.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p.move("down");
        }
        
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p.stop();
        } 
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p.stop();
        } 
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Rock temp = new Rock(p.getX()+ p.getWidth(), p.getY() + p.getHeight() / 2);
            rocks.add(temp);
        }
    }
}


