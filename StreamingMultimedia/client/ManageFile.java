package utilities;
import java.io.*;
import java.util.*;
public class ManageFile{
    public static String[] getTitles(File[] list){
        String[] titres = new String[list.length];
        for(int i=0;i<list.length;i++){
            titres[i] = list[i].getName();
        }
        return titres;
    }
    public static void tri(String[] list,ArrayList<String> music,ArrayList<String> video,ArrayList<String> image){
        for(int i=0;i<list.length;i++){
            if(list[i].endsWith("mp3")){
                music.add(list[i]);
            }else if(list[i].endsWith("mp4")){
                // System.out.println(list[i]);
                video.add(list[i]);
            }else if(list[i].endsWith("jpg")||list[i].endsWith("png")){
                // System.out.println(list[i]);
                image.add(list[i]);
            }
        }
    }
}