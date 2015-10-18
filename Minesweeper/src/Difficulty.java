import java.net.URL;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Difficulty extends JFrame implements ActionListener
{
  JPanel top;
  JPanel middle;
  JPanel bottom;
  JButton easy;
  JButton medium;
  JButton hard;
  JButton exit;
  JLabel Title;
  Timer time;
  
  
  
  
  public Difficulty()
  {
      super();
      
      setSize(500,500);
      setLayout(new BorderLayout());
      top = new JPanel();
      top.setLayout(new BorderLayout());
      top.setPreferredSize(new Dimension(500,100));
      byte[] buffer = new byte[20];
      
      
      ImageIcon title = new ImageIcon("title.jpg");
      Title = new JLabel();
      Title.setIcon(title);
      
      top.add(Title);
      add(top,BorderLayout.NORTH);
      
      middle = new JPanel();
      middle.setLayout(new GridLayout(3,1));
      easy = new JButton("Easy");
      easy.setBackground(Color.WHITE);
      easy.addActionListener(this);
      middle.add(easy);
      medium = new JButton("Medium");
      medium.setBackground(Color.WHITE);
      
      medium.addActionListener(this);
      middle.add(medium);
      hard = new JButton("Hard");
      hard.setBackground(Color.WHITE);
      hard.addActionListener(this);
      middle.add(hard);
      add(middle,BorderLayout.CENTER);
      
      bottom = new JPanel();
      bottom.setLayout(new BorderLayout());
      exit = new JButton("Exit");
      exit.addActionListener(this);
      bottom.add(exit,BorderLayout.CENTER);
      add(bottom, BorderLayout.SOUTH);
      
      
      
  }
  
  public void actionPerformed(ActionEvent e)
  {
      String clicked = e.getActionCommand();
      if(clicked.equals("Easy"))
      {
          dispose();
          Game newgame = new Game(12,10,10,400,400);
          ImageIcon wIcon= new ImageIcon("ibomb.jpg");
          newgame.setIconImage(wIcon.getImage());
          newgame.setVisible(true);
      }
      if(clicked.equals("Medium"))
          
      {
          dispose();
          Game newgame = new Game(30,15,15,600,600);
          ImageIcon wIcon= new ImageIcon("ibomb.jpg");
          newgame.setIconImage(wIcon.getImage());
          newgame.setVisible(true);
      }
      if(clicked.equals("Hard"))
      {
          dispose();
          Game newgame = new Game(100,20,30,1080,720);
          ImageIcon wIcon= new ImageIcon("ibomb.jpg");
          newgame.setIconImage(wIcon.getImage());
          newgame.setVisible(true);
      }
      if(clicked.equals("Exit"))
      {
          System.exit(0);
      }
      
  }
    
}
