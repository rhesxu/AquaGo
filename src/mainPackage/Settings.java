package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends Admin implements ActionListener {

    //VARIABLES
    static String businessName = "AquaGo Water Refilling";
    static double refillPrice = 25.00;
    static double missingFee = 100.00;
    static boolean confirmation = true;
    
    
    //LOAD SAVED PRICES ON STARTUP
    static {
        double[] prices = AquagoLoadSave.loadPrices();
        refillPrice = prices[0];
        missingFee = prices[1];
    }

    //ADMIN PASSWORD
    static String adminPassword = AquagoLoadSave.loadAdminPassword();

    //TEXTFIELDS
    JTextField tfbusiness = new JTextField();
    JTextField tfrefill = new JTextField();
    JTextField tfmissing = new JTextField();

    //BUTTONS
    JButton save = new JButton("Save Changes");
    JButton reset = new JButton("Reset Fields");
    JButton changepass = new JButton("Change Password");

    //PASSWORD FIELDS
    JPasswordField tfcurrent = new JPasswordField();
    JPasswordField tfnew = new JPasswordField();
    JPasswordField tfconfirm = new JPasswordField();

    //CHECKBOX
    JCheckBox checkconfirm = new JCheckBox("Require confirmation before completing a payment");

    //METHOD OVERRIDING
    @Override
    public JPanel getPanel() {

        //COLORS
        Color navy = Color.decode("#174678");
        Color blue = Color.decode("#3096DE");
        Color lightblue = Color.decode("#EAF4FC");
        Color linecolor = Color.decode("#D5E7F7");
        Color muted = Color.decode("#7694AE");

        //MAIN PANEL
        JPanel mainpanel = new JPanel(null);
        mainpanel.setPreferredSize(new Dimension(1100, 845));
        mainpanel.setBackground(Color.WHITE);

        //--------------------TITLE--------------------
        JLabel title = new JLabel("Settings");
        title.setBounds(35, 35, 450, 48);
        title.setFont(new Font("Arial", Font.BOLD, 33));
        title.setForeground(navy);
        mainpanel.add(title);

        JLabel subtitle = new JLabel("Customize your water refilling station preferences");
        subtitle.setBounds(37, 82, 650, 25);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(muted);
        mainpanel.add(subtitle);

        //--------------------SETTINGS PANEL--------------------
        JPanel settingspanel = new JPanel(null);
        settingspanel.setBounds(35, 130, 1030, 675);
        settingspanel.setBackground(lightblue);
        settingspanel.setBorder(BorderFactory.createLineBorder(linecolor, 1));
        mainpanel.add(settingspanel);

        JLabel businessTitle = new JLabel("Business Configuration");
        businessTitle.setBounds(30, 20, 550, 34);
        businessTitle.setFont(new Font("Arial", Font.BOLD, 22));
        businessTitle.setForeground(navy);
        settingspanel.add(businessTitle);

        //--------------------BUSINESS NAME--------------------
        JLabel namelabel = new JLabel("Business Name");
        namelabel.setBounds(30, 72, 280, 25);
        namelabel.setFont(new Font("Arial", Font.BOLD, 16));
        namelabel.setForeground(navy);
        settingspanel.add(namelabel);

        settingspanel.add(tfbusiness);
        tfbusiness.setBounds(30, 102, 960, 45);
        tfbusiness.setFont(new Font("Arial", Font.PLAIN, 17));
        tfbusiness.setBackground(Color.WHITE);
        tfbusiness.setBorder(BorderFactory.createLineBorder(linecolor));

        //--------------------REFILL PRICE--------------------
        JLabel refilllabel = new JLabel("Price per Refill (PHP)");
        refilllabel.setBounds(30, 172, 380, 25);
        refilllabel.setFont(new Font("Arial", Font.BOLD, 16));
        refilllabel.setForeground(navy);
        settingspanel.add(refilllabel);

        settingspanel.add(tfrefill);
        tfrefill.setBounds(30, 202, 450, 45);
        tfrefill.setFont(new Font("Arial", Font.PLAIN, 17));
        tfrefill.setBackground(Color.WHITE);
        tfrefill.setBorder(BorderFactory.createLineBorder(linecolor));

        //--------------------MISSING CONTAINER FEE--------------------
        JLabel missinglabel = new JLabel("Missing Container Fee (PHP)");
        missinglabel.setBounds(540, 172, 420, 25);
        missinglabel.setFont(new Font("Arial", Font.BOLD, 16));
        missinglabel.setForeground(navy);
        settingspanel.add(missinglabel);

        settingspanel.add(tfmissing);
        tfmissing.setBounds(540, 202, 450, 45);
        tfmissing.setFont(new Font("Arial", Font.PLAIN, 17));
        tfmissing.setBackground(Color.WHITE);
        tfmissing.setBorder(BorderFactory.createLineBorder(linecolor));

        //--------------------ADMIN PASSWORD--------------------
        JLabel passwordTitle = new JLabel("Admin Password");
        passwordTitle.setBounds(30, 270, 350, 30);
        passwordTitle.setFont(new Font("Arial", Font.BOLD, 20));
        passwordTitle.setForeground(navy);
        settingspanel.add(passwordTitle);

        JLabel currentlabel = new JLabel("Current Password");
        currentlabel.setBounds(30, 312, 290, 25);
        currentlabel.setFont(new Font("Arial", Font.BOLD, 15));
        currentlabel.setForeground(navy);
        settingspanel.add(currentlabel);

        settingspanel.add(tfcurrent);
        tfcurrent.setBounds(30, 342, 290, 42);
        tfcurrent.setFont(new Font("Arial", Font.PLAIN, 17));
        tfcurrent.setBorder(BorderFactory.createLineBorder(linecolor));

        JLabel newlabel = new JLabel("New Password");
        newlabel.setBounds(345, 312, 290, 25);
        newlabel.setFont(new Font("Arial", Font.BOLD, 15));
        newlabel.setForeground(navy);
        settingspanel.add(newlabel);

        settingspanel.add(tfnew);
        tfnew.setBounds(345, 342, 290, 42);
        tfnew.setFont(new Font("Arial", Font.PLAIN, 17));
        tfnew.setBorder(BorderFactory.createLineBorder(linecolor));

        JLabel confirmlabel = new JLabel("Confirm New Password");
        confirmlabel.setBounds(660, 312, 330, 25);
        confirmlabel.setFont(new Font("Arial", Font.BOLD, 15));
        confirmlabel.setForeground(navy);
        settingspanel.add(confirmlabel);

        settingspanel.add(tfconfirm);
        tfconfirm.setBounds(660, 342, 330, 42);
        tfconfirm.setFont(new Font("Arial", Font.PLAIN, 17));
        tfconfirm.setBorder(BorderFactory.createLineBorder(linecolor));

        settingspanel.add(changepass);
        changepass.setBounds(790, 400, 200, 43);
        changepass.setBackground(blue);
        changepass.setForeground(Color.WHITE);
        changepass.setFont(new Font("Arial", Font.BOLD, 15));
        changepass.setBorder(null);
        changepass.setFocusPainted(false);
        changepass.addActionListener(this);

        //--------------------TRANSACTION PREFERENCES--------------------
        JLabel preferences = new JLabel("Transaction Preferences");
        preferences.setBounds(30, 461, 500, 30);
        preferences.setFont(new Font("Arial", Font.BOLD, 20));
        preferences.setForeground(navy);
        settingspanel.add(preferences);

        settingspanel.add(checkconfirm);
        checkconfirm.setBounds(30, 498, 700, 30);
        checkconfirm.setFont(new Font("Arial", Font.PLAIN, 15));
        checkconfirm.setForeground(navy);
        checkconfirm.setBackground(lightblue);
        checkconfirm.setFocusPainted(false);

        //--------------------BUTTONS--------------------
        settingspanel.add(reset);
        reset.setBounds(650, 590, 155, 50);
        reset.setFont(new Font("Arial", Font.BOLD, 16));
        reset.setBackground(Color.WHITE);
        reset.setForeground(navy);
        reset.setBorder(BorderFactory.createLineBorder(linecolor));
        reset.setFocusPainted(false);
        reset.addActionListener(this);

        settingspanel.add(save);
        save.setBounds(820, 590, 170, 50);
        save.setFont(new Font("Arial", Font.BOLD, 16));
        save.setBackground(blue);
        save.setForeground(Color.WHITE);
        save.setBorder(null);
        save.setFocusPainted(false);
        save.addActionListener(this);

        //CENTER SETTINGS CONTENT
        JPanel centerpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        centerpanel.setBackground(Color.WHITE);
        centerpanel.setPreferredSize(new Dimension(1200, 900));

        centerpanel.add(mainpanel);

        displayValues();
        return centerpanel;
    }

    //--------------------BUTTON ACTIONS--------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            saveValues();
        } else if (e.getSource() == reset) {
            displayValues();
        } else if (e.getSource() == changepass) {
            changePassword();
        }
    }

    //--------------------DISPLAY SETTINGS--------------------
    public void displayValues() {
        tfbusiness.setText(businessName);
        tfrefill.setText(String.format("%.2f", refillPrice));
        tfmissing.setText(String.format("%.2f", missingFee));
        checkconfirm.setSelected(confirmation);
    }

    //--------------------SAVE SETTINGS--------------------
    public void saveValues() {
        try {
            String name = tfbusiness.getText().trim();
            double refill = Double.parseDouble(tfrefill.getText().trim());
            double missing = Double.parseDouble(tfmissing.getText().trim());

            //Reject empty names, negative prices, and invalid amounts.
            if (name.isEmpty() || refill < 0 || missing < 0
                    || !Double.isFinite(refill) || !Double.isFinite(missing)) {
                JOptionPane.showMessageDialog(null, "Please enter valid, non-negative values.");
                return;
            }

            businessName = name;
            refillPrice = refill;
            missingFee = missing;
            confirmation = checkconfirm.isSelected();
            
            //SAVE PRICES TO TEXT FILE
            AquagoLoadSave.savePrices(refillPrice, missingFee);

            JOptionPane.showMessageDialog(this,"Settings updated!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for prices.");
        }
    }

    //--------------------CHANGE ADMIN PASSWORD--------------------
    public void changePassword() {
        char[] current = tfcurrent.getPassword();
        char[] newpass = tfnew.getPassword();
        char[] confirmnew = tfconfirm.getPassword();

        //CHECK PASSWORD FIELDS
        if (current.length == 0 || newpass.length == 0 || confirmnew.length == 0) {
            JOptionPane.showMessageDialog(null, "Please complete all password fields.");
            return;
        }

        if (newpass.length < 8) {
            JOptionPane.showMessageDialog(null, "New password must be at least 8 characters.");
            return;
        }

        if (!String.valueOf(newpass).equals(String.valueOf(confirmnew))) {
            JOptionPane.showMessageDialog(null, "New passwords do not match.");
            return;
        }

        
        //CHECK CURRENT PASSWORD
        if (!String.valueOf(current).equals(adminPassword)) {
            JOptionPane.showMessageDialog(this, "Incorrect current password.");
            return;
        }

        //SAVE NEW PASSWORD
        adminPassword = String.valueOf(newpass);
        AquagoLoadSave.saveAdminPassword(adminPassword);

        JOptionPane.showMessageDialog(this,
                "Admin password changed successfully!");

        tfcurrent.setText("");
        tfnew.setText("");
        tfconfirm.setText("");

    }

}
