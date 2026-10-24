package mainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JFrame implements ActionListener {
    
    //OBJECTS
        Data_and_Functions func = new Data_and_Functions ();
        double missc;
        
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
        JLabel mess10 = new JLabel ("Fresh Water. Easy Transactions.");
        JLabel mess11 = new JLabel ("Order with Ease.");
        JLabel warn1 = new JLabel ("*This field can't be empty");
        JLabel warn2 = new JLabel ("*This field can't be empty");
        JLabel warn3 = new JLabel ("*Please select a proper order");
        JLabel pesosign = new JLabel("₱");
        
        
        
        //Images
        ImageIcon logoi = new ImageIcon ("C:/AquaGo/logo.png");
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
        public static JTextField tfrefill = new JTextField("0");
        public static JTextField tfreturn = new JTextField("0");
        public static JTextField tfest = new JTextField("00.0");
        
        //IMAGE IMPORT
        JLabel logo = new JLabel(logoi);

        //BUTTONS
        JButton rbplus = new JButton("+");
        JButton rbminus = new JButton("-");
        JButton bplus = new JButton("+");
        JButton bminus = new JButton("-");
        JButton clear = new JButton("Clear");
        JButton proceed = new JButton("Proceed  →");
        JButton back = new JButton("← Back");
        
              
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
            tfname.setFont(new Font("Arial", Font.PLAIN, 17));
            tfname.setForeground(Color.decode("#174678"));
            
            //TF ContactNo.
            this.add(tfno);
            tfno.setBounds(85, 310, 1000, 40);
            tfno.setBackground(Color.decode("#EAF4FC"));
            tfno.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            tfno.setFont(new Font("Arial", Font.PLAIN, 17));
            tfno.setForeground(Color.decode("#174678"));
            
            //TF Address
            this.add(tfadd);
            tfadd.setBounds(85, 400, 1000, 40);
            tfadd.setBackground(Color.decode("#EAF4FC"));
            tfadd.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            tfadd.setFont(new Font("Arial", Font.PLAIN, 17));
            tfadd.setForeground(Color.decode("#174678"));
            
            //TF refill
            this.add(tfrefill);
            tfrefill.setBounds(85, 547, 400, 80);
            tfrefill.setBackground(Color.decode("#EAF4FC"));
            tfrefill.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            tfrefill.setHorizontalAlignment(JTextField.CENTER);
            tfrefill.setEditable(false);
            tfrefill.setFont(new Font("Arial", Font.BOLD, 25));
            tfrefill.setForeground(Color.decode("#004170"));
            
            //TF returned
            this.add(tfreturn);
            tfreturn.setBounds(85, 665, 400, 80);
            tfreturn.setBackground(Color.decode("#EAF4FC"));
            tfreturn.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1, true));
            tfreturn.setHorizontalAlignment(JTextField.CENTER);
            tfreturn.setEditable(false);
            tfreturn.setFont(new Font("Arial", Font.BOLD, 25));
            tfreturn.setForeground(Color.decode("#004170"));
            
            //TF estimated
            this.add(tfest);
            tfest.setBounds(730, 560, 300, 100);
            tfest.setBackground(Color.decode("#F0F7FD"));
            tfest.setBorder(null);
            tfest.setEditable(false);
            tfest.setOpaque(false);
            tfest.setFont(new Font("Arial", Font.BOLD, 70));
            tfest.setForeground(Color.decode("#004170"));
        
            
            
        //WARNING NOTICED
            //Warning 1
            this.add(warn1);
            warn1.setBounds(910,230,200,100);
            warn1.setFont(new Font("Arial",Font.ITALIC, 15));
            warn1.setForeground(Color.WHITE);
            
            //Warning 2
            this.add(warn2);
            warn2.setBounds(910,320,200,100);
            warn2.setFont(new Font("Arial",Font.ITALIC, 15));
            warn2.setForeground(Color.WHITE);
            
            //Warning 3
            this.add(warn3);
            warn3.setBounds(380,475,300,100);
            warn3.setFont(new Font("Arial",Font.ITALIC, 15));
            warn3.setForeground(Color.WHITE);
            
        //TEXTS
            //"Order details"
            this.add(mess1);
            mess1.setFont(new Font("Arial", Font.BOLD, 35));
            mess1.setBounds(80, 75, 300, 80);
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
            mess5.setBounds(87, 485, 270, 80);
            mess5.setForeground(Color.decode("#174678"));
            
            //"Returned"
            this.add(mess6);
            mess6.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 16));
            mess6.setBounds(87, 608, 260, 80);
            mess6.setForeground(Color.decode("#174678"));
            
            //"Est. Price"
            this.add(mess7);
            mess7.setBounds(660, 500, 260, 80);
            mess7.setForeground(Color.decode("#174678"));
            mess7.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 20));
            
            //"Peso sign"
            this.add(pesosign);
            pesosign.setBounds(660, 570, 260, 80);
            pesosign.setForeground(Color.decode("#174678"));
            pesosign.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 70));
            
            //"Price per refill"
            this.add(mess8);
            mess8.setBounds(660, 655, 260, 80);
            mess8.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 17));
            mess8.setForeground(Color.decode("#81A9CB"));
            
            //"Price per missing containers"
            this.add(mess9);
            mess9.setBounds(660, 680, 280, 80);
            mess9.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 17));
            mess9.setForeground(Color.decode("#81A9CB"));
            
            //"Taline"
            this.add(mess10);
            mess10.setBounds(1210,370,300,100);
            mess10.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 17));
            mess10.setForeground(Color.decode("#004170"));
            this.add(mess11);
            mess11.setBounds(1270,400,300,100);
            mess11.setFont(new Font("Arial", Font.ITALIC | Font.BOLD , 17));
            mess11.setForeground(Color.decode("#3095DE"));
            
        //BUTTONS
        
            //REFILL
                // Plus button
                this.add(rbplus);
                rbplus.setBounds(500, 547, 80, 39);
                rbplus.setFont(new Font("Arial", Font.BOLD, 28));
                rbplus.setBackground(Color.decode("#3096DE"));
                rbplus.setForeground(Color.WHITE);
                rbplus.setBorder(BorderFactory.createLineBorder(Color.decode("#3096DE"), 1));
                rbplus.setFocusPainted(false);
                rbplus.addActionListener(this);

                // Minus button
                this.add(rbminus);
                rbminus.setBounds(500, 588, 80, 39);
                rbminus.setFont(new Font("Arial", Font.BOLD, 28));
                rbminus.setBackground(Color.decode("#EAF4FC"));
                rbminus.setForeground(Color.decode("#004170"));
                rbminus.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1));
                rbminus.setFocusPainted(false);
                rbminus.addActionListener(this);
                
            //RETURNED
                // Plus button
                this.add(bplus);
                bplus.setBounds(500, 665, 80, 39);
                bplus.setFont(new Font("Arial", Font.BOLD, 28));
                bplus.setBackground(Color.decode("#3096DE"));
                bplus.setForeground(Color.WHITE);
                bplus.setBorder(BorderFactory.createLineBorder(Color.decode("#3096DE"), 1));
                bplus.setFocusPainted(false);
                bplus.addActionListener(this);

                // Minus button
                this.add(bminus);
                bminus.setBounds(500, 706, 80, 39);
                bminus.setFont(new Font("Arial", Font.BOLD, 28));
                bminus.setBackground(Color.decode("#EAF4FC"));
                bminus.setForeground(Color.decode("#004170"));
                bminus.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1));
                bminus.setFocusPainted(false);
                bminus.addActionListener(this);
                
            //CLEARING
                this.add(clear);
                clear.setBounds(1160, 600, 358, 70);
                clear.setFont(new Font("Arial", Font.BOLD, 21));
                clear.setBackground(Color.decode("#EAF4FC"));
                clear.setForeground(Color.decode("#174678"));
                clear.setBorder(BorderFactory.createLineBorder(Color.decode("#B5D4ED"), 2));
                clear.setFocusPainted(false);
                clear.addActionListener(this);

            //PROCEED
                this.add(proceed);
                proceed.setBounds(1160, 682, 358, 80);
                proceed.setFont(new Font("Arial", Font.BOLD, 22));
                proceed.setBackground(Color.decode("#3096DE"));
                proceed.setForeground(Color.WHITE);
                proceed.setBorder(BorderFactory.createLineBorder(Color.decode("#3096DE"), 1));
                proceed.setFocusPainted(false);
                proceed.addActionListener(this);
            
            //BACK BUTTON
                this.add(back);
                back.setBounds(935, 100, 150, 40);
                back.setFont(new Font("Arial", Font.BOLD, 15));
                back.setBackground(Color.decode("#EAF4FC"));
                back.setForeground(Color.decode("#174678"));
                back.setBorder(BorderFactory.createLineBorder(Color.decode("#D5E7F7"), 1));
                back.setFocusPainted(false);
                back.addActionListener(this);
            
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
            line4.setBounds(660, 670, 380, 3);
            
            //Box 1
            
            //Box 3
            this.add(box3);
            box3.setBounds(630,500,450,250);
            box3.setIcon(box2);

            //Box 2
            this.add(panel);
            panel.setIcon(paneli);
            panel.setBounds(30,50,1150,750);
            
        //IMAGES
            //logo
            this.add(logo);
            logo.setBounds(1140,50,400,400);
            
            //bg
            this.add(bg);
            bg.setIcon(bgi);
            bg.setBounds(0, 0, 1920, 1080);
            
            
            
    }
    
    public static void main(String[] args) {
        new menu();
    }

    //BUTTON FUNCTIONS
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
            //QUANTITY
                //Refilled
                    //plus
                    if (e.getSource() == rbplus){
                        if (func.getRefillq() < 20) {
                            func.setRefillq(func.getRefillq() + 1);
                            func.setReturnq(func.getReturnq() + 1);
                            }
                            func.updateSummary();
                    }
                    //minus
                    //REFILLED MINUS
                    if (e.getSource() == rbminus) {
                        if (func.getRefillq() > 0) {

                        //IF BOTH QUANTITIES ARE EQUAL
                        if (func.getRefillq() == func.getReturnq()) {
                        func.setRefillq(func.getRefillq() - 1);
                        func.setReturnq(func.getReturnq() - 1);

                        } else {
                        //DECREASE REFILLED ONLY
                        func.setRefillq(func.getRefillq() - 1);
                        }
                     }
                        func.updateSummary();
                    }
                         
                //Returned
                    // Plus
                    if (e.getSource() == bplus) {
                        if (func.getReturnq() < 20) {
                            func.setReturnq(func.getReturnq() + 1);
                            } 
                            func.updateSummary();
                            }           
                    // Minus
                    if (e.getSource() == bminus) {
                        if (func.getReturnq() > 0) {
                            func.setReturnq(func.getReturnq() - 1);
                            }

                            func.updateSummary();
                        }
                
                //Clear
                    if (e.getSource() == clear){
                        if(func.getRefillq() != 0 || func.getReturnq() != 0 || !tfname.getText().trim().isEmpty()
                                || !tfno.getText().trim().isEmpty()){
                        int con = JOptionPane.showConfirmDialog(this, "Are you sure you want clear everything?", "Notice", JOptionPane.YES_NO_OPTION);
                        if(con == 0){
                        tfname.setText("  ");
                        tfno.setText("  ");
                        tfadd.setText("  ");
                        func.clearValues();
                        } else {
                            return;
                            }
                        }
                    }
                    
                //Proceed
                    if (e.getSource() == proceed) {

                    //CHECK REFILL
                    if (func.getRefillq() == 0) {
                        warn3.setForeground(Color.decode("#fa7a7f"));
                       } else {
                         warn3.setForeground(Color.WHITE);
                       }

                    //CHECK NAME
                    if (tfname.getText().trim().isEmpty()) {
                         warn1.setForeground(Color.decode("#fa7a7f"));
                       } else {
                        warn1.setForeground(Color.WHITE);
                       }

                    //CHECK IF THE NUMBER IS VALID
                     if (tfno.getText().trim().isEmpty()) {
                        warn2.setText("*This field can't be empty.");
                        warn2.setForeground(Color.decode("#fa7a7f"));
                       } else if (!tfno.getText().trim().matches("[0-9]{11}")){
                            warn2.setText("                *Invalid Number");
                            warn2.setForeground(Color.decode("#fa7a7f"));
                        } else {
                        warn2.setForeground(Color.WHITE);
                        } 

                    //STOP IF ANY FIELD IS INVALID
                    if (func.getRefillq() == 0 || tfname.getText().trim().isEmpty()|| tfno.getText().trim().isEmpty() || !tfno.getText().trim().matches("[0-9]{11}")) {
                    return;
                    }

                    //UPDATE AND PASS VALUES
                    if (tfadd.getText().trim().isEmpty()){
                        func.updateSummary();
                        new Payment(func, tfname.getText().trim(), tfno.getText().trim(), tfadd.getText().trim());
                        dispose();
                    } else {
                        func.updateSummary();
                        new Payment(func, tfname.getText().trim(), tfno.getText().trim());
                        dispose();
                    }
                  }
                  
                   if (e.getSource() == back){
                       dispose();
                       new startup();
                   }
    }

}


