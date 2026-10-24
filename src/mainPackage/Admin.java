package mainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {
    
    //IMAGES
    ImageIcon logoi = new ImageIcon("C:/AquaGo/horizontallogo.png");
    ImageIcon icon = new ImageIcon ("C:/AquaGo/icon.png");
    
    //LABEL
        //Image import
        JLabel logo = new JLabel(logoi);
        //Text
        JLabel mess1 = new JLabel("Admin Tab");
        JLabel mess2 = new JLabel("In this section you can track records, customize system, and collect data");
        
    //PANELS
    JPanel rightPanel = new JPanel(new BorderLayout());
    JPanel TRPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JPanel SPanel = new JPanel();
    JPanel logoPanel = new JPanel();

    //BUTTONS
    JButton transactions = new JButton("Transactions");
    JButton remitance = new JButton("Remitance");
    JButton settings = new JButton("Settings");
    JButton logout = new JButton("Logout");

    //COLORS
    Color buttonColor = Color.decode("#174678");
    Color buttonColorUsed = Color.decode("#457FA8");

    //VARIABLES
    Dimension buttonSize = new Dimension(280, 110);

    public Admin() {
        //PREVENT EXTRA ADMIN WINDOWS WHEN TRANSACTIONS OR SETTINGS EXTEND ADMIN
        if (getClass() != Admin.class) {
            return;
        }

        //FRAME SETUP
        this.setIconImage(icon.getImage());
        setTitle("AquaGo (Admin)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 600));
        setLayout(new BorderLayout());
        
        //ADMIN HEADER TEXT
        TRPanel.setLayout(null);
        TRPanel.add(mess1);
        mess1.setBounds(35, 32, 500, 50);
        mess1.setFont(new Font("Arial", Font.BOLD, 32));
        mess1.setForeground(Color.WHITE);

        TRPanel.add(mess2);
        mess2.setBounds(37, 90, 850, 30);
        mess2.setFont(new Font("Arial", Font.PLAIN, 15));
        mess2.setForeground(Color.decode("#D5E7F7"));


        //CONTENT PANEL
        TRPanel.setPreferredSize(new Dimension(0, 170));
        TRPanel.setBackground(Color.decode("#174678"));
        rightPanel.add(TRPanel, BorderLayout.NORTH);
        rightPanel.add(contentPanel, BorderLayout.CENTER);
        TRPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        //SIDE PANEL
        SPanel.setLayout(new BoxLayout(SPanel, BoxLayout.Y_AXIS));
        SPanel.setPreferredSize(new Dimension(280, 0));
        SPanel.setBackground(buttonColor);

        //LOGO PANEL
        logoPanel.setPreferredSize(new Dimension(280, 170));
        logoPanel.setMaximumSize(new Dimension(280, 170));
        logoPanel.setMinimumSize(new Dimension(280, 170));
        logoPanel.setBackground(buttonColor);
        logoPanel.setAlignmentX(0);
        logoPanel.setLayout(null);

        //CENTER LOGO IN THE LOGO PANEL
        logoPanel.add(logo);
        logo.setBounds(15, 25, 250, 120);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        Image scaledLogo = logoi.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(scaledLogo));
        
        //===================================== BUTTONS ====================================================
        
        
        //TRANSACTIONS BUTTON
        transactions.setBackground(buttonColorUsed);
        transactions.setForeground(Color.WHITE);
        transactions.setPreferredSize(buttonSize);
        transactions.setMaximumSize(buttonSize);
        transactions.setAlignmentX(Component.LEFT_ALIGNMENT);
        transactions.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));        
        transactions.setFocusPainted(false);
        transactions.setBorderPainted(false);
        transactions.addActionListener(this);

        //REMITANCE BUTTON
        remitance.setBackground(buttonColor);
        remitance.setForeground(Color.WHITE);
        remitance.setPreferredSize(buttonSize);
        remitance.setMaximumSize(buttonSize);
        remitance.setAlignmentX(Component.LEFT_ALIGNMENT);
        remitance.setFocusPainted(false);
        remitance.setBorderPainted(false);
        remitance.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        remitance.addActionListener(this);

        //SETTINGS BUTTON
        settings.setBackground(buttonColor);
        settings.setForeground(Color.WHITE);
        settings.setPreferredSize(buttonSize);
        settings.setMaximumSize(buttonSize);
        settings.setAlignmentX(Component.LEFT_ALIGNMENT);
        settings.setFocusPainted(false);
        settings.setBorderPainted(false);
        settings.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 0));
        settings.addActionListener(this);
        
        //LOGOUT BUTTON
        logout.setBackground(buttonColor);
        logout.setForeground(Color.WHITE);
        logout.setPreferredSize(buttonSize);
        logout.setMaximumSize(buttonSize);
        logout.setAlignmentX(Component.LEFT_ALIGNMENT);
        logout.setFocusPainted(false);
        logout.setBorderPainted(false);
        logout.addActionListener(this);
        logout.setForeground(Color.decode("#fa7a7f"));
        
        //SIDE PANEL SETUP
        SPanel.add(logoPanel);
        SPanel.add(transactions);
        SPanel.add(remitance);
        SPanel.add(settings);
        SPanel.add(Box.createVerticalStrut(200));
        SPanel.add(logout);

        this.add(SPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);

        //OPEN TRANSACTIONS AUTOMATICALLY
        transactions.doClick();
        setVisible(true);
    }

    //KEPT FOR COMPATIBILITY WITH YOUR EXISTING TRANSACTIONS AND SETTINGS CLASSES
    public JPanel getPanel() {
        return new JPanel();
    }

    public static void main(String[] args) {
        new Admin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TRANSACTIONS
        if (e.getSource() == transactions) {
            transactions.setBackground(buttonColorUsed);
            remitance.setBackground(buttonColor);
            settings.setBackground(buttonColor);

            Admin page = new Transactions();
            rightPanel.removeAll();
            rightPanel.add(TRPanel, BorderLayout.NORTH);
            JScrollPane transactionScroll = new JScrollPane(page.getPanel());
            transactionScroll.setBorder(null);
            rightPanel.add(transactionScroll, BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }

        //REMITANCE
        if (e.getSource() == remitance) {
            transactions.setBackground(buttonColor);
            remitance.setBackground(buttonColorUsed);
            settings.setBackground(buttonColor);
            rightPanel.removeAll();
            rightPanel.add(TRPanel, BorderLayout.NORTH);
            Admin page = new Remitance();
            rightPanel.add(page.getPanel(), BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }

        //SETTINGS
        if (e.getSource() == settings) {
            transactions.setBackground(buttonColor);
            remitance.setBackground(buttonColor);
            settings.setBackground(buttonColorUsed);

            rightPanel.removeAll();
            rightPanel.add(TRPanel, BorderLayout.NORTH);
            Admin page = new Settings();
            JScrollPane settingsScroll = new JScrollPane(page.getPanel());
            settingsScroll.setBorder(null);
            settingsScroll.getVerticalScrollBar().setUnitIncrement(16);
            rightPanel.add(settingsScroll, BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
        
        //LOGOUT
        if (e.getSource() == logout) {
            int choice = JOptionPane.showConfirmDialog(this,"Are you sure you want to log out?","Confirm Logout",JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
            new startup();
            dispose();
            }
        }
    }

}
