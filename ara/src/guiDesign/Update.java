package guiDesign;

public class Update implements Runnable
{
  private static boolean status = true;
  private static boolean back = false;
  private static String songName;
  private static String userName;
  private static BeatswithAra beat;
  private static Game gamer;
  public Update(String _songName, String _userName, BeatswithAra _beat, Game _gamer){
    songName = _songName;
    userName = _userName;
    beat = _beat;
    gamer = _gamer;
  }
  
  public void run()
  {
    status = true;
    back = false;
    System.out.println("Status" + status);
    System.out.println("Back" + back);
    while(status){
      //System.out.println("update");
      Game.updateProgress(Animation.getProgress());
      Game.updateScoreboard();
    }
    System.out.println("[End running]");
    if(!back){
      System.out.println(",,,,,,,,,,,,,,,,,,,,,,....................");
      ScoreFrame sf = new ScoreFrame(songName, userName, beat, Game.getScore());
      gamer.dispose();
      sf.run();
      back = false;
    }
    
  }
  
  public void stop(){
    status = false;
  }
  
  public static void setBack(){
    back = true;
  }
}
