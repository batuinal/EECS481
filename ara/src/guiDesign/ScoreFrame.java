package guiDesign;

import guiDesign.BeatswithAra.welcomeButtonListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreFrame extends JFrame
{

  private static int score;
  private static String songName;
  private static String userName;
  private static JLabel scoreLabel;
  /**
   * Launch the application.
   */
  public void run(){
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    for(int i = 0; i <= score; i++){
      long currentTime = System.currentTimeMillis();
      while((System.currentTimeMillis() - currentTime) < 10){
        
      }
      scoreLabel.setText(String.valueOf(i));
    }
    
  }

  /**
   * Create the frame.
   */
  public ScoreFrame(String _songName, String _userName, final BeatswithAra _beat, int _score)
  {
    songName = _songName;
    userName = _userName;
    score = _score;
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1920, 1080);
    getContentPane().setLayout(null);
    
    JLabel Score = new JLabel("Score Board");
    Score.setBounds(670, 43, 523, 146);
    Score.setFont(new Font("Calibri", Font.BOLD, 99));
    Score.setForeground(Color.WHITE);
    Score.setVerticalAlignment(SwingConstants.TOP);
    Score.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(Score);
    
    JLabel Congrats = new JLabel("Congratulaions, You finish the game!");
    Congrats.setVerticalAlignment(SwingConstants.TOP);
    Congrats.setHorizontalAlignment(SwingConstants.CENTER);
    Congrats.setForeground(Color.WHITE);
    Congrats.setFont(new Font("Calibri", Font.BOLD, 40));
    Congrats.setBounds(512, 165, 835, 61);
    getContentPane().add(Congrats);
    
    JLabel Rank1 = new JLabel("1st High: ");
    Rank1.setVerticalAlignment(SwingConstants.TOP);
    Rank1.setHorizontalAlignment(SwingConstants.CENTER);
    Rank1.setForeground(Color.BLACK);
    Rank1.setFont(new Font("Calibri", Font.BOLD, 40));
    Rank1.setBounds(595, 310, 222, 61);
    getContentPane().add(Rank1);
    
    JLabel score1 = new JLabel("");
    score1.setVerticalAlignment(SwingConstants.TOP);
    score1.setHorizontalAlignment(SwingConstants.LEFT);
    score1.setForeground(Color.BLACK);
    score1.setFont(new Font("Calibri", Font.BOLD, 40));
    score1.setBounds(864, 310, 541, 61);
    getContentPane().add(score1);
    
    JLabel Rank2 = new JLabel("2nd High: ");
    Rank2.setVerticalAlignment(SwingConstants.TOP);
    Rank2.setHorizontalAlignment(SwingConstants.CENTER);
    Rank2.setForeground(Color.BLACK);
    Rank2.setFont(new Font("Calibri", Font.BOLD, 40));
    Rank2.setBounds(595, 396, 222, 61);
    getContentPane().add(Rank2);
    
    JLabel score2 = new JLabel("");
    score2.setVerticalAlignment(SwingConstants.TOP);
    score2.setHorizontalAlignment(SwingConstants.LEFT);
    score2.setForeground(Color.BLACK);
    score2.setFont(new Font("Calibri", Font.BOLD, 40));
    score2.setBounds(864, 396, 541, 61);
    getContentPane().add(score2);
    
    JLabel Rank3 = new JLabel("3rd High: ");
    Rank3.setVerticalAlignment(SwingConstants.TOP);
    Rank3.setHorizontalAlignment(SwingConstants.CENTER);
    Rank3.setForeground(Color.BLACK);
    Rank3.setFont(new Font("Calibri", Font.BOLD, 40));
    Rank3.setBounds(595, 488, 222, 61);
    getContentPane().add(Rank3);
    
    JLabel score3 = new JLabel("");
    score3.setVerticalAlignment(SwingConstants.TOP);
    score3.setHorizontalAlignment(SwingConstants.LEFT);
    score3.setForeground(Color.BLACK);
    score3.setFont(new Font("Calibri", Font.BOLD, 40));
    score3.setBounds(864, 488, 541, 61);
    getContentPane().add(score3);
    
    JLabel userScoreLabel = new JLabel("Your Score :");
    userScoreLabel.setVerticalAlignment(SwingConstants.TOP);
    userScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
    userScoreLabel.setForeground(Color.BLACK);
    userScoreLabel.setFont(new Font("Calibri", Font.BOLD, 99));
    userScoreLabel.setBounds(599, 685, 516, 146);
    getContentPane().add(userScoreLabel);
    
    scoreLabel = new JLabel("0");
    scoreLabel.setVerticalAlignment(SwingConstants.TOP);
    scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
    scoreLabel.setForeground(Color.BLACK);
    scoreLabel.setFont(new Font("Calibri", Font.BOLD, 99));
    scoreLabel.setBounds(1141, 685, 789, 146);
    getContentPane().add(scoreLabel);
    
    JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        Thread playerThread = new Thread(BeatswithAra.player);
        playerThread.start();
        _beat.setVisible(true);
      }
    });
    backButton.setForeground(Color.BLACK);
    backButton.setBackground(Color.WHITE);
    backButton.setFont(new Font("Calibri", Font.BOLD, 30));
    backButton.setBounds(730, 797, 144, 74);
    getContentPane().add(backButton);
    
    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    quitButton.setForeground(Color.BLACK);
    quitButton.setFont(new Font("Calibri", Font.BOLD, 30));
    quitButton.setBackground(Color.WHITE);
    quitButton.setBounds(971, 797, 144, 74);
    getContentPane().add(quitButton);
    
    JLabel fireLabel1 = new JLabel("");
    fireLabel1.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\Fireworks.gif"));
    fireLabel1.setBounds(98, 375, 244, 117);
    getContentPane().add(fireLabel1);
    
    JLabel fireLabel2 = new JLabel("");
    fireLabel2.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\Fireworks.gif"));
    fireLabel2.setBounds(310, 829, 244, 117);
    getContentPane().add(fireLabel2);
    
    JLabel fireLabel3 = new JLabel("");
    fireLabel3.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\Fireworks.gif"));
    fireLabel3.setBounds(1123, 275, 244, 117);
    getContentPane().add(fireLabel3);
    
    JLabel fireLabel4 = new JLabel("");
    fireLabel4.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\Fireworks.gif"));
    fireLabel4.setBounds(1200, 596, 244, 117);
    getContentPane().add(fireLabel4);
    
    
    JLabel background = new JLabel("");
    background.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\score.jpg"));
    background.setBounds(10, 10, 1920, 1080);
    getContentPane().add(background);
    
    Database gamedb = new Database();
    try
    {
      gamedb.connect();
    }
    catch( Exception ex )
    {
      ex.printStackTrace();
    }

    gamedb.recordScore(score,BeatswithAra.getCurrentid(), songName);
    String[] scoreboard = gamedb.getHighestScore(songName);
    if(scoreboard.length > 0)
    {
      score1.setText(scoreboard[0]);
    }
    if(scoreboard.length > 1)
    {
      score2.setText(scoreboard[1]);
    }
    if(scoreboard.length > 2)
    {
      score3.setText(scoreboard[2]);
    }
    gamedb.disconnect();
  }
}
