import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Won extends JFrame implements ActionListener 
{
    JPanel youlost;
    JPanel options;
    JButton play;
    JButton exit;
    JLabel won;
    
    public Won()
    {
        super();
        
        setSize(300,225);
        setLayout(new GridLayout(2,1));
        youlost = new JPanel();
        won = new JLabel();
        ImageIcon over = new ImageIcon("winning.jpg");
        won.setIcon(over);
        youlost.add(won);
        add(youlost);
        
        options = new JPanel();
        options.setLayout(new FlowLayout());
        play = new JButton("Play Again?");
        play.addActionListener(this);
        play.setBackground(Color.CYAN);
        options.add(play);
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBackground(Color.CYAN);
        options.add(exit);
        options.setBackground(Color.WHITE);
        add(options);
        
        
        
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String clicked = e.getActionCommand();
        if(clicked.equals("Play Again?"))
        {
            Difficulty d = new Difficulty();
            d.setLocationRelativeTo(null);
            d.setVisible(true);
            this.dispose();
            
        }
        else if(clicked.equals("Exit"))
        {
            System.exit(0);
        }
    }
    
    
}

