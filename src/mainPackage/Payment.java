package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener, KeyListener {

    //OBJECTS
    Data_and_Functions data;

    //PANELS
    JPanel receipt = new JPanel();
    JPanel paper = new JPanel();
    JPanel payment = new JPanel();
    JPanel logoline = new JPanel();

    //TEXTS
    JLabel title = new JLabel("Receipt Preview");
    JLabel brand = new JLabel(Settings.businessName);
    JLabel summary = new JLabel("Purchase Summary");

    //CUSTOMER DETAILS
    JLabel customerTitle = new JLabel("Customer Details");
    JLabel orderLabel = new JLabel();
    JLabel customerNameLabel = new JLabel();
    JLabel cno = new JLabel();
    JTextArea cadd = new JTextArea();
    JPanel customerLine = new JPanel();

    JLabel refill = new JLabel();
    JLabel returned = new JLabel();
    JLabel missing = new JLabel();
    JLabel total = new JLabel();
    JLabel thanks = new JLabel("Thank you!");

    JLabel paytitle = new JLabel("How Much Will You Pay?");
    JLabel amount = new JLabel("");
    JLabel cashlabel = new JLabel("Enter Cash Amount");
    JLabel change = new JLabel("Change: ₱0.00");

    //TAGLINES
    JLabel tl1 = new JLabel("Fresh Water. Easy Transactions.");
    JLabel tl2 = new JLabel("Order with Ease.");
    JLabel reminder = new JLabel("Review your receipt before payment.");

    //TEXTFIELDS
    JTextField tfcash = new JTextField();

    //IMAGES
    ImageIcon bgi = new ImageIcon("C:/AquaGo/bg.png");
    ImageIcon logoi = new ImageIcon("C:/AquaGo/logo.png");
    ImageIcon icon = new ImageIcon("C:/AquaGo/icon.png");
    JLabel bg = new JLabel();
    JLabel logo = new JLabel(logoi);

    //BUTTONS
    JButton back = new JButton("← Back");
    JButton confirm = new JButton("Confirm Payment  →");

    //VARIABLES
    String orderID;
    double cash = 0;
    double bal = 0;
    String cName;
    String cContact;
    String cAdd;

    //CONSTRUCTORS
    
    //WITHOUT ADDRESS
    public Payment(Data_and_Functions data, String name, String contact) {
        this(data, name, contact, "");
    }
    
    //WITH ADRESS
    public Payment(Data_and_Functions data, String name, String contact, String address) {
        orderID = data.generateOrderID();
        this.data = data;
        this.cName = name;
        this.cContact = contact;
        this.cAdd = address;

        //FRAME
        setTitle("AquaGo - Payment");
        this.setIconImage(icon.getImage());
        setSize(1650, 927);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#F5F9FD"));

        //RECEIPT PANEL
        this.add(receipt);
        receipt.setLayout(null);
        receipt.setBounds(50, 150, 495, 560);
        receipt.setBackground(Color.decode("#F9FCFF"));
        receipt.setBorder(BorderFactory.createLineBorder(Color.decode("#DCE6F0")));

        //"Receipt Preview"
        receipt.add(title);
        title.setBounds(25, 15, 445, 40);
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(Color.decode("#234B78"));

        //WHITE RECEIPT PAPER
        receipt.add(paper);
        paper.setLayout(null);
        paper.setBounds(20, 65, 455, 475);
        paper.setBackground(Color.WHITE);
        paper.setBorder(BorderFactory.createLineBorder(Color.decode("#E8EEF5")));

        //"AquaGo"
        paper.add(brand);
        brand.setBounds(20, 25, 415, 45);
        brand.setHorizontalAlignment(JLabel.CENTER);
        brand.setFont(new Font("Arial", Font.BOLD, 32));
        brand.setForeground(Color.decode("#2887DC"));

        //"Purchase Summary"
        paper.add(summary);
        summary.setBounds(20, 60, 415, 30);
        summary.setHorizontalAlignment(JLabel.CENTER);
        summary.setFont(new Font("Arial", Font.BOLD, 17));
        summary.setForeground(Color.decode("#28415F"));

        //ORDER ID
        paper.add(orderLabel);
        orderLabel.setBounds(25, 95, 405, 22);
        orderLabel.setFont(new Font("Arial", Font.BOLD, 13));
        orderLabel.setForeground(Color.decode("#234B78"));
        orderLabel.setText("Order ID: " + orderID);

        //CUSTOMER DETAILS
        paper.add(customerTitle);
        customerTitle.setBounds(25, 125, 405, 24);
        customerTitle.setFont(new Font("Arial", Font.BOLD, 15));
        customerTitle.setForeground(Color.decode("#234B78"));

        //FULL NAME
        paper.add(customerNameLabel);
        customerNameLabel.setBounds(25, 150, 405, 25);
        customerNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        customerNameLabel.setForeground(Color.decode("#28415F"));

        //CONTACT NUMBER
        paper.add(cno);
        cno.setBounds(25, 177, 405, 25);
        cno.setFont(new Font("Arial", Font.PLAIN, 15));
        cno.setForeground(Color.decode("#28415F"));

        //ADDRESS
        paper.add(cadd);
        cadd.setBounds(25, 205, 405, 40);
        cadd.setFont(new Font("Arial", Font.PLAIN, 15));
        cadd.setForeground(Color.decode("#28415F"));
        cadd.setEditable(false);
        cadd.setOpaque(false);
        cadd.setFocusable(false);
        cadd.setLineWrap(true);
        cadd.setWrapStyleWord(true);

        //LINE BELOW CUSTOMER DETAILS
        paper.add(customerLine);
        customerLine.setBounds(25, 251, 405, 1);
        customerLine.setBackground(Color.decode("#DCE6F0"));

        //REFILL QUANTITY
        paper.add(refill);
        refill.setBounds(25, 260, 405, 28);
        refill.setFont(new Font("Arial", Font.PLAIN, 17));

        //RETURNED QUANTITY
        paper.add(returned);
        returned.setBounds(25, 294, 405, 28);
        returned.setFont(new Font("Arial", Font.PLAIN, 17));

        //MISSING CONTAINERS
        paper.add(missing);
        missing.setBounds(25, 328, 405, 28);
        missing.setFont(new Font("Arial", Font.PLAIN, 17));

        //TOTAL AMOUNT
        paper.add(total);
        total.setBounds(25, 370, 405, 40);
        total.setFont(new Font("Arial", Font.BOLD, 21));
        total.setForeground(Color.decode("#234B78"));

        //"Thank you"
        paper.add(thanks);
        thanks.setBounds(20, 420, 415, 30);
        thanks.setHorizontalAlignment(JLabel.CENTER);
        thanks.setFont(new Font("Arial", Font.PLAIN, 16));
        thanks.setForeground(Color.decode("#64829B"));

        //PAYMENT PANEL
        this.add(payment);
        payment.setLayout(null);
        payment.setBounds(565, 150, 615, 560);
        payment.setBackground(Color.WHITE);
        payment.setBorder(BorderFactory.createLineBorder(Color.decode("#DCE6F0")));

        //"How Much Will You Pay?"
        payment.add(paytitle);
        paytitle.setBounds(25, 25, 565, 45);
        paytitle.setFont(new Font("Arial", Font.BOLD, 23));
        paytitle.setForeground(Color.decode("#234B78"));

        //PAYMENT AMOUNT
        payment.add(amount);
        amount.setBounds(25, 90, 565, 105);
        amount.setHorizontalAlignment(JLabel.CENTER);
        amount.setOpaque(true);
        amount.setBackground(Color.decode("#EAF3FD"));
        amount.setForeground(Color.decode("#194173"));
        amount.setFont(new Font("Arial", Font.BOLD, 38));

        //"Enter Cash Amount"
        payment.add(cashlabel);
        cashlabel.setBounds(25, 235, 565, 35);
        cashlabel.setFont(new Font("Arial", Font.BOLD, 19));
        cashlabel.setForeground(Color.decode("#28415F"));

        //CASH TEXTFIELD
        payment.add(tfcash);
        tfcash.setBounds(25, 280, 565, 65);
        tfcash.setFont(new Font("Arial", Font.PLAIN, 23));
        tfcash.setBorder(BorderFactory.createLineBorder(Color.decode("#D2E1F0")));

        tfcash.addKeyListener(this);

        //CHANGE DISPLAY
        payment.add(change);
        change.setBounds(25, 395, 565, 90);
        change.setHorizontalAlignment(JLabel.CENTER);
        change.setOpaque(true);
        change.setBackground(Color.decode("#E9F8F0"));
        change.setForeground(Color.decode("#1E7D55"));
        change.setFont(new Font("Arial", Font.BOLD, 26));

        //CONFIRM PAYMENT BUTTON
        this.add(confirm);
        confirm.setBounds(50, 730, 1130, 60);
        confirm.setBackground(Color.decode("#2B84DB"));
        confirm.setForeground(Color.WHITE);
        confirm.setFont(new Font("Arial", Font.BOLD, 22));
        confirm.setBorder(null);
        confirm.setFocusPainted(false);
        confirm.addActionListener(this);

        //BACK BUTTON
        this.add(back);
        back.setBounds(50, 85, 190, 50);
        back.setBackground(Color.decode("#3096DE"));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 21));
        back.setBorder(null);
        back.setFocusPainted(false);
        back.addActionListener(this);

        //LOGO
        this.add(logo);
        Image resizedLogo = logoi.getImage().getScaledInstance(270, 270, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(resizedLogo));
        logo.setBounds(1185, 225, 320, 350);
        //To use a different logo, change the path of logoi under //IMAGES

        //LOGO TAGLINES
        this.add(tl1);
        tl1.setBounds(1185, 575, 320, 35);
        tl1.setHorizontalAlignment(JLabel.CENTER);
        tl1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        tl1.setForeground(Color.decode("#004170"));

        this.add(tl2);
        tl2.setBounds(1185, 612, 320, 30);
        tl2.setHorizontalAlignment(JLabel.CENTER);
        tl2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
        tl2.setForeground(Color.decode("#3096DE"));

        //SMALL LINE
        this.add(logoline);
        logoline.setBounds(1250, 662, 190, 2);
        logoline.setBackground(Color.decode("#B5D4ED"));

        //PAYMENT REMINDER
        this.add(reminder);
        reminder.setBounds(1185, 681, 320, 30);
        reminder.setHorizontalAlignment(JLabel.CENTER);
        reminder.setFont(new Font("Arial", Font.PLAIN, 14));
        reminder.setForeground(Color.decode("#426C8F"));

        //BACKGROUND IMAGE
        this.add(bg);
        bg.setIcon(bgi);
        bg.setBounds(0, 0, 1920, 1080);

        //DISPLAY VALUES
        updateReceipt();

        //DISPLAY FRAME
        setVisible(true);
    }

    //RECEIPT SUMMARY
    public void updateReceipt() {

        //CALCULATE MISSING CONTAINERS
        data.setMissing(data.calculateMissing(
        data.getRefillq(), data.getReturnq()));

        //CALCULATE TOTAL
        data.setTotal(data.calculateTotal(
        data.getRefillq(), data.getMissing()));

        //CALCULATE TOTAL
        bal = data.calculateChange(cash, data.getTotal());

        //DISPLAY CUSTOMER DETAILS
        customerNameLabel.setText("Full Name: " + cName);
        cno.setText("Contact No.: " + cContact);
        if (cAdd.trim().isEmpty()) {
            cadd.setText("Address: Not provided");
        } else {
            cadd.setText("Address: " + cAdd);
        }

        //DISPLAY RECEIPT
        refill.setText(String.format("Water Refill (₱%.2f): %d",Settings.refillPrice, data.getRefillq()));
        returned.setText("Returned Containers: " + data.getReturnq());
        missing.setText(String.format("Missing Containers (₱%.2f): %d",Settings.missingFee, data.getMissing()));
        total.setText(String.format("Total Amount: ₱%.2f", data.getTotal()));
        amount.setText(String.format("₱%.2f", data.getTotal()));

        updateChange();
    }

    //CHANGE CALCULATION
    public void updateChange() {
        try {

            cash = Double.parseDouble(tfcash.getText().trim());

            //CHECK CASH AMOUNT
            if (cash < 0 || Double.isNaN(cash) || Double.isInfinite(cash)) {
                change.setText("Change: ₱0.00");
                return;
            }

            //CALCULATE CHANGE
            bal = cash - data.getTotal();

            if (bal >= 0) {
                change.setText(String.format("Change: ₱%.2f", bal));
            } else {
                change.setText(String.format("Remaining: ₱%.2f", -bal));
            }

        } catch (NumberFormatException e) {
            change.setText("Change: ₱0.00");
        }
    }
    

    //BUTTON FUNCTIONS
    @Override
    public void actionPerformed(ActionEvent e) {

        //BACK BUTTON
        if (e.getSource() == back) {
            new menu();
            dispose();
        }

        //CONFIRM PAYMENT
        if (e.getSource() == confirm) {

            try {
                cash = Double.parseDouble(tfcash.getText().trim());

                //CHECK CASH AMOUNT
                if (cash < 0 || Double.isNaN(cash) || Double.isInfinite(cash)) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid cash amount.");
                    return;
                }

                //INSUFFICIENT CASH
                if (cash < data.getTotal()) {
                    JOptionPane.showMessageDialog(this, "Insufficient cash amount.");
                    return;
                }

                //CHECK QUANTITY
                if (data.getRefillq() <= 0) {
                    JOptionPane.showMessageDialog(this, "Please select a refill quantity first.");
                    return;
                }

                //PAYMENT SUCCESSFUL
                bal = cash - data.getTotal();
                
                //SAVE TRANSACTION TO FILE
                AquagoLoadSave.saveTransaction(orderID, cName, cContact, cAdd,data.getRefillq(), data.getReturnq(), data.getTotal());
                JOptionPane.showMessageDialog(this,
                        String.format("Payment Successful!\nChange: ₱%.2f", bal),
                        "AquaGo", JOptionPane.INFORMATION_MESSAGE);
                data.printReceipt(cash, bal, orderID, cName, cContact, cAdd);
                dispose();
                new startup();
                

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid cash amount.");
            }
        }
    }

    //KEYBOARD FUNCTIONS
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == tfcash) {
            updateChange();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
