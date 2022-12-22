package graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import threadclient.*;
import socket.ClientSocket;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import utilities.AudioPlayer;
public class PickListener implements MouseListener{
    Socket socket;
    JLabel choix;
    String name;
    ClientThread thread;
    public void set_socket(Socket newValue){
        socket = newValue;
    }
    public Socket get_socket(){
        return socket;
    }
    public void set_choix(JLabel newValue){
        choix = newValue;
    }
    public JLabel get_choix(){
        return choix;
    }
    public void set_name(String newValue){
        name = newValue;
    }
    public String get_name(){
        return name;
    }
    public void setThread(ClientThread newValue){
        thread = newValue;
    }
    public ClientThread getThread(){
        return thread;
    }
    public PickListener(ClientThread ct,JLabel choice,Socket s,String t){
        set_choix(choice);
        set_socket(s);
        set_name(t);
        setThread(ct);
    }
    
    public void mouseClicked(MouseEvent e)
    {
        System.out.println(get_choix().getText());
        if(getThread().getPlayer().isStopped()==false){
            getThread().getPlayer().stop();
        }
        if(getThread().getVideoPlayer().isPlaying()){
            getThread().getVideoPlayer().stop();                
        }

        try{
            getThread().getPlayer().setToPlay(get_choix().getText());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {
        
    }
    public void mousePressed(MouseEvent e)
    {
        
    }
    public void mouseReleased(MouseEvent e)
    {
        
    }
}