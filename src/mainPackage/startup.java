package mainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class startup extends JFrame implements ActionListener {
    //COMPONENTS
        //Panels
        
        //Labbel
        JLabel bg = new JLabel ();
        JLabel logo = new JLabel ();
        JLabel p1 = new JLabel ();
        
        //Text
        JLabel mess1 = new JLabel ("Fresh Water. Easy Transactions.");
        
        //Images 
        ImageIcon bgi = new ImageIcon("C:/AquaGo/bg.png");
        ImageIcon logoi = new ImageIcon("C:/AquaGo/logo.png");
        ImageIcon iconi = new ImageIcon("C:/AquaGo/icon.png");
        
        //BUTTONS
        JButton start = new JButton ("Place an Order");
        JButton staff = new JButton ("<html><u>Use as staff</u></html>");
        
    public startup(){       
        //FRAME SETUP
        setTitle("AquaGo");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setIconImage(iconi.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //COMPONENTS IN FRAME
            
            //Text
            
                //tagline
                this.add(mess1);
                mess1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC ,15));
                mess1.setBounds(650, 460, 350, 100);
                mess1.setForeground(Color.decode("#0072d6"));
            
            //BUTTONS
                
                //Staff button
                this.add(staff);
                staff.setBounds(645, 650, 250, 30);
                staff.setOpaque(false);
                staff.setContentAreaFilled(false);
                staff.setBorderPainted(false);
                staff.setFocusPainted(false);
                staff.setFont(new Font ("SansSerif", Font.BOLD | Font.ITALIC , 17));
                staff.setForeground(Color.decode("#0049a3"));
                
                //start
                this.add(start);
                start.setBounds(620, 563, 300, 70);
                start.setBackground(Color.decode("#008bd6"));
                start.setForeground(Color.white);
                start.setFocusPainted(false);
                start.setBorderPainted(false);
                start.setFont(new Font ("SansSerif", Font.BOLD , 25));
                start.addActionListener(this);
                
            //IMAGE
                
                //logo
                this.add(logo);
                logo.setIcon(logoi);
                logo.setBounds(520,50,500,500);
            
                //bg
                this.add(bg);
                bg.setBounds(0,0,1920,1080);
                bg.setIcon(bgi);
            
        
    }
    
    //ACTION LISTENERS
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == start){
            new menu();
            this.dispose();
        }
    }

    
    public static void main(String[] args) {
        new startup();
    }

    
        
}
