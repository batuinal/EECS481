package guiDesign;
import javax.swing.JFrame;

public class Starter
{ 
  public static void main(String[] agrc)
  {
    musicplayer player = new musicplayer("sakula");
    Thread playerThread = new Thread(player);
    playerThread.start();
    BeatswithAra beat = new BeatswithAra(player);
    beat.run();
  }
}