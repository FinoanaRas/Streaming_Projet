package threadclient;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.image.BufferedImage;
import utilities.AudioPlayer;
import jaco.mp3.player.MP3Player;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class ClientThread extends Thread{
    AudioPlayer player;
    EmbeddedMediaPlayer videoPlayer;
    public void setPlayer(AudioPlayer newValue){
        player = newValue;
    }
    public AudioPlayer getPlayer(){
        return player;
    }
    public void setVideoPlayer(EmbeddedMediaPlayer newValue){
        videoPlayer = newValue;
    }
    public EmbeddedMediaPlayer getVideoPlayer(){
        return videoPlayer;
    }

    public ClientThread(AudioPlayer newPlayer){
        setPlayer(newPlayer);
    }
    public ClientThread(){}
    public void run(){
        AudioPlayer mp3 = getPlayer();

        if(mp3.get_on()==0){
            try{
                mp3.play();
                while(!mp3.isStopped()){
                    this.sleep(5000);
                }   
            }catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }        
    }
    
}