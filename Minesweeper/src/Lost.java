import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Lost extends JFrame implements ActionListener 
{
    JPanel youlost;
    JPanel options;
    JButton play;
    JButton exit;
    JLabel lost;
    
    public Lost()
    {
        super();
        
        setSize(300,225);
        setLayout(new GridLayout(2,1));
        youlost = new JPanel();
        
        lost = new JLabel();
        ImageIcon over = new ImageIcon("overs.jpg");
        lost.setIcon(over);
        youlost.add(lost);
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
        options.setBackground(Color.BLACK);
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
