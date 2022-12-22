import java.io.*;
import java.net.*;
import utilities.ManageFile;
import utilities.ObjectStreamOut;
import java.nio.file.*;
public class MyServer{
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(3571);
            while(!Thread.currentThread().isInterrupted()){
                Socket s = ss.accept();
                // mandefa listes donnees
                File file = new File("./assets");
                File[] fileList = file.listFiles();
                String[] titres = ManageFile.getTitles(fileList);
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
                oos.writeObject(titres);
                oos.flush();
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
                while(true){
                    String choosed = (String) in.readObject();
                    System.out.println("tonga "+choosed);
                    if(choosed.equals("stop")){
                        break;
                    }
                    byte[] bytefile = Files.readAllBytes(new File("./assets/"+choosed).toPath());
                    // mandefa commande
                    ObjectStreamOut choix = new ObjectStreamOut(new BufferedOutputStream(s.getOutputStream()));
                    choix.writeObject(bytefile);
                    choix.flush();
                }
                //     // mandray commande
                
                oos.close();
            }
            ss.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}