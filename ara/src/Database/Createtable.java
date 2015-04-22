package Database;


public class Createtable
{
  public static void main(String[] argc)
  {
    System.out.println("Create Tables");
    String sql = "";
    Database gamedb = new Database();
    try
    {
      gamedb.connect();
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    
    gamedb.createtable();
    gamedb.createSongData();
    
    
    gamedb.adduser(0,"a");
    gamedb.adduser(1,"b");
    gamedb.adduser(2,"c");
    gamedb.adduser(3,"d");
    
    gamedb.recordScore(100, 0, "We Are Family");
    gamedb.recordScore(50, 1, "We Are Family");
    gamedb.recordScore(160, 2, "We Are Family");
    
    String[] result =  gamedb.getHighestScore("We Are Family");
    for(int i = 0; i < result.length; i++)
    {
      System.out.println(result[i]);
    }
    
    gamedb.disconnect();
  }
}
