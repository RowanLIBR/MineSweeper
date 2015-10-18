
import javax.swing.ImageIcon;


public class Init 
{
    public static void main(String [] args)
    {
        Difficulty diff = new Difficulty();
        diff.setLocationRelativeTo(null);
        ImageIcon wIcon= new ImageIcon("ibomb.jpg");
        diff.setIconImage(wIcon.getImage());
        diff.setVisible(true);
    }
    
}
