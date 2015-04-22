package guiDesign;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Animation implements Runnable
{
  private static Timer timer;
  private static int nextTimeStamp;
  private static long startTime;
  private static int readCnt = 0;
  private static int lastTimestamp;
  
  private static int girdNum_HoldOn;
  private static String gridColor_HoldOn;
  private static int gridNum;
  private static int lastgridNum;
  private static String lastColor;
  private static String lastDir;

  private Random rand = new Random();
  private static Arrow arrow;
  private static boolean getScore;
  private volatile boolean status = true;


  public void run()
  {
    // While the timeStamp vector isnt empty
    girdNum_HoldOn = -1;
    arrow = new Arrow("", 0);
    ActionListener a = new ActionListener()
    {
      // arrow.randomGenerator();
      // arrowColor = arrow.getColor();
      // arrowSize = arrow.getSize();
      public void actionPerformed(ActionEvent evt)
      { 
        
        //if(readCnt > 5){
          
          gridNum = arrow.getgrid();
          // System.out.println(gridNum);
          if( lastDir.equals("right") )
          {
            if( lastColor.equals("green") )
            {
              if( lastgridNum == 0 )
              {
                Game.rightgreen1.setVisible(false);
              }
              else if( lastgridNum == 1 )
              {
                Game.rightgreen2.setVisible(false);
              }
              else if( lastgridNum == 2 )
              {
                Game.rightgreen3.setVisible(false);
              }
              else
              {
                Game.rightgreen4.setVisible(false);
              }
            }
            else if( lastColor.equals("red") )
            {
              if( lastgridNum == 0 )
              {
                Game.rightred1.setVisible(false);
              }
              else if( lastgridNum == 1 )
              {
                Game.rightred2.setVisible(false);
              }
              else if( lastgridNum == 2 )
              {
                Game.rightred3.setVisible(false);
              }
              else
              {
                Game.rightred4.setVisible(false);
              }
            }
            else
            {
              if( lastgridNum == 0 )
              {
                Game.rightyellow1.setVisible(false);
              }
              else if( lastgridNum == 1 )
              {
           
                Game.rightyellow2.setVisible(false);
              }
              else if( lastgridNum == 2 )
              {
                Game.rightyellow3.setVisible(false);
              }
              else
              {
                Game.rightyellow4.setVisible(false);
              }
            }
          }
          else
          {
            if( lastColor.equals("green") )
            {
              if( lastgridNum == 0 )
              {
                Game.leftgreen1.setVisible(false);
              }
              else if( lastgridNum == 1 )
              {
                Game.leftgreen2.setVisible(false);
              }
              else if( lastgridNum == 2 )
              {
                Game.leftgreen3.setVisible(false);
              }
              else
              {
                Game.leftgreen4.setVisible(false);
              }
            }
            else if( lastColor.equals("red") )
            {
              if( lastgridNum == 0 )
              {
                Game.leftred1.setVisible(false);
              }
              else if( lastgridNum == 1 )
              {
                Game.leftred2.setVisible(false);
              }
              else if( lastgridNum == 2 )
              {
                Game.leftred3.setVisible(false);
              }
              else
              {
                Game.leftred4.setVisible(false);
              }
            }
            else
            {
              if( lastgridNum == 0 )
              {
                Game.leftyellow1.setVisible(false);
              }
              else if( lastgridNum == 1 )
              {
                Game.leftyellow2.setVisible(false);
              }
              else if( lastgridNum == 2 )
              {
                Game.leftyellow3.setVisible(false);
              }
              else
              {
                
                Game.leftyellow4.setVisible(false);
              }
            }
          }
  
          if( arrow.getDir().equals("right") )
          {
            if( arrow.getColor().equals("green") )
            {
              if( gridNum == 0 )
              { // first grid
                Game.rightgreen1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightgreen.png"));
                Game.rightgreen1.setVisible(true);
              }
              else if( gridNum == 1 )
              { // second grid
                Game.rightgreen2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightgreen.png"));
                Game.rightgreen2.setVisible(true);
              }
              else if( gridNum == 2 )
              { // third grid
                Game.rightgreen3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightgreen.png"));
                Game.rightgreen3.setVisible(true);
              }
              else
              {
                Game.rightgreen4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightgreen.png"));
                Game.rightgreen4.setVisible(true);
              }
            }
            else if( arrow.getColor().equals("red") )
            {
              if( gridNum == 0 )
              { // first grid
                Game.rightred1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.png"));
                Game.rightred1.setVisible(true);
              }
              else if( gridNum == 1 )
              { // second grid
                Game.rightred2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.png"));
                Game.rightred2.setVisible(true);
  
              }
              else if( gridNum == 2 )
              { // third grid
                Game.rightred3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.png"));
                Game.rightred3.setVisible(true);
  
              }
              else
              {
                Game.rightred4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.png"));
                Game.rightred4.setVisible(true);
  
              }
            }
            else
            {
              if( gridNum == 0 )
              { // first grid
                Game.rightyellow1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightyellow.png"));
                Game.rightyellow1.setVisible(true);
  
              }
              else if( gridNum == 1 )
              { // second grid
                Game.rightyellow2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightyellow.png"));
                Game.rightyellow2.setVisible(true);
  
              }
              else if( gridNum == 2 )
              { // third grid
                Game.rightyellow3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightyellow.png"));
                Game.rightyellow3.setVisible(true);
  
              }
              else
              {
                Game.rightyellow4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightyellow.png"));
                Game.rightyellow4.setVisible(true);
              }
            }
          }
          else
          { // Left Dir
            if( arrow.getColor().equals("green") )
            {
              if( gridNum == 0 )
              { // first grid
                Game.leftgreen1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.png"));
                Game.leftgreen1.setVisible(true);
  
              }
              else if( gridNum == 1 )
              { // second grid
                Game.leftgreen2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.png"));
                Game.leftgreen2.setVisible(true);
  
              }
              else if( gridNum == 2 )
              { // third grid
                Game.leftgreen3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.png"));
                Game.leftgreen3.setVisible(true);
  
              }
              else
              {
                Game.leftgreen4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.png"));
                Game.leftgreen4.setVisible(true);
  
              }
            }
            else if( arrow.getColor() .equals("red") )
            {
              if( gridNum == 0 )
              { // first grid
                Game.leftred1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.png"));
                Game.leftred1.setVisible(true);
  
              }
              else if( gridNum == 1 )
              { // second grid
                Game.leftred2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.png"));
                Game.leftred2.setVisible(true);
  
              }
              else if( gridNum == 2 )
              { // third grid
                Game.leftred3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.png"));
                Game.leftred3.setVisible(true);
  
              }
              else
              {
                Game.leftred4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.png"));
                Game.leftred4.setVisible(true);
  
              }
            }
            else
            {
              if( gridNum == 0 )
              { // first grid
                Game.leftyellow1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftyellow.png"));
                Game.leftyellow1.setVisible(true);
  
              }
              else if( gridNum == 1 )
              { // second grid
                Game.leftyellow2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftyellow.png"));
                Game.leftyellow2.setVisible(true);
  
              }
              else if( gridNum == 2 )
              { // third grid
                Game.leftyellow3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftyellow.png"));
                Game.leftyellow3.setVisible(true);
  
              }
              else
              {
                Game.leftyellow4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftyellow.png"));
                Game.leftyellow4.setVisible(true);
  
              }
            }
          }
    //    }
        //System.out.println(readCnt);
        readCnt ++;
        girdNum_HoldOn = arrow.getgridNum();
        gridColor_HoldOn = arrow.getColor();
        
        getScore = true;
        //System.out.println("arrow status :" + arrow.getgridNum());
        timer.stop();
        
      }
      
    };


    startTime = System.currentTimeMillis();
    System.out.println("Animation Start!");
    
    Vector<Integer> timeVector = new Vector<Integer>();
    timeVector = (Vector<Integer>)Game.gettimeVector().clone();
    //System.out.println("[vectorsize]" + timeVector.size());
    lastTimestamp = timeVector.lastElement();
    double progress = 0;
    while( !timeVector.isEmpty() && status)
    {
        lastColor = arrow.getColor();
        lastgridNum = arrow.getgrid();
        lastDir = arrow.getDir();
        arrow.randomGenerator();
        arrow.ifsame(lastColor, lastgridNum, lastDir);
        nextTimeStamp = timeVector.get(0);
        timeVector.removeElementAt(0); 
        //System.out.println("[updateProgress]" + nextTimeStamp + " " + lastTimestamp);
        int delay = (int) (long) (nextTimeStamp - (System.currentTimeMillis() - startTime)); // milliseconds
        timer = new Timer(delay, a);
        timer.start();
        while( timer.isRunning() )
        {
  
        }
        
        
     }
    execute.stop();
    status = true;
    System.out.println("[Animate end running]");
  }

  public static int getProgress(){
    //System.out.println((int)(((double)(System.currentTimeMillis() - startTime)/(double)lastTimestamp) * 100));
    int result = (int)(((double)(System.currentTimeMillis() - startTime)/(double)lastTimestamp) * 100);
    if(result <= 100 && result >= 0){
      return result;
    }else{
      return 0;
    }
  }
  
  public static void updategetScore(boolean _getScore){
    getScore = _getScore;
  }
  
  public static boolean getScorestatus(){
    return getScore;
  }
  
  public static int getgirdNum_HoldOn(){
    return girdNum_HoldOn;
  }
  
  public static String getgridColor_HoldOn(){
    return gridColor_HoldOn;
  }
  
  public void stop()
  {
    status = false;
    timer.stop();
  }
}
