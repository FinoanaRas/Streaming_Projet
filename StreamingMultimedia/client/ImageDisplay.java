package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.image.BufferedImage;
public class ImageDisplay extends JPanel{
    BufferedImage bi;
    public void setbi(BufferedImage newValue){
        bi = newValue;
    }
    public BufferedImage getbi(){
        return bi;
    }

    public ImageDisplay(BufferedImage im){
        setbi(im);
        setPreferredSize(new Dimension(400,400));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(getbi()!=null){
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(getbi(),100,0,this);
            setPreferredSize(new Dimension(getbi().getWidth(),getbi().getHeight()));
            g2d.dispose();
        }
    }
}