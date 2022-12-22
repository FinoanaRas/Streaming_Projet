package socket;
import java.io.*;
import java.net.*;
import java.util.*;
public class ClientSocket extends Socket{
    ObjectInputStream in;
    ObjectOutputStream out;
    public void set_in(ObjectInputStream newValue){
        in = newValue;
    }
    public ObjectInputStream get_in(){
        return in;
    }
    public void set_out(ObjectOutputStream newValue){
        out = newValue;
    }
    public ObjectOutputStream get_out(){
        return out;
    }
    public ClientSocket(String host,int port)throws Exception{
        super(host,port);
        set_in(new ObjectInputStream(new BufferedInputStream(getInputStream())));
        set_out(new ObjectOutputStream(new BufferedOutputStream(getOutputStream())));
    }
}