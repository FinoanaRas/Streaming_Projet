package graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import threadclient.*;
import socket.ClientSocket;
import java.io.*;
import java.net.*;
import java.nio.file.*;
public class VideoListener implements MouseListener{
    ClientThread thread;
    JButton bouton;
    Socket socket;
    public void set_socket(Socket newValue){
        socket = newValue;
    }
    public Socket get_socket(){
        return socket;
    }

    public void setThread(ClientThread newValue){
        thread = newValue;
    }
    public ClientThread getThread(){
        return thread;
    }
    public void setBouton(JButton newValue){
        bouton = newValue;
    }
    public JButton getBouton(){
        return bouton;
    }
    public VideoListener(Socket s,ClientThread ct,JButton b){
        setThread(ct);
        setBouton(b);
        set_socket(s);
    }
        public void mouseClicked(MouseEvent e)
    {
        switch(getBouton().getText()){
            case "play":
                getThread().getVideoPlayer().play();
                break;
            case "pause":
                getThread().getVideoPlayer().pause();
                break;
            case "stop":
                getThread().getVideoPlayer().stop();                break;        }
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