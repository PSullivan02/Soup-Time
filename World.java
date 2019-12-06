package souptime;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class World extends JPanel{
    private Timer timer;
    private Player p;
    
    public World(){
        super();
        p = new Player(800, 600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/144);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        g.drawImage(p.img, p.getX(), p.getY(), null);
        p.draw(g);
    }
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            p.update();
            repaint();
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            
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
    }
}

