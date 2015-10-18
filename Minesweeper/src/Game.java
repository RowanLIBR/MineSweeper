// Rowan Hodson
// Minesweeper
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Game extends JFrame implements MouseListener 
{
    private String sBombs;
    private int Surround_Bomb_number;
    private int Surround_flag_number;
    JButton gbuttons[][];
    JPanel gamePanel;
    JPanel timing;
    JLabel image;
    boolean flag[][];
    boolean bombs[][];
    boolean clicked[][];
    private int row = 10;
    private int col = 10;
    private int width = 400;
    private int height = 350;
    private int NumberBombs = 12;
    private boolean overs = false;
    
    
    public Game(int numbombs, int row, int col, int width, int height)
    {
        
       
        
        super("Minesweeper");
        
        
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        NumberBombs = numbombs;
        bombs = new boolean[row][col];
        flag = new boolean[row][col];
        clicked = new boolean[row][col];
        
        setSize(width,height);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        gamePanel = new JPanel(new GridLayout(row,col));
        
       gbuttons = new JButton[row][col]; // add buttons
        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<col; j++)
            {
                gbuttons[i][j] = new JButton();
                
                gbuttons[i][j].addMouseListener(this);
                gamePanel.add(gbuttons[i][j]);
                add(gamePanel,BorderLayout.CENTER);
            }
        
        }   
    int count = 0;
    while(count< NumberBombs) // setting the bombs at random places
    { // loops until the specified number of bombs have been placed
        int randx = (int)(Math.random()*row);
        int randy = (int)(Math.random()*col);
        if(bombs[randx][randy] == false)
        {
            bombs[randx][randy] = true;
            count++; // increment count if a bomb is placed
        }
    
    
    }  
   
 
    } 
    
    public void mouseClicked(MouseEvent e)
    {
        //loop through game buttons to see if one has been clicked
        for(int i = 0; i<row;i++)
        {
            for(int j = 0;j<col;j++)
            {
                if(e.getSource() == gbuttons[i][j])
                {
                    //see if that button has a flag or mine, and what mouse button clicked it
                    if(e.getButton() == e.BUTTON1 )
                    {
                        
                        
                        if(bombs[i][j] == true && flag[i][j] == false)
                        {
                            ImageIcon bomb = new ImageIcon("bomb.png");
                            gbuttons[i][j].setIcon(bomb); // set label to bomb (* for now, picture later)
                            clicked[i][j] = true;
                            gameover();
                            
                        }
                        else if(flag[i][j] == true) // checks to see if button that was clicked has a flag on it
                        {
                            
                            gbuttons[i][j].setIcon(null);
                            flag[i][j] = false;
                            clicked[i][j] = false; // it's important to change this, as it changes the button to act as if it was never clicked.
                        }
                        else
                        {
                            SurroundB(i,j); // if no bomb or flag on button pressed, the implement this method to determine how many bombs are around the button clicked
                        }
                        }
                    
                else if(e.getButton() == e.BUTTON3)
                {
                    if(flag[i][j] == false && clicked[i][j] == false) // if no flag, and button has not been clicked (does not have a flag, is greyed out, and does not have a number)
                    {
                        ImageIcon flags = new ImageIcon("flags.png");
                        gbuttons[i][j].setIcon(flags);
                        flag[i][j] = true;
                        clicked[i][j] = true;
                    }
                }
                    
              }
            }
          }
        win();
        }
    
    
    public int getBombs(int x, int y)
    {
        int numbomb = 0;
        for(int i = x-1; i<=x+1; i++) // loops through all surrounding buttons to the one pressed checking for bombs
        {
            for(int j = y-1; j<=y+1; j++)
            {
                while(true)
                {
                  if(i<0 || j<0 || i>= row || j>= col) // useful if clicking buttons on the border. Checks if the button checked is in range of the grid
                  {
                      break;
                  }
                  if(bombs[i][j] == true)
                  {
                     numbomb++ ;
                     
                  }
                  break;        
                              
                          
                }
            }
        }
        return numbomb;
        
    }
    public void SurroundB(int x, int y)
    {
        if( getBombs(x,y) == 0)
        {
            recolour(x,y); // grey it out
            
            CheckNoBombs(x,y); // and check all the buttons around it to see how many bombs they have
        }
        else // else if there are bombs around it, assign a number to the button specifying how many bombs
        {
            if(getBombs(x,y) == 2)
            {
               ImageIcon two = new ImageIcon("2.png");
               gbuttons[x][y].setIcon(two);
               
            }
            if(getBombs(x,y) == 1)
            {
              ImageIcon one = new ImageIcon("1.png");
              gbuttons[x][y].setIcon(one);
            }
            if(getBombs(x,y)==3)
            {
                ImageIcon three = new ImageIcon("3.png");
                gbuttons[x][y].setIcon(three);        
            }
            if(getBombs(x,y)==4)
            {
                ImageIcon four = new ImageIcon("4.png");
                gbuttons[x][y].setIcon(four);
            }
            if(getBombs(x,y)==5)
            {
                ImageIcon five = new ImageIcon("5.png");
                gbuttons[x][y].setIcon(five);        
            }
            if(getBombs(x,y)== 6)
            {
                ImageIcon six = new ImageIcon("6.png");
                gbuttons[x][y].setIcon(six);
            }
            if(getBombs(x,y)==7)
            {
                ImageIcon seven = new ImageIcon("7.png");
                gbuttons[x][y].setIcon(seven);
            }
            if(getBombs(x,y) == 8)
            {
                ImageIcon eight = new ImageIcon("8.png");
                gbuttons[x][y].setIcon(eight);
            }
            
            clicked[x][y] = true;
        }
        
        
        
          
    }
    public void recolour(int x,int y)
    {
        gbuttons[x][y].setBackground(Color.GRAY);
        
        clicked[x][y] = true;
    }
    
    public void CheckNoBombs(int x, int y)
    {
        for(int i = x-1; i<=x+1; i++)
        {
            for(int j = y-1; j<=y+1; j++)
            {
                if(i>=0 && j>=0 && i<row && j<col && clicked[i][j] == false && flag[i][j] == false) // if there is no number and no flag on the button, check to see how many bombs are around it
                {
                    SurroundB(i,j); // this method calls the method that calls this method(recursion)
                                    // it does this for each button around the button that had no bombs around it
                    //continue;
                    
                    
                }
                else
                  {
                    continue;
                  }
                    
                    
                  
                  
                
                
            }
        }
    }
    public void win()
    {
            boolean allClicked = true;
            for(int i = 0; i<row; i++)
            {
                for(int j = 0; j<col; j++)
                {
                    if(flag[i][j] == true && bombs[i][j] == false)
                    {
                        allClicked = false;
                    }
                    if(clicked[i][j] == false)
                    {
                        allClicked = false;
                        break;
                    }
                }
            }
            if(allClicked != false)
            {
                Won won = new Won();
                won.setLocationRelativeTo(null);
                won.setVisible(true);
                dispose();
            }
    }
    public void gameover()
    {
        ImageIcon bombss = new ImageIcon("bomb.png");
       for(int i = 0; i<row; i++)
            {
                for(int j = 0; j<col; j++)
                {
                    if(bombs[i][j] == true)
                    {
                        gbuttons[i][j].setBackground(Color.red);
                        
                        
                        gbuttons[i][j].setIcon(bombss);
                        
                    }
                    
                }  
            }
       
       
       
       
       int delay = 2000; //milliseconds
       ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          Lost lost = new Lost();
            lost.setLocationRelativeTo(null);
            lost.setVisible(true);
            dispose();
      }
       };
        Timer timer = new Timer(delay, taskPerformer);
        timer.setRepeats(false);
        timer.start();
        
     }
    
    
        
        
    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }
         
        
 }
    


