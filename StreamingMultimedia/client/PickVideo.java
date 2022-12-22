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
public class PickVideo implements MouseListener{
    Socket socket;
    JLabel choix;
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
    }    public void setThread(ClientThread newValue){
        thread = newValue;
    }
    public ClientThread getThread(){
        return thread;
    }
    public PickVideo(ClientThread ct,JLabel choice,Socket s){
        set_choix(choice);
        set_socket(s);
        setThread(ct);
    }
    public void playProcess(String choix)throws Exception{
       // ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(get_socket().getOutputStream()));
        ClientSocket socket = (ClientSocket) get_socket(); 
        ObjectOutputStream oos = socket.get_out() ;
        oos.writeObject(choix);
        oos.flush();
        // ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(get_socket().getInputStream()));
        ObjectInputStream in = socket.get_in();
        byte[] bitFichier = (byte[]) in.readObject();
        Files.deleteIfExists(Paths.get("./assets/video.mp4"));
        File f = new File(Files.createFile(Paths.get("./assets/video.mp4")).toString());
        f.deleteOnExit();
        Files.write(f.toPath(),bitFichier);
        // oos.close();       
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
            playProcess(get_choix().getText());
            getThread().getVideoPlayer().prepareMedia("./assets/video.mp4");
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