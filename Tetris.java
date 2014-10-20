import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.net.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

class Tetris extends JFrame{

     Image wall=getToolkit().getImage("img/Wall.png"); 
     Image wallheight=getToolkit().getImage("img/Wallheight.png");
     Image wallwidth=getToolkit().getImage("img/Wallwidth.png");
     Image aquablue=getToolkit().getImage("img/Aqua blue.png");
     Image blue=getToolkit().getImage("img/Blue.png");
     Image green=getToolkit().getImage("img/Green.png");
     Image orenge=getToolkit().getImage("img/Orenge.png");
     Image purple=getToolkit().getImage("img/Purple.png");
     Image red=getToolkit().getImage("img/Red.png");
     Image yellow=getToolkit().getImage("img/Yellow.png");

  public static void main(String args[]){
    Tetris frame = new Tetris("テトリス");
    frame.setVisible(true);
  }
  int bwheight = 31;
  int bwwidth = 8;
  int bheight = 55;
  int bwidth = 56;
  public void paint(Graphics g){
  Dimension size = getSize();

  g.setColor(Color.black);
  g.fillRect(0, 0, size.width - 1, size.height - 1);
  //↑壁
  g.drawImage(wall,32,bwheight,this);
  g.drawImage(wall,56,bwheight,this);
  g.drawImage(wall,248,bwheight,this);
  g.drawImage(wall,224,bwheight,this);
  //←縦壁
  g.drawImage(wallheight,bwwidth,bwheight,this);
  //↓壁
  g.drawImage(wallwidth,32,535,this);
  //→壁
  g.drawImage(wallheight,272,bwheight,this);
  //ブロック
  g.drawImage(aquablue,bwidth,bheight,this);
  }
  Tetris(String title){
    setTitle(title);
    setBounds(0, 0, 304, 567);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}