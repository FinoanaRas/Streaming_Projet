package graphics;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import threadclient.*;
import socket.ClientSocket;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import utilities.AudioPlayer;
public class PickImage implements MouseListener{
    Socket socket;
    JLabel choix;
    ImagePanel imagePanel;
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
    public void setimagePanel(ImagePanel newValue){
        imagePanel = newValue;
    }
    public ImagePanel getimagePanel(){
        return imagePanel;
    }
    public PickImage(ImagePanel ct,JLabel choice,Socket s){
        set_choix(choice);
        set_socket(s);
        setimagePanel(ct);
    }
    public void playProcess(String choix)throws Exception{

        ClientSocket socket = (ClientSocket) get_socket(); 
        ObjectOutputStream oos = socket.get_out() ;
        oos.writeObject(choix);
        oos.flush();

        ObjectInputStream in = socket.get_in();
        byte[] bitFichier = (byte[]) in.readObject();
        Files.deleteIfExists(Paths.get("./assets/image.png"));
        File f = new File(Files.createFile(Paths.get("./assets/image.png")).toString());
        f.deleteOnExit();
        Files.write(f.toPath(),bitFichier);
      
    }
    public void mouseClicked(MouseEvent e)
    {
        System.out.println(get_choix().getText());
        try{
            playProcess(get_choix().getText());
            BufferedImage bi = ImageIO.read(new File("./assets/image.png"));
            getimagePanel().getimageDisplay().setbi(bi);
            getimagePanel().getimageDisplay().repaint();
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