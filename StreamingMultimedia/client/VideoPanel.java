package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
import threadclient.ClientThread;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class VideoPanel extends JPanel{
    public VideoPanel(String[] list,Socket s,ClientThread ct){
        chargeLibrary();
        display(list,s,ct);
    }    
    public void chargeLibrary(){
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:/Program Files/VideoLAN/VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
        LibXUtil.initialise();
    }
    public void display(String[] list,Socket s,ClientThread ct){
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
            liste[i].addMouseListener(new PickVideo(ct,liste[i],s));   
            p.add(liste[i]);
        }
        p.setSize(300,100);
        add(p);
        Canvas c = new Canvas();
        //L'arrière plan de la vidéo est noir par défaut
        c.setBackground(Color.black);
        //La vidéo prend toute la surface
        c.setBounds(0,150,800,350);
        c.setBackground(Color.black);
        //Créer une instance factory
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        //Créer une instance lecteur média
        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
        //Cacher le curseur de la souris à l'intérieur de JFrame
        mediaPlayer.setEnableMouseInputHandling(true);
        //Désactiver le clavier à l'intérieur de JFrame
        mediaPlayer.setEnableKeyInputHandling(true);
        add(c);
        JPanel buttons = new JPanel();
        ct.setVideoPlayer(mediaPlayer);
        JButton bouton = new JButton("play");
        bouton.setBounds(0,0,50,50);
        bouton.addMouseListener(new VideoListener(s,ct,bouton));
        buttons.add(bouton);
        JButton bouton2 = new JButton("pause");
        bouton2.setBounds(50,0,50,50);
        bouton2.addMouseListener(new VideoListener(s,ct,bouton2));
        buttons.add(bouton2);
        JButton bouton3 = new JButton("stop");
        bouton3.setBounds(100,0,50,50);
        bouton3.addMouseListener(new VideoListener(s,ct,bouton3));
        buttons.add(bouton3);
        add(buttons);
        setSize(800,500);
           }
}