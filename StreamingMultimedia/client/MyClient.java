import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import socket.ClientSocket;
import graphics.FrameDisplay;
import jaco.mp3.player.MP3Player;
import utilities.AudioPlayer;
import threadclient.ClientThread;
public class MyClient{
    public static void main(String[] args){
        try{
            // Socket s = new Socket("localhost",3571);
            ClientSocket s = new ClientSocket("localhost",3571);
            String[] liste = (String[]) s.get_in().readObject();
            FrameDisplay frame = new FrameDisplay(liste,s);
            

            }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}