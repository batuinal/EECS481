package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Database
{
  private Connection con;
  private Statement stmt = null;
  private String sql = "";

  public void connect() throws Exception
  {
    if( con != null )
      return;

    try
    {
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch( ClassNotFoundException e )
    {
      throw new Exception("Driver Not Found");
    }

    String connectionUrl = "jdbc:mysql://localhost:3306/gamedb";
    String user = "root";
    String password = "group4";

    try
    {
      con = DriverManager.getConnection(connectionUrl, user, password);
    }
    catch( SQLException e )
    {
      System.out.println("Connection Failed!");
    }

    System.out.println("Connected: " + con);
  }

  public void disconnect()
  {
    if( con != null )
    {
      try
      {
        con.close();
      }
      catch( SQLException e )
      {
        System.out.println("Can't close connection");
      }
    }
  }

  public void createtable()
  {
    try
    {
      stmt = con.createStatement();
      sql = "CREATE TABLE USERINFO " + "(userid INTEGER, "
          + " username CHAR(50) NOT NULL, " + " PRIMARY KEY (userid))";
      // System.out.println(sql);
      stmt.executeUpdate(sql);
      sql = "CREATE TABLE SCORE "
          + "(score INTEGER NOT NULL, "
          + " userid INTEGER, "
          + " songname CHAR(100))";
      stmt.executeUpdate(sql);
      sql = "CREATE TABLE SONG " 
          + "(songid INTEGER, " 
          + "songname CHAR(100), "
          + "songscale CHAR(10), " 
          + "PRIMARY KEY(songid))";
      stmt.executeUpdate(sql);
      System.out.println("Success to create table");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to create table");
      e.printStackTrace();
    }
  }

  public void droptable()
  {
    try
    {
      stmt = con.createStatement();
      sql = "DROP TABLE USERINFO ";
      stmt.executeUpdate(sql);
      sql = "DROP TABLE SONG";
      stmt.executeUpdate(sql);
      sql = "DROP TABLE SCORE";
      // System.out.println(sql);
      stmt.executeUpdate(sql);
      System.out.println("Success to drop table");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to drop table");
      e.printStackTrace();
    }
  }

  public void createSongData()
  {
    String[] songName = new String[12];
    //songName[0] = "test";
    songName[0] = "I Want It That Way";
    songName[1] = "We Are Family";
    songName[2] = "Winter Wonderland";
    songName[3] = "Gangnam Style";
    songName[4] = "Hello Goodbye";
    songName[5] = "Who Let The Dogs Out";
    songName[6] = "Hey Ya";
    songName[7] = "Livin La Vida Loca";
    songName[8] = "Shake It Off";
    songName[9] = "All I Want For Christmas Is You";
    songName[10] = "Here Comes Santa Claus";
    songName[11] = "Winter Wonderland";
    String[] scaleLevel = new String[12];
    scaleLevel[0] = "Easy";
    scaleLevel[1] = "Easy";
    scaleLevel[2] = "Easy";
    scaleLevel[3] = "Normal";
    scaleLevel[4] = "Normal";
    scaleLevel[5] = "Normal";
    scaleLevel[6] = "Hard";
    scaleLevel[7] = "Hard";
    scaleLevel[8] = "Hard";
    scaleLevel[9] = "Christ";
    scaleLevel[10] = "Christ";
    scaleLevel[11] = "Christ";
    try
    {
      for( int i = 0; i < 12; i++ )
      {
        stmt = con.createStatement();
        sql = "INSERT INTO SONG (songid, songname, songscale) " + " Values ("
            + i + ", '" + songName[i] + "','" + scaleLevel[i] + "')";
        stmt.executeUpdate(sql);
      }
      System.out.println("Success to insert songs");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to insert userinfo");
      e.printStackTrace();
    }

  }

  public void adduser(int userid, String username)
  {
    try
    {
      stmt = con.createStatement();
      sql = "INSERT INTO USERINFO (userid, username) " + " Values (" + userid
          + ", '" + username + "')";
      stmt.executeUpdate(sql);
      System.out.println("Success to insert userinfo");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to insert userinfo");
      e.printStackTrace();
    }
  }

  public int currentid()
  {
    int resultid = 0;
    try
    {
      stmt = con.createStatement();
      sql = "SELECT Max(userid) FROM USERINFO";
      ResultSet rs = stmt.executeQuery(sql);
      if( rs.next() )
      {
        resultid = rs.getInt("Max(userid)");
      }
      System.out.println("Success to get currentid");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to get currentid");
      e.printStackTrace();
    }
    return resultid;
  }

  public boolean userexist(String username)
  {
    boolean isExist = Boolean.FALSE;
    try
    {
      stmt = con.createStatement();
      sql = "SELECT * FROM USERINFO WHERE USERNAME = '" + username + "'";
      ResultSet rs = stmt.executeQuery(sql);
      if( rs.next() )
      {
        isExist = Boolean.TRUE;
      }
      System.out.println("Success to check username");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to check username");
      e.printStackTrace();
    }
    return isExist;
  }

  public String getsongName(String scale, int songNum)
  {
    String result = "";
    try
    {
      stmt = con.createStatement();
      sql = "SELECT SONGNAME FROM SONG WHERE SONGSCALE = '" + scale + "'";
      ResultSet rs = stmt.executeQuery(sql);
      int counter = 1;
      while( rs.next() )
      {
        if( counter == songNum )
        {
          result = rs.getString("SONGNAME");
          break;
        }
        counter++;
      }
      System.out.println("Success to get songname");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to getsongname");
      e.printStackTrace();
    }
    return result;
  }

  public void recordScore(int score, int userid, String songname)
  {
    try
    {
      stmt = con.createStatement();
      sql = "INSERT INTO SCORE (score, userid, songname) " + " Values ("
          + score + ", " + userid + ", '" + songname + "')";
      stmt.executeUpdate(sql);
      System.out.println("Success to insert score");
    }
    catch( SQLException e )
    {
      System.out.println("Fail to insert score");
      e.printStackTrace();
    }
  }


  public String[] getHighestScore(String songname)
  {
    String[] strScore;
    strScore = new String[3];

    try
    {
      stmt = con.createStatement();
      sql = "SELECT SCORE, USERID FROM SCORE WHERE SONGNAME = '" + songname
          + "' ORDER BY SCORE DESC";
      ResultSet rs = stmt.executeQuery(sql);
      for( int i = 0; i < 3; i++ )
      {
        if( rs.next() )
        { 
          strScore[i] = String.valueOf(rs.getInt("SCORE"));
        }
        else
        {
          strScore[i] = "";
        }
      }
    }
    catch( SQLException e )
    {
      System.out.println("Fail to getscore");
      e.printStackTrace();
    }
    return strScore;
  }

}
