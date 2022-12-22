package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
import threadclient.ClientThread;
import java.awt.image.BufferedImage;
public class ImagePanel extends JPanel{
    BufferedImage bi;
    ImageDisplay imageDisplay;
    public void setbi(BufferedImage newValue){
        bi = newValue;
    }
    public BufferedImage getbi(){
        return bi;
    }
    public void setimageDisplay(ImageDisplay newValue){
        imageDisplay = newValue;
    }
    public ImageDisplay getimageDisplay(){
        return imageDisplay;
    }
    public ImagePanel(String[] list,Socket s){
        display(list,s);
    }    
    public void display(String[] list,Socket s){
        // AudioPlayer mp3 = new AudioPlayer(list);
        // ClientThread ct = new ClientThread();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel p =  new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        JLabel[] liste = new JLabel[list.length];
        for(int i=0;i<list.length;i++){
            liste[i] = new JLabel();
            liste[i].setText(list[i]);
            liste[i].setOpaque(true);
            liste[i].setBounds(10,i*20,100,10);
            liste[i].setBackground(new Color(171,204,221,255)); 
            liste[i].addMouseListener(new PickImage(this,liste[i],s));   
            p.add(liste[i]);
        }
        p.setSize(300,400);
        add(p);
        ImageDisplay image = new ImageDisplay(getbi());
        setimageDisplay(image);
        add(image);
        add(new JPanel());
    }
}