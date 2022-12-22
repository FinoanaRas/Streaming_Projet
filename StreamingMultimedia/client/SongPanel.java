package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
import threadclient.ClientThread;
public class SongPanel extends JPanel{
    public SongPanel(String[] list,Socket s,ClientThread ct){
        display(list,s,ct);
    }
    public void display(String[] list,Socket s,ClientThread ct){
        JPanel p =  new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        JLabel[] liste = new JLabel[list.length];
        for(int i=0;i<list.length;i++){
            liste[i] = new JLabel();
            liste[i].setText(ct.getPlayer().getListSongs()[i]);
            liste[i].setOpaque(true);
            liste[i].setBounds(10,i*20,100,10);
            liste[i].setBackground(new Color(171,204,221,255)); 
            liste[i].addMouseListener(new PickListener(ct,liste[i],s,"music.mp3"));   
            p.add(liste[i]);
        }
        p.setSize(300,400);
        add(p);
        JButton bouton = new JButton("play");
        bouton.setBounds(0,0,50,50);
        bouton.addMouseListener(new MusicListener(s,ct,bouton));
        add(bouton);
        JButton bouton2 = new JButton("pause");
        bouton2.setBounds(50,0,50,50);
        bouton2.addMouseListener(new MusicListener(s,ct,bouton2));
        add(bouton2);
        JButton bouton3 = new JButton("stop");
        bouton3.setBounds(100,0,50,50);
        bouton3.addMouseListener(new MusicListener(s,ct,bouton3));
        add(bouton3);    }
}