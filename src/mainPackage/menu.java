package mainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JFrame implements ActionListener {
    
    //VARIABLES
        //NUMBERS
        int refillq = 0;
        int returnq = 0;
    //SWING COMPONENTS
        //Texts
        JLabel mess1 = new JLabel ("Order Details");
        JLabel mess2 = new JLabel ("Full Name");
        JLabel mess3 = new JLabel ("Contact No.");
        JLabel mess4 = new JLabel ("Address (Optional)");
        JLabel mess5 = new JLabel ("No. of containers refilled");
        JLabel mess6 = new JLabel ("No. of empty containers returned");
        JLabel mess7 = new JLabel ("Estimated Price");
        JLabel mess8 = new JLabel ("₱25 per Refill");
        JLabel mess9 = new JLabel ("₱100 per Missing Containers");
        
        
        //Images
        ImageIcon logoi = new ImageIcon ("C:/AquaGo/textlogo.png");
        ImageIcon bgi = new ImageIcon ("C:/AquaGo/bg.png");
        ImageIcon paneli = new ImageIcon ("C:/AquaGo/panel.png");
        ImageIcon icon = new ImageIcon ("C:/AquaGo/icon.png");
        ImageIcon box2 = new ImageIcon ("C:/AquaGo/box2.png");
        
        
        //Shapes
        JLabel box1 = new JLabel();
        JLabel bg = new JLabel ();
        JLabel panel = new JLabel ();
        JPanel line1 = new JPanel ();
        JPanel line2 = new JPanel ();
        JPanel line3 = new JPanel ();
        JPanel line4 = new JPanel ();
        JLabel box3 = new JLabel ();
        
        //TEXTFIELDS
        JTextField tfname = new JTextField("  ");
        JTextField tfno = new JTextField("  ");
        JTextField tfadd = new JTextField("  ");
        JTextField tfrefill = new JTextField("0");
        JTextField tfreturn = new JTextField("0");
        JTextField est = new JTextField("₱00.00");
        
        //BUTTONS
        JButton rbplus = new JButton("+");
        JButton rbminus = new JButton("-");
        JButton bplus = new JButton("+");
        JButton bminus = new JButton("-");
        
        
    public menu(){
        //Frame setup
        super("AquaGo");
        this.setIconImage(icon.getImage());
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        //TEXTS FIELDS
            //TF Fullname
            this.add(tfname);
            tfname.setBounds(85, 220, 1000, 40);
            tfname.setBackground(Color.decode("#EAF4FC"));
            tfname.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            
            //TF ContactNo.
            this.add(tfno);
            tfno.setBounds(85, 310, 1000, 40);
            tfno.setBackground(Color.decode("#EAF4FC"));
            tfno.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            
            //TF Address
            this.add(tfadd);
            tfadd.setBounds(85, 400, 1000, 40);
            tfadd.setBackground(Color.decode("#EAF4FC"));
            tfadd.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            
            //TF refill
            this.add(tfrefill);
            tfrefill.setBounds(85, 547, 400, 80);
            tfrefill.setBackground(Color.decode("#EAF4FC"));
            tfrefill.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            tfrefill.setHorizontalAlignment(JTextField.CENTER);
            tfrefill.setEditable(false);
            tfrefill.setFont(new Font("Arial", Font.BOLD, 25));
            tfrefill.setForeground(Color.decode("#004170"));
            
            this.add(tfreturn);
            tfreturn.setBounds(85, 665, 400, 80);
            tfreturn.setBackground(Color.decode("#EAF4FC"));
            tfreturn.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            tfreturn.setHorizontalAlignment(JTextField.CENTER);
            tfreturn.setEditable(false);
            tfreturn.setFont(new Font("Arial", Font.BOLD, 25));
            tfreturn.setForeground(Color.decode("#004170"));
            
            
        //TEXTS
            //"Order details"
            this.add(mess1);
            mess1.setFont(new Font("Arial", Font.BOLD, 35));
            mess1.setBounds(80, 75, 250, 80);
            mess1.setForeground(Color.decode("#004170"));
            
            //"Fullname"
            this.add(mess2);
            mess2.setFont(new Font("Arial", Font.ITALIC, 16));
            mess2.setBounds(90, 160, 100, 80);
            mess2.setForeground(Color.decode("#174678"));
            
            //"Contact No."
            this.add(mess3);
            mess3.setFont(new Font("Arial", Font.ITALIC, 16));
            mess3.setBounds(87, 250, 100, 80);
            mess3.setForeground(Color.decode("#174678"));
            
            //"Contact No."
            this.add(mess4);
            mess4.setFont(new Font("Arial", Font.ITALIC, 16));
            mess4.setBounds(87, 340, 150, 80);
            mess4.setForeground(Color.decode("#174678"));
            
            //"Refilled"
            this.add(mess5);
            mess5.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 16));
            mess5.setBounds(87, 485, 200, 80);
            mess5.setForeground(Color.decode("#174678"));
            
            //"Returned"
            this.add(mess6);
            mess6.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 16));
            mess6.setBounds(87, 608, 260, 80);
            mess6.setForeground(Color.decode("#174678"));
            
            //"Price per refill0"
            this.add(mess8);
            mess8.setBounds(87, 580, 260, 80);
            mess6.setForeground(Color.decode("#174678"));
            
        //BUTTONS
        
            //REFILL
                // Plus button
                rbplus.setBounds(500, 547, 80, 38);
                this.add(rbplus);
                rbplus.setFont(new Font("Arial", Font.BOLD, 30));
                rbplus.setBackground(Color.decode("#7ac3fa"));
                rbplus.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
                rbplus.addActionListener(this);
                rbplus.setForeground(Color.white);

                // Minus button
                rbminus.setBounds(500, 590, 80, 38);
                this.add(rbminus);
                rbminus.setFont(new Font("Arial", Font.BOLD, 35));
                rbminus.setBackground(Color.decode("#7ac3fa"));
                rbminus.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
                rbminus.addActionListener(this);
                rbminus.setForeground(Color.white);
                
            //RETURNED
                // Plus button
                bplus.setBounds(500, 665, 80, 38);
                this.add(bplus);
                bplus.setFont(new Font("Arial", Font.BOLD, 30));
                bplus.setBackground(Color.decode("#7ac3fa"));
                bplus.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
                bplus.addActionListener(this);
                bplus.setForeground(Color.white);

                // Minus button
                bminus.setBounds(500, 707, 80, 38);
                this.add(bminus);
                bminus.setFont(new Font("Arial", Font.BOLD, 35));
                bminus.setBackground(Color.decode("#7ac3fa"));
                bminus.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
                bminus.addActionListener(this);
                bminus.setForeground(Color.white);
            
        //SHAPE
            //Line 1
            this.add(line1);
            line1.setBackground(Color.decode("#D5E7F7"));
            line1.setBounds(85, 160, 1000, 2);
            
            //Line 2
            this.add(line2);
            line2.setBackground(Color.decode("#D5E7F7"));
            line2.setBounds(85, 475, 1000, 2);
            
            //Line 3
            this.add(line3);
            line3.setBackground(Color.decode("#D5E7F7"));
            line3.setBounds(600, 500, 3, 260);
            
            //Line 4
            this.add(line4);
            line4.setBackground(Color.decode("#D5E7F7"));
            line4.setBounds(660, 700, 380, 3);
            
            //Box 1
            
            //Box 3
            this.add(box3);
            box3.setBounds(630,500,450,250);
            box3.setIcon(box2);

            //Box 2
            this.add(panel);
            panel.setIcon(paneli);
            panel.setBounds(30,50,1150,750);
            
        //BACKGROUND
            //bg
            this.add(bg);
            bg.setIcon(bgi);
            bg.setBounds(0, 0, 1920, 1080);
            
            //logo
            
    }
    
    public static void main(String[] args) {
        new menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            //QUANTITY
                //Refilled
                    //plus
                    if (e.getSource() == rbplus){
                        if (refillq >= 20){
                            return;
                        }
                        refillq++;
                        tfrefill.setText(String.valueOf(refillq));
                    }
                    //minus
                    if (e.getSource() == rbminus){
                        if (refillq == 0){
                            return;
                        }
                        refillq--;
                        tfrefill.setText(String.valueOf(refillq));
                    }
                    
                //Returned
                    if (e.getSource() == bplus){
                        if (returnq >= 20){
                            return;
                        }
                        returnq++;
                        tfreturn.setText(String.valueOf(returnq));
                    }
                    //minus
                    if (e.getSource() == bminus){
                        if (returnq == 0){
                            return;
                        }
                        returnq--;
                        tfreturn.setText(String.valueOf(returnq));
                    }
    }
}
