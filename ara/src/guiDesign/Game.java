package guiDesign;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

public class Game extends JFrame implements Runnable
{

  private JPanel contentPane;
  private String songName;
  private static String userName;
  private int gridNum;

  private static Vector<Integer> timeVector;
  private static JProgressBar progressBar;
  private static int score;

  /**
   * JLabel for the arrows
   * 
   * 
   */
  public static JLabel rightgreen1;
  public static JLabel rightgreen2;
  public static JLabel rightgreen3;
  public static JLabel rightgreen4;
  public static JLabel rightred1;
  public static JLabel rightred2;
  public static JLabel rightred3;
  public static JLabel rightred4;
  public static JLabel rightyellow1;
  public static JLabel rightyellow2;
  public static JLabel rightyellow3;
  public static JLabel rightyellow4;
  public static JLabel leftgreen1;
  public static JLabel leftgreen2;
  public static JLabel leftgreen3;
  public static JLabel leftgreen4;
  public static JLabel leftred1;
  public static JLabel leftred2;
  public static JLabel leftred3;
  public static JLabel leftred4;
  public static JLabel leftyellow1;
  public static JLabel leftyellow2;
  public static JLabel leftyellow3;
  public static JLabel leftyellow4;


  private static JLabel Grids;
  public static JLabel scoreLabel;
  private JLabel titleLabel;
  private JLabel backgroundLabel;
  private JButton backButton;
  private JButton left2;
  private JButton left1;
  private JButton left3;
  private JButton right0;
  private JButton right1;
  private JButton right2;
  private JButton right3;
  private JLabel playerLabel;
  private static musicplayer correctSound;


  public static void updateArrow(boolean iseven)
  {
    System.out
        .println("Calling updateArrow helper function, set arrowvisbile to "
            + iseven);

  }

  /**
   * Launch the application.
   */
  public void run()
  {
    /*
    titleLabel.setText(songName);
    titleLabel.setPreferredSize(fitText(songName));
    titleLabel.setBounds(new Rectangle(titleLabel.getLocation(), titleLabel.getPreferredSize()));
    */
    System.out.println("Initialize");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    System.out.println("Frame Create");

    score = 0;
    int readcounter = 0;
    timeVector = new Vector<Integer>();
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(songName + ".txt"));
      String line = null;
      while( (line = reader.readLine()) != null )
      {
          Integer currTime = Integer.parseInt(line);
          timeVector.add(currTime);
      }
      
      System.out.println("NumofTime = " + timeVector.size());
    }
    catch( IOException ex )
    {
      ex.printStackTrace();
    }
    System.out.println("Readin FIle");
    System.out.println("[Game end running]");
  }


  /**
   * Create the frame.
   */
  public Game(String _songName, String _userName, final BeatswithAra _beat)
  {
    songName = _songName;
    userName = _userName;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1920, 1080);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.setLayout(null);
    
    //requestFocus();

    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(new ImageIcon(
        "C:\\Users\\zhangrf\\Desktop\\ezgif-gif-maker.gif"));
    lblNewLabel_1.setBounds(1530, 362, 228, 241);
    contentPane.add(lblNewLabel_1);


    /************************************************************* Green Arrow ****************************************************************/
    /************************************************************* Right **********************************************************************/

    rightgreen1 = new JLabel("");
    rightgreen1.setBounds(497, 213, 333, 248);
    rightgreen1.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightgreen.gif"));
    rightgreen1.setVisible(false);
    contentPane.add(rightgreen1);

    rightgreen2 = new JLabel("");
    rightgreen2.setBounds(1069, 191, 333, 248);
    rightgreen2.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightgreen.gif"));
    rightgreen2.setVisible(false);
    contentPane.add(rightgreen2);

    rightgreen3 = new JLabel("");
    rightgreen3.setBounds(506, 578, 324, 248);
    rightgreen3.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightgreen.gif"));
    rightgreen3.setVisible(false);
    contentPane.add(rightgreen3);

    rightgreen4 = new JLabel("");
    rightgreen4.setBounds(1062, 578, 324, 248);
    rightgreen4.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightgreen.gif"));
    rightgreen4.setVisible(false);
    contentPane.add(rightgreen4);

    /*************************************************************** Left *************************************************************/


    leftgreen1 = new JLabel("");
    leftgreen1.setBounds(497, 191, 333, 248);
    leftgreen1
        .setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.gif"));
    leftgreen1.setVisible(false);
    contentPane.add(leftgreen1);

    leftgreen2 = new JLabel("");
    leftgreen2.setBounds(1069, 191, 333, 248);
    leftgreen2
        .setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.gif"));
    leftgreen2.setVisible(false);
    contentPane.add(leftgreen2);

    leftgreen3 = new JLabel("");
    leftgreen3.setBounds(506, 578, 324, 248);
    leftgreen3
        .setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.gif"));
    leftgreen3.setVisible(false);
    contentPane.add(leftgreen3);

    leftgreen4 = new JLabel("");
    leftgreen4.setBounds(1062, 578, 324, 248);
    leftgreen4
        .setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftgreen.gif"));
    leftgreen4.setVisible(false);
    contentPane.add(leftgreen4);
    /************************************************************************************************************************/

    /*************************************************** Red Arrow ***********************************************************/
    /*************************************************** Right ****************************************************************/

    rightred1 = new JLabel("");
    rightred1.setBounds(497, 191, 333, 248);
    rightred1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.gif"));
    rightred1.setVisible(false);
    contentPane.add(rightred1);

    rightred2 = new JLabel("");
    rightred2.setBounds(1069, 191, 333, 248);
    rightred2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.gif"));
    rightred2.setVisible(false);
    contentPane.add(rightred2);

    rightred3 = new JLabel("");
    rightred3.setBounds(506, 578, 324, 248);
    rightred3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.gif"));
    rightred3.setVisible(false);
    contentPane.add(rightred3);

    rightred4 = new JLabel("");
    rightred4.setBounds(1062, 578, 324, 248);
    rightred4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\rightred.gif"));
    rightred4.setVisible(false);
    contentPane.add(rightred4);

    /*************************************************************** Left *********************************************************************/

    leftred1 = new JLabel("");
    leftred1.setBounds(497, 191, 333, 248);
    leftred1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.gif"));
    leftred1.setVisible(false);
    contentPane.add(leftred1);

    leftred2 = new JLabel("");
    leftred2.setBounds(1069, 191, 333, 248);
    leftred2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.gif"));
    leftred2.setVisible(false);
    contentPane.add(leftred2);

    leftred3 = new JLabel("");
    leftred3.setBounds(506, 578, 324, 248);
    leftred3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.gif"));
    leftred3.setVisible(false);
    contentPane.add(leftred3);

    leftred4 = new JLabel("");
    leftred4.setBounds(1062, 578, 324, 248);
    leftred4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\leftred.gif"));
    leftred4.setVisible(false);
    contentPane.add(leftred4);
    /****************************************************************************************************************************************/

    /************************************************************** Yellow Arrow **************************************************************/
    /************************************************************** Right *********************************************************************/

    rightyellow1 = new JLabel("");
    rightyellow1.setBounds(497, 191, 333, 248);
    rightyellow1.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightyellow.gif"));
    rightyellow1.setVisible(false);
    contentPane.add(rightyellow1);

    rightyellow2 = new JLabel("");
    rightyellow2.setBounds(1069, 191, 333, 248);
    rightyellow2.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightyellow.gif"));
    rightyellow2.setVisible(false);
    contentPane.add(rightyellow2);

    rightyellow3 = new JLabel("");
    rightyellow3.setBounds(506, 578, 324, 248);
    rightyellow3.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightyellow.gif"));
    rightyellow3.setVisible(false);
    contentPane.add(rightyellow3);

    rightyellow4 = new JLabel("");
    rightyellow4.setBounds(1062, 578, 324, 248);
    rightyellow4.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\rightyellow.gif"));
    rightyellow4.setVisible(false);
    contentPane.add(rightyellow4);
    /**************************************************************** Left ********************************************************************/

    leftyellow1 = new JLabel("");
    leftyellow1.setBounds(497, 191, 333, 248);
    leftyellow1.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\leftyellow.gif"));
    leftyellow1.setVisible(false);
    contentPane.add(leftyellow1);

    leftyellow2 = new JLabel("");
    leftyellow2.setBounds(1069, 191, 333, 248);
    leftyellow2.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\leftyellow.gif"));
    leftyellow2.setVisible(false);
    contentPane.add(leftyellow2);

    leftyellow3 = new JLabel("");
    leftyellow3.setBounds(506, 578, 324, 248);
    leftyellow3.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\leftyellow.gif"));
    leftyellow3.setVisible(false);
    contentPane.add(leftyellow3);

    leftyellow4 = new JLabel("");
    leftyellow4.setBounds(1062, 578, 324, 248);
    leftyellow4.setIcon(new ImageIcon(
        "D:\\481 Project\\GUI\\ara\\leftyellow.gif"));
    leftyellow4.setVisible(false);
    contentPane.add(leftyellow4);
    /****************************************************************************************************************************************/

    Grids = new JLabel("");
    Grids.setBounds(355, 102, 1194, 864);
    contentPane.add(Grids);
    Grids.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\Grids.png"));

    progressBar = new JProgressBar();
    progressBar.setForeground(Color.PINK);
    progressBar.setFont(new Font("Kristen ITC", Font.BOLD, 20));
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Game Progress...");
    progressBar.setBorder(border);
    progressBar.setBounds(437, 940, 1033, 51);
    progressBar.setValue(0);
    contentPane.add(progressBar);

    scoreLabel = new JLabel("0");
    scoreLabel.setForeground(Color.WHITE);
    scoreLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 99));
    scoreLabel.setBounds(1559, 36, 335, 183);
    contentPane.add(scoreLabel);
    
    titleLabel = new JLabel(songName);
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setForeground(Color.BLACK);
    titleLabel.setFont(new Font("Calibri", Font.BOLD, 65));
    titleLabel.setBounds(369, 10, 1148, 113);
    contentPane.add(titleLabel);
    
    backButton = new JButton("Back");
    backButton.setFont(new Font("Arial", Font.BOLD, 53));
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Update.setBack();
        execute.stop();
        dispose();
        Thread playerThread = new Thread(BeatswithAra.player);
        playerThread.start();
        _beat.setVisible(true);
      }
    });
    backButton.setBounds(45, 785, 188, 150);
    contentPane.add(backButton);
    //backButton.setVisible(false);
    
    correctSound = new musicplayer("correct");
    JButton left0 = new JButton("left0");
    left0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 0 && Animation.getScorestatus() == true)
        {
          
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    left0.setBounds(43, 128, 93, 23);
    contentPane.add(left0);
    
    left1 = new JButton("left1");
    left1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 1 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    left1.setBounds(165, 128, 93, 23);
    contentPane.add(left1);
    
    left2 = new JButton("left2");
    left2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 2 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    left2.setBounds(43, 174, 93, 23);
    contentPane.add(left2);
    
    left3 = new JButton("left3");
    left3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 3 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    left3.setBounds(165, 174, 93, 23);
    contentPane.add(left3);
    
    right0 = new JButton("right0");
    right0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 4 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    right0.setBounds(45, 263, 93, 23);
    contentPane.add(right0);
    
    right1 = new JButton("right1");
    right1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 5 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    right1.setBounds(165, 263, 93, 23);
    contentPane.add(right1);
    
    right2 = new JButton("right2");
    right2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 6 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    right2.setBounds(43, 305, 93, 23);
    contentPane.add(right2);
    
    right3 = new JButton("right3");
    right3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if( Animation.getgirdNum_HoldOn() == 7 && Animation.getScorestatus() == true)
        {
          updateScore(5);
          Thread correctThread = new Thread(correctSound);
          correctThread.start();
          Animation.updategetScore(false);
        }
      }
    });
    right3.setBounds(165, 305, 93, 23);
    contentPane.add(right3);
    
    
    backgroundLabel = new JLabel("");
    backgroundLabel.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\" + songName + ".png"));
    System.out.println("D:\\481 Project\\GUI\\ara\\" + songName + ".png");
    
    JLabel usernameLabel = new JLabel(userName);
    usernameLabel.setForeground(Color.BLACK);
    usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
    usernameLabel.setBounds(43, 449, 302, 73);
    contentPane.add(usernameLabel);
    
    playerLabel = new JLabel("Player:");
    playerLabel.setForeground(Color.BLACK);
    playerLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
    playerLabel.setBounds(43, 388, 302, 73);
    contentPane.add(playerLabel);
    
    JLabel feedbackLabel = new JLabel("");
    feedbackLabel.setBounds(1595, 319, 54, 15);
    contentPane.add(feedbackLabel);
    backgroundLabel.setBounds(0, 0, 1920, 1080);
    contentPane.add(backgroundLabel);
    

    /* *
      left0.setVisible(false);
      left1.setVisible(false);
      left2.setVisible(false);
      left3.setVisible(false);
      right0.setVisible(false);
      right1.setVisible(false);
      right2.setVisible(false);
      right3.setVisible(false);
    /* */
    
    


    score = 0;


    
    
  }
  
  public static Vector<Integer> gettimeVector(){
    return timeVector;
  }
  
  public static void updateProgress(int progress){
    //System.out.println(progress);
    progressBar.setValue(progress);
  }
  
  public static void updateScore(int _score){
    score = score + _score;
  }
  
  public static int getScore(){
    return score;
  }
  
  public static void updateScoreboard(){
    scoreLabel.setText(Integer.toString(score));
  }
  
  public Dimension fitText(String textfield) { 
    Font defaultFont = new Font("Algerian", Font.PLAIN, 60);
    Canvas canvas = new Canvas();
    FontMetrics fm = canvas.getFontMetrics(defaultFont);
    int width = fm.stringWidth(textfield);
    int height = fm.getHeight();
    System.out.println(width + " " + height); 
    Dimension resizeDim = new Dimension(width+40,height+10);
    return resizeDim;
    
  }
}
