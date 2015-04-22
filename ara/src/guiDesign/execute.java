package guiDesign;

public class execute
{
  private static Game gamer;
  private static musicplayer player;
  private static Animation animate;
  private static Update update;
  private static Thread playerThread, animateThread, serialThread, updateThread;
  private static Serial serial;
  private static String songName;
  private static String userName;
  private BeatswithAra beat;
  
  
  public execute(String _songName, String _userName, BeatswithAra _beat){
    songName = _songName;
    userName = _userName;
    beat = _beat;
  }
  
  
  public void run()
  //public static void main(String[] agrc)
  {
    //songName = "We Are Family";
    gamer = new Game(songName, userName, beat);
    gamer.run();
    
    player = new musicplayer(songName);
    animate = new Animation();
    update = new Update(songName, userName, beat, gamer);
    //serial = new Serial();
    
    playerThread = new Thread(player);// music
    animateThread = new Thread(animate);// animation
    updateThread = new Thread(update);
    //serialThread = new Thread(serial);
    
    playerThread.start();
    animateThread.start();
    updateThread.start();
  }
  
  public static void stop(){
    player.stop();
    animate.stop();
    update.stop();
  }
}
