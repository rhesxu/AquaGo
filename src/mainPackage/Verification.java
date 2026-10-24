package mainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Verification extends JFrame implements ActionListener{
    
    //Components===========================================================================================================
    //IMAGES
    ImageIcon bgi = new ImageIcon ("C:/AquaGo/smallbg.png");
    JLabel bg = new JLabel (bgi);
    
    //TEXT
    JLabel mess1 = new JLabel ("Admin Access");
    JLabel mess2 = new JLabel ("Admin panel is exclusively for admins only, enter the correct password to proceed.");
    JLabel mess3 = new JLabel ("Enter Password");
    JLabel warn1 = new JLabel ("*Wrong password.");
    
    //SHAPE 
    JLabel box1 = new JLabel ();
    JLabel line1 = new JLabel();
    JLabel line2 = new JLabel();
    
    //TEXTFIELD
    JPasswordField pf1 = new JPasswordField();
    
    //BUTTONS
    JButton b1 = new JButton ("Proceed →");
    JButton b2 = new JButton ("← Back");
    JCheckBox sp = new JCheckBox ("Show Password");
    
    //START UP VARIABLE FOR MAINTAINING THE FRAME
    startup st;
    
    //Main Constructor======================================================================================================
    public Verification (startup st) {
        super("Admin Access");

        //SETTING PARA MAALALA UNG STARTUP FRAME
        this.st = st;

    //FRAME SETUP
        setSize(800,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        
        //COMPONENTS SET UP
            //TEXT
                //"Admin Access"
                add(mess1);
                mess1.setBounds(150,95,200,100);
                mess1.setFont(new Font("Arial", Font.BOLD , 20));
                mess1.setForeground(Color.decode("#174678"));
                
                //Mess2
                add(mess2);
                mess2.setBounds(150,75,600,200);
                mess2.setFont(new Font("Arial", Font.PLAIN , 13));
                mess2.setForeground(Color.decode("#174678"));
                
                //"Enter Password"
                add(mess3);
                mess3.setBounds(150,160,500,200);
                mess3.setFont(new Font("Arial", Font.BOLD , 12));
                mess3.setForeground(Color.decode("#174678"));
                
                //"WARNING 1
                add(warn1);
                warn1.setBounds(150,265,200,100);
                warn1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC , 12)); 
                warn1.setForeground(Color.WHITE);
                
            //PASSWORD FIELD
                //pf1
                add(pf1);
                pf1.setBounds(150,270,500,30);
            
            //BUTTONS
                //Proceed
                add(b1);
                b1.setBounds(500, 400, 150, 40);
                b1.setBackground(Color.decode("#2B84DB"));
                b1.setForeground(Color.WHITE);
                b1.setBorder(null);
                b1.setFocusPainted(false);
                b1.addActionListener(this);
                
                //Back
                add(b2);
                b2.setBounds(390, 410, 100, 30);
                b2.setBackground(Color.decode("#bbbcbd"));
                b2.setBorder(null);
                b2.setFocusPainted(false);
                b2.addActionListener(this);
                
                //Show Pass
                add(sp);
                sp.setBounds(537, 300, 120, 40);
                sp.setBackground(Color.WHITE);
                sp.setFocusPainted(false);
                sp.addActionListener(this);
                
            //SHAPE
                //line 1
                add(line1);
                line1.setBounds(110,110,4,380);
                line1.setOpaque(true);
                line1.setBackground(Color.decode("#D5E7F7"));
                //line 1
                add(line2);
                line2.setBounds(680,110,4,380);
                line2.setOpaque(true);
                line2.setBackground(Color.decode("#D5E7F7"));
                //box 1
                add(box1);
                box1.setBounds(70,70,650,450);
                box1.setOpaque(true);
                box1.setBackground(Color.white);
            
            
            //IMAGES
                //Background
                add(bg);
                bg.setBounds(0,0,800,600);
                
            setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            
        
        //PROCEED
        if (e.getSource() == b1) {

            String password = new String(pf1.getPassword());

            if (password.trim().isEmpty()) {
                warn1.setText("*Fields can't be empty.");
                warn1.setForeground(Color.decode("#fa7a7f"));
                return;
            }

            if (!password.equals(Settings.adminPassword)) {
                warn1.setText("*Wrong password.");
                warn1.setForeground(Color.decode("#fa7a7f"));
                return;
            }

            //CORRECT PASSWORD
            new Admin();
            dispose();
            st.dispose();
        }


            
            //SHOWPASS
            if (e.getSource() == sp) {
                if (sp.isSelected()) {
                pf1.setEchoChar((char) 0);
            } else {
                pf1.setEchoChar('*');
                }
            }
            
            //BACK
            if (e.getSource() == b2){
                dispose();
            }
    }
}
