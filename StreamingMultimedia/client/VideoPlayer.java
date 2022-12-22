import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import java.awt.*;
public class VideoPlayer implements EmbeddedMediaPlayer{
	int on;
	public void set_on(int newValue){
        on = newValue;
    }
    public int get_on(){
        return on;
    }
	public VideoPlayer(){}
	public void setEnableMouseInputHandling(boolean b){}
	public void setEnableKeyInputHandling(boolean b){}
	public void setFullScreen(boolean b){}
	public void enableOverlay(boolean b){}
	public Window getOverlay(){}
	public void attachVideoSurface(){}
	public boolean isFullScreen(){}
	public boolean overlayEnabled(){}
	public void setOverlay(Window w){}
	public void toggleFullScreen(){}
	public BufferedImage getVideoSurfaceContents(){}
	public void setVideoSurface(CanvasVideoSurface vid){}
}