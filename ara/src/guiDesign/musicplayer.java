package guiDesign;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class musicplayer implements Runnable
{
  protected Player player;
  private volatile boolean status = true;
  private String songName;
  
  public musicplayer(String _songName){
    songName = _songName;
  }
  
  public void run()
  {
    try
    {
      File file = new File(songName + ".mp3");
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      try
      {
        player = new Player(bis);
        System.out.println("before play");
        player.play();
        System.out.println("after play");
        
      } catch(JavaLayerException ex1)
      {
        ex1.printStackTrace();
      }
    } catch(IOException ex)
    {
       ex.printStackTrace();
    }
    /*
    
    */
    //System.out.println(!player.isComplete() + " " + status);
  }
  
  public void stop()
  {
    System.out.println("[close Player]");
    player.close();
  }
}
