package guiDesign;
import static java.lang.System.out;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

import Database.Database;

import javax.swing.AbstractAction;
import javax.swing.Action;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class BeatswithAra extends JFrame implements Runnable
{
  private JTextField textField;
  private static int nextID = 0;
  private final Action action = new SwingAction();
  private static execute exe;
  private Thread playerThread;
  protected static musicplayer player;
  
  /*
   * Buttons on the welcome page
   * 
   */
  private JButton btnLevel;
  private JButton btnEasy;
  private JButton btnMedium;
  private JButton btnHard;
  private JButton btnSpecial;
  private JButton btnsongName1;
  private JButton btnsongName2;
  private JButton btnsongName3;
  /**
   * Launch the application.
   */
  
  
  public void run()
  {
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
  }

  public BeatswithAra(musicplayer _player)
  {
    player = _player;
    String username = "";
    Database gamedb = new Database();
    try
    {
      gamedb.connect();
    }
    catch( Exception ex )
    {
      ex.printStackTrace();
    }
    nextID = gamedb.currentid();
    gamedb.disconnect();
    setBounds(100, 100, 1920, 1080);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);
    
    
    JLabel lblBeatsWithAra = new JLabel("Beats With Ara");
    lblBeatsWithAra.setBounds(512, 200, 978, 146);
    lblBeatsWithAra.setFont(new Font("Calibri", Font.BOLD, 99));
    lblBeatsWithAra.setForeground(Color.BLACK);
    lblBeatsWithAra.setVerticalAlignment(SwingConstants.TOP);
    lblBeatsWithAra.setHorizontalAlignment(SwingConstants.CENTER);
    getContentPane().add(lblBeatsWithAra);
    
    JLabel lblUsername = new JLabel("Username:");
    lblUsername.setBounds(863, 388, 122, 36);
    lblUsername.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
    getContentPane().add(lblUsername);
    
    textField = new JTextField();
    textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    textField.setBounds(1003, 392, 243, 36);
    getContentPane().add(textField);
    textField.setColumns(10);
    
    
    
    btnLevel = new JButton("Level");
    btnLevel.addActionListener(new welcomeButtonListener());
    btnLevel.setFont(new Font("Calibri", Font.BOLD, 30));
    btnLevel.setBounds(957, 485, 143, 64);
    getContentPane().add(btnLevel);
    
    
    btnEasy = new JButton("Easy");
    btnEasy.setFont(new Font("Calibri", Font.BOLD, 30));
    btnEasy.setBounds(957, 485, 143, 64);
    getContentPane().add(btnEasy);
    btnEasy.addActionListener(new welcomeButtonListener());
    
    btnMedium = new JButton("Normal");
    btnMedium.setFont(new Font("Calibri", Font.BOLD, 30));
    btnMedium.setBounds(957, 571, 143, 64);
    getContentPane().add(btnMedium);
    btnMedium.addActionListener(new welcomeButtonListener());
    
    btnHard = new JButton("Hard");
    btnHard.setFont(new Font("Calibri", Font.BOLD, 30));
    btnHard.setBounds(957, 658, 143, 64);
    getContentPane().add(btnHard);
    btnHard.addActionListener(new welcomeButtonListener());
    
    btnSpecial = new JButton("<html>Holiday<br />Special</html>");
    btnSpecial.setFont(new Font("Calibri", Font.BOLD, 30));
    btnSpecial.setBounds(956, 756, 143, 123);
    getContentPane().add(btnSpecial);
    btnSpecial.addActionListener(new welcomeButtonListener());
    
    
    btnsongName1 = new JButton("");
    btnsongName1.setFont(new Font("Calibri", Font.BOLD, 30));
    btnsongName1.setBounds(1132, 485, 143, 64);
    getContentPane().add(btnsongName1);
    btnsongName1.addActionListener(new welcomeButtonListener());
    
    btnsongName2 = new JButton("");
    btnsongName2.setFont(new Font("Calibri", Font.BOLD, 30));
    btnsongName2.setBounds(1132, 571, 143, 64);
    getContentPane().add(btnsongName2);
    btnsongName2.addActionListener(new welcomeButtonListener());
    
    btnsongName3 = new JButton("");
    btnsongName3.setFont(new Font("Calibri", Font.BOLD, 30));
    btnsongName3.setBounds(1132, 658, 143, 64);
    getContentPane().add(btnsongName3);
    
    
    
    JLabel background = new JLabel("");
    background.setIcon(new ImageIcon("D:\\481 Project\\GUI\\ara\\main.jpg"));
    background.setBounds(0, 0, 1920, 1080);
    getContentPane().add(background);
    btnsongName3.addActionListener(new welcomeButtonListener());
    
    
    /*
     * default status
     */
    btnEasy.setVisible(false);
    btnMedium.setVisible(false);
    btnHard.setVisible(false);
    btnSpecial.setVisible(false);
    btnsongName1.setVisible(false);
    btnsongName2.setVisible(false);
    btnsongName3.setVisible(false);
    
    
    
  }
  
  //get userid
  public static int getCurrentid(){
    return nextID;
  }
  
  
  
  
  
  public class welcomeButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if(event.getSource() == btnLevel)
      {
        btnLevel.setVisible(false);
        btnEasy.setVisible(true);
        btnMedium.setVisible(true);
        btnHard.setVisible(true);
        btnSpecial.setVisible(true);
      }
      else if(event.getSource() == btnEasy)
      {
        Database gamedb = new Database();
        String songName = "";
        try
        {
          gamedb.connect();
        }
        catch( Exception ex )
        {
          ex.printStackTrace();
        }
        songName = gamedb.getsongName("Easy", 1);
        btnsongName1.setText(songName);
        btnsongName1.setPreferredSize(fitText(songName));
        btnsongName1.setBounds(new Rectangle(btnsongName1.getLocation(), btnsongName1.getPreferredSize()));
        songName = gamedb.getsongName("Easy", 2);
        btnsongName2.setText(songName);
        btnsongName2.setPreferredSize(fitText(songName));
        btnsongName2.setBounds(new Rectangle(btnsongName2.getLocation(), btnsongName2.getPreferredSize()));
        songName = gamedb.getsongName("Easy", 3);
        btnsongName3.setText(songName);
        btnsongName3.setPreferredSize(fitText(songName));
        btnsongName3.setBounds(new Rectangle(btnsongName3.getLocation(), btnsongName3.getPreferredSize()));
        gamedb.disconnect();
        
        btnsongName1.setVisible(true);
        btnsongName2.setVisible(true);
        btnsongName3.setVisible(true);
      }
      else if(event.getSource() == btnMedium)
      {
        Database gamedb = new Database();
        String songName = "";
        try
        {
          gamedb.connect();
        }
        catch( Exception ex )
        {
          ex.printStackTrace();
        }
        songName = gamedb.getsongName("Normal", 1);
        btnsongName1.setText(songName);
        btnsongName1.setPreferredSize(fitText(songName));
        btnsongName1.setBounds(new Rectangle(btnsongName1.getLocation(), btnsongName1.getPreferredSize()));
        songName = gamedb.getsongName("Normal", 2);
        btnsongName2.setText(songName);
        btnsongName2.setPreferredSize(fitText(songName));
        btnsongName2.setBounds(new Rectangle(btnsongName2.getLocation(), btnsongName2.getPreferredSize()));
        songName = gamedb.getsongName("Normal", 3);
        btnsongName3.setText(songName);
        btnsongName3.setPreferredSize(fitText(songName));
        btnsongName3.setBounds(new Rectangle(btnsongName3.getLocation(), btnsongName3.getPreferredSize()));
        gamedb.disconnect();
        
        btnsongName1.setVisible(true);
        btnsongName2.setVisible(true);
        btnsongName3.setVisible(true);
      }
      else if(event.getSource() == btnHard)
      {
        Database gamedb = new Database();
        String songName = "";
        try
        {
          gamedb.connect();
        }
        catch( Exception ex )
        {
          ex.printStackTrace();
        }
        songName = gamedb.getsongName("Hard", 1);
        btnsongName1.setText(songName);
        btnsongName1.setPreferredSize(fitText(songName));
        btnsongName1.setBounds(new Rectangle(btnsongName1.getLocation(), btnsongName1.getPreferredSize()));
        songName = gamedb.getsongName("Hard", 2);
        btnsongName2.setText(songName);
        btnsongName2.setPreferredSize(fitText(songName));
        btnsongName2.setBounds(new Rectangle(btnsongName2.getLocation(), btnsongName2.getPreferredSize()));
        songName = gamedb.getsongName("Hard", 3);
        btnsongName3.setText(songName);
        btnsongName3.setPreferredSize(fitText(songName));
        btnsongName3.setBounds(new Rectangle(btnsongName3.getLocation(), btnsongName3.getPreferredSize()));
        gamedb.disconnect();
        
        btnsongName1.setVisible(true);
        btnsongName2.setVisible(true);
        btnsongName3.setVisible(true);
      }
      else if(event.getSource() == btnSpecial)
      {
        Database gamedb = new Database();
        String songName = "";
        try
        {
          gamedb.connect();
        }
        catch( Exception ex )
        {
          ex.printStackTrace();
        }
        songName = gamedb.getsongName("Christ", 1);
        btnsongName1.setText(songName);
        btnsongName1.setPreferredSize(fitText(songName));
        btnsongName1.setBounds(new Rectangle(btnsongName1.getLocation(), btnsongName1.getPreferredSize()));
        songName = gamedb.getsongName("Christ", 2);
        btnsongName2.setText(songName);
        btnsongName2.setPreferredSize(fitText(songName));
        btnsongName2.setBounds(new Rectangle(btnsongName2.getLocation(), btnsongName2.getPreferredSize()));
        songName = gamedb.getsongName("Christ", 3);
        btnsongName3.setText(songName);
        btnsongName3.setPreferredSize(fitText(songName));
        btnsongName3.setBounds(new Rectangle(btnsongName3.getLocation(), btnsongName3.getPreferredSize()));
        gamedb.disconnect();
        
        btnsongName1.setVisible(true);
        btnsongName2.setVisible(true);
        btnsongName3.setVisible(true);
      }
      else if(event.getSource() == btnsongName1)
      {
        String username = textField.getText();
        if(username.equals("")){
          String errorInfo = "Please enter your username!";
          JOptionPane.showMessageDialog(BeatswithAra.this, errorInfo, "Username Error!", JOptionPane.ERROR_MESSAGE);
        }else{
          player.stop();
          Database gamedb = new Database();
          try
          {
            gamedb.connect();
          }
          catch( Exception ex )
          {
            ex.printStackTrace();
          }
          
          if(!gamedb.userexist(username))
          {
            nextID++;
            gamedb.adduser(nextID, username);
            out.printf("Hello %s, Welcome to Beats with Ara! \n",
                textField.getText());
          }
          gamedb.disconnect();
          BeatswithAra.this.setVisible(false);
          System.out.println("open exe");
          exe = new execute(btnsongName1.getText(),username,BeatswithAra.this);
          exe.run();
          
        }
      }
      else if(event.getSource() == btnsongName2)
      {
        String username = textField.getText();
        if(username.equals("")){
          String errorInfo = "Please enter your username!";
          JOptionPane.showMessageDialog(BeatswithAra.this, errorInfo, "Username Error!", JOptionPane.ERROR_MESSAGE);
        }else{
          player.stop();
          Database gamedb = new Database();
          try
          {
            gamedb.connect();
          }
          catch( Exception ex )
          {
            ex.printStackTrace();
          }
          if(!gamedb.userexist(username))
          {
            nextID++;
            gamedb.adduser(nextID, username);
            out.printf("Hello %s, Welcome to Beats with Ara! \n",
                textField.getText());
          }
          gamedb.disconnect();
          BeatswithAra.this.setVisible(false);
          System.out.println("open exe");
          exe = new execute(btnsongName2.getText(),username,BeatswithAra.this);
          exe.run();
        }
      }
      else if(event.getSource() == btnsongName3)
      {
        String username = textField.getText();
        if(username.equals("")){
          String errorInfo = "Please enter your username!";
          JOptionPane.showMessageDialog(BeatswithAra.this, errorInfo, "Username Error!", JOptionPane.ERROR_MESSAGE);
        }else{
          player.stop();
          Database gamedb = new Database();
          try
          {
            gamedb.connect();
          }
          catch( Exception ex )
          {
            ex.printStackTrace();
          }
          if(!gamedb.userexist(username))
          {
            nextID++;
            gamedb.adduser(nextID, username);
            out.printf("Hello %s, Welcome to Beats with Ara! \n",
                textField.getText());
          }
          gamedb.disconnect();
          BeatswithAra.this.setVisible(false);
          System.out.println("open exe");
          exe = new execute(btnsongName3.getText(),username,BeatswithAra.this);
          exe.run();
        }
      }
    }
    
  }
  
  
  public Dimension fitText(String textfield) { 
    Font defaultFont = new Font("Calibri", Font.BOLD, 30);
    Canvas canvas = new Canvas();
    FontMetrics fm = canvas.getFontMetrics(defaultFont);
    int width = fm.stringWidth(textfield);
    int height = fm.getHeight();
    //System.out.println(width + " " + height); 
    Dimension resizeDim = new Dimension(width+40,height+10);
    return resizeDim;
    
  }
  
  
  private class SwingAction extends AbstractAction {
    public SwingAction() {
      putValue(NAME, "SwingAction");
      putValue(SHORT_DESCRIPTION, "Some short description");
    }
    public void actionPerformed(ActionEvent e) {
    }
  }
  
  public static musicplayer getplayer(){
    return player;
  }
  
  public void recover(){
    setVisible(true);
    
  }
}
